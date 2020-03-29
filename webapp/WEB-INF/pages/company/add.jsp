<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add:city</title>

<script type="text/javascript">
// 	.error{
// 		color: red;
// 	}
</script>
</head>
<body>

	<c:set value="${pageContext.request.contextPath}" var="contextPath"></c:set>
	<c:url value = "/company/save" var = "companySave"></c:url>

	<jsp:include page="home.jsp"></jsp:include>

	<br />
	<form:form action="${companySave}" method="post" modelAttribute="companyDto">
		Company name:<form:input type="text" path="name" id="name"/>
		<br />
		<form:errors path = "name" cssClass = "error"/>
		<p/>
		Company address:<form:input type="text" path="address" id="address"/>
		<br />
		<form:errors path = "address" cssClass = "error"/>
		<p/>
		Company number:<form:input type="text" path="number" id="number"/>
		<br />
		<form:errors path = "number" cssClass = "error"/>
		<p/>
		City: <form:select path="cityDto">
		<form:option value="" label = "Izaberi grad"/>
		<form:options items = "${cityDtos}" itemValue="number" itemLabel="name"/>
		</form:select>
		
		<button id="save">Save</button> 
	</form:form>
	
	
</body>
</html>