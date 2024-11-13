<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Add SpringTag for two-way binding -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Registration Form</title>
</head>
<body bgcolor="yellow" style="align-content: center">
<h2>Employee Registration Form</h2>
<form:form method="post" modelAttribute="emp">
	<table>
		<tr>
			<td> Employee ID </td>
			<td> <form:input path="eid"/></td>
		</tr>
	
		<tr>
			<td> Employee Name </td>
			<td> <form:input path="ename"></form:input></td>
		</tr>
								
		<tr>
			<td> Employee City </td>
			<td> <form:input path="ecity"/></td>
		</tr>
		
		<tr>
			<td> Employee Salary </td>
			<td> <form:input path="esalary"/></td>
		</tr>
		
		<tr>
			<td> <input type="submit" value="SignUp"> </td>
		</tr>
	</table>
</form:form>
</body>
</html>