<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Display Customers</title>
</head>
<body>

	<h1>List of Customers</h1>

	<table>
		<tr>
			<th>Customer ID</th>
			<th>Name</th>
			<th>Town</th>
			<th>County</th>
		</tr>
		<c:forEach items="${customerForm}" var="cust">
			<tr>
				<td>${cust.cId}</td>
				<td>${cust.cName}</td>
				<td>${cust.cAddr.town}</td>
				<td>${cust.cAddr.county}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>