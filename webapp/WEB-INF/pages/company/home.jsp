<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home: company</title>
</head>
<body>

	<c:set value="${pageContext.request.contextPath}" var="contextPath"></c:set>
	<c:url value = "/company/add" var = "companyAdd"></c:url>
	<c:url value = "/company/list" var = "companyList"></c:url>

	<jsp:include page="../index.jsp"></jsp:include>
	<br />
	Company manipulation page
	<br />
	<a href = "<c:out value = "${companyAdd}" />">Add company</a>
	<br />
	<a href = "<c:out value = "${companyList}" />">Company list</a>
	<div>
		=============================================================================
	</div>
	<div><c:out value="${obavestenje}"></c:out></div>

</body>
</html>