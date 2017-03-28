<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Display Address</title>
</head>
<body>

	<h1>List of Address</h1>

	<table>
		<c:forEach items="${addressForm}" var="add">
			
				<td><h3>${add.aid}</h3></td>
				<td><h3>${add.town}</h3></td>
				<td><h3>${add.county}</h3></td>
				<tr>
					<c:forEach items="${add.customersWithThisAddress}" var="cos">
						<tr></tr>
						<td>${cos.cId}</td>
						<td>${cos.cName}</td>
					</c:forEach>

				</tr>			
		</c:forEach>
	</table>

</body>
</html>