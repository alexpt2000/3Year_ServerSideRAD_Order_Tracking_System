<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Display Errors</title>
</head>
<body>

	<h1>Error Creating the following Order</h1>

	<form:form modelAttribute="errMsg">

		<h2>${errMsg.msg}</h2>

	</form:form>

	<form:form modelAttribute="order">

		<table>
			<tr>
				<th>Product ID</th>
				<th>Customer ID</th>
				<th>Quantity</th>
			</tr>

			<tr>
				<td>${order.prod.pId}</td>
				<td>${order.cust.cId}</td>
				<td>${order.qty}</td>
			</tr>

		</table>

	</form:form>

	<table>
		<tr>
			<td><a href="/">Home</a></td>
			<td><a href="/addOrder">Add Orders</a></td>
			<td><a href="/showOrders">List Orders</a></td>
		</tr>
	</table>


</body>
</html>