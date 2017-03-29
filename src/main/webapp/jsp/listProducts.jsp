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

	<h1>List of Products</h1>

	<table border="1">
		<tr>
			<th>Product ID</th>
			<th>Description</th>
			<th>Quantity in Stock</th>
		</tr>
		<c:forEach items="${productsForm}" var="prod">
			<tr>
				<td>${prod.pId}</td>
				<td>${prod.pDesc}</td>
				<td>${prod.qtyInStock}</td>
			</tr>
		</c:forEach>

	</table>
	<table>
		<tr>
			<td><a href="/">Home</a></td>
			<td><a href="/addProduct">Add Products</a></td>
			<td><a href="/showCustomers">List Customers</a></td>
			<td><a href="/showOrders">List Orders</a></td>
			<td><a href="/logout">Logout</a></td>
		</tr>
	</table>


</body>
</html>