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
		<c:forEach items="${customersForm}" var="cos">

			<h3>${cos.cId}  ${cos.cName}</h3>
			<h4>${cos.cName}'s Orders</h4>
			
			<table border="1">
				<tr>
					<th>Order ID</th>
					<th>Quantity</th>
					<th>Product ID</th>
					<th>Description</th>
				</tr>
					<c:forEach items="${cos.orders}" var="ord">
						<tr></tr>
						<td>${ord.oId}</td>
						<td>${ord.qty}</td>
						<td>${ord.prod.pId}</td>
						<td>${ord.prod.pDesc}</td>
					</c:forEach>
			</table>
			
						
		</c:forEach>
	</table>
	
		<table>
		<tr>
			<td><a href="/">Home</a></td>
			<td><a href="/addCustomer">Add Customers</a></td>
			<td><a href="/showProducts">List Products</a></td>
			<td><a href="/showOrders">List Orders</a></td>
			<td><a href="/logout">Logout</a></td>
		</tr>
	</table>

</body>
</html>