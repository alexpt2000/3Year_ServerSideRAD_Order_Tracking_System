<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add New Customer</title>
</head>
<body>

	<h1>Add New Customer</h1>

	<form:form modelAttribute="customer">
		<table>
			<tr>
				<td>Customer Name:</td>
				<td><form:input path="cName"></form:input></td>
				<td><form:errors path="cName"></form:errors></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="Add" /></td>
			</tr>
		</table>
		<table>
			<tr>
				<td><a href="/">Home</a></td>
				<td><a href="/showOrders">List Orders</a></td>
				<td><a href="/showProducts">List Products</a></td>
			</tr>
		</table>
	</form:form>


</body>
</html>