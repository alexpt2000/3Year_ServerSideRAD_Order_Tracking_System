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

	<h1>List of Orders</h1>

	<table>
		<c:forEach items="${ordersForm}" var="ord">

			<h3>${ord.oId}</h3>

			
			<table border="1">
				<tr>
					<th>Quantity</th>
					<th>Order Date</th>
					<th>Customer ID</th>
					<th>Customer Name</th>
					<th>Product ID</th>
					<th>Description</th>
				</tr>

				<tr>
					<td>${ord.qty}</td>
					<td>${ord.orderDate}</td>
					<td>${ord.cust.cId}</td>
					<td>${ord.cust.cName}</td>
					<td>${ord.prod.pId}</td>
					<td>${ord.prod.pDesc}</td>
				</tr>

			</table>
			
						
		</c:forEach>
	</table>
	
		<table>
		<tr>
			<td><a href="/">Home</a></td>
			<td><a href="/addOrder">Add Orders</a></td>
			<td><a href="/showProducts">List Products</a></td>
	    	<td><a href="/showCustomers">List Customers</a></td>
			<td><a href="/logout">Logout</a></td>
		</tr>
	</table>

</body>
</html>