<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Company list</title>
</head>
<body>

	<c:url var="listCompanyURL" value="/company/list"/>
	<jsp:include page="home.jsp"></jsp:include>
	
	Company list:
	<br />
	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Address</th>
				<th>Number</th>   
			</tr>
		</thead>
			<tbody>
				<c:forEach items="${companyDtos}" var="companyDto">
					<tr>
						<td>${companyDto.getName()}<br/></td>
						<td>${companyDto.getAddress()}<br/></td>
						<td>${companyDto.getNumber()}<br/></td>
					</tr>
				</c:forEach>
			</tbody>
	</table>
	
</body>
</html>