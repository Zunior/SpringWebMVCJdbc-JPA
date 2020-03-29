<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index</title>
</head>
<body>
	
	<c:set value="${pageContext.request.contextPath}" var="contextPath"></c:set>
	<c:url value = "/city" var = "city"></c:url>
	<c:url value = "/company" var = "company"></c:url>
	
	<div>Welcome to MVC web application</div>
	<br />
	<a href = "<c:out value = "${city}" />">City manipulation page</a>
	<br />
	<a href = "<c:out value = "${company}" />">Company manipulation page</a>
	<br />
	<div>
		=============================================================================
	</div>

	
	
	
</body>
</html>