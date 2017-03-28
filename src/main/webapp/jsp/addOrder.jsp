<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>New Order</h1>

	<form:form modelAttribute="order">
		<table>
			<tr>
				<td>Customer ID:</td>
				<td><form:input path="cust.cId"></form:input></td>
				<td><form:errors path="cust.cId"></form:errors></td>
			</tr>

			<tr>
				<td>Product ID:</td>
				<td><form:input path="prod.pId"></form:input></td>
				<td><form:errors path="prod.pId"></form:errors></td>
			</tr>
			
			<tr>
				<td>Quantity:</td>
				<td><form:input path="qty"></form:input></td>
				<td><form:errors path="qty"></form:errors></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="Add" /></td>
			</tr>
		</table>
		<table>
			<tr>
				<td><a href="/">Home</a></td>
				<td><a href="/showOrders">List Orders</a></td>
				<td><a href="/showCustomers">List Customers</a></td>
				<td><a href="/showProducts">List Products</a></td>
			</tr>
		</table>
	</form:form>


</body>
</html>