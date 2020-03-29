<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>City list</title>
</head>
<body>

	<c:url var="listCityURL" value="/city/list"/>
	<jsp:include page="home.jsp"></jsp:include>
	
	City list:
	<br />
	<table>
		<thead>
			<tr>
				<th>Number</th>
				<th>Name</th>  
			</tr>
		</thead>
			<tbody>
				<c:forEach items="${cityDtos}" var="cityDto">
					<tr>
						<td>${cityDto.getNumber()}<br/></td>
						<td>${cityDto.getName()}<br/></td>
					</tr>
				</c:forEach>
			</tbody>
	</table>
	
</body>
</html>