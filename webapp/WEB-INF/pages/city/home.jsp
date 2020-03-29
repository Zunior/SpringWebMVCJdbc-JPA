<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home: city</title>
</head>
<body>

	<c:set value="${pageContext.request.contextPath}" var="contextPath"></c:set>

	<jsp:include page="../index.jsp"></jsp:include>
	<br />
	City manipulation page
	<br />
	<c:url value = "/city/add" var = "cityAdd"></c:url>
	<c:url value = "/city/list" var = "cityList"></c:url>
	
	
	<a href = "<c:out value = "${cityAdd}" />">Add city</a>
	<br />
	<a href = "<c:out value = "${cityList}" />">City list</a>
	<div>
		=============================================================================
	</div>
	<div><c:out value="${obavestenje}"></c:out></div>
	
	
	

</body>
</html>