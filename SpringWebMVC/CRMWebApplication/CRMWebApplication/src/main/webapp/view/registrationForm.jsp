<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Registration Form</title>
<link type=text/css rel="stylesheet" href="./style.css">
</head>

<body bgcolor="yellow" style="align-content: center">
<h2>Customer Registration Form</h2>
	<form:form action="registerCustomer" modelAttribute="custKey">
		<table>
			<tr>
				<td> Customer ID </td>
				<td> Auto-generated </td>
			</tr>
		
			<tr>
				<td> Customer FirstName </td>
				<td> <form:input path="cfirstName"></form:input></td>
			</tr>
			
			<tr>
				<td> Customer LastName </td>
				<td> <form:input path="clastName"></form:input></td>
			</tr>
									
			<tr>
				<td> Customer City </td>
				<td> <form:input path="ccity"/></td>
			</tr>
			
			<tr>
				<td> <input type="submit" value="Register"> </td>
			</tr>
		</table>
	</form:form>
</body>
</html>