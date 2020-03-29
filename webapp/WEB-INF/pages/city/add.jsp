<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add:city</title>

<script type="text/javascript"></script>
<style type="text/css">
	.error{
		color: red;
	}
</style>
	

</head>
<body>

	<c:set value="${pageContext.request.contextPath}" var="contextPath"></c:set>
	<c:url value = "/city/save" var = "citySave"></c:url>

	<jsp:include page="home.jsp"></jsp:include>

	<form:form action="${citySave}" method="post" modelAttribute="cityDto">
		City number:<form:input type="text" path="number" id="numberId"/>
		<br />
			<form:errors path = "number" cssClass = "error"/>
		<p/>
		City name:<form:input type="text" path="name" id="nameId"/>
		<br />
			<form:errors path = "name" cssClass = "error"/>
		<p/>
		
		<button id="save">Save</button> 
	</form:form>
	
	
</body>
</html>