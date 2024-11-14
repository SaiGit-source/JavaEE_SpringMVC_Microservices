<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Update Form</title>
<link type=text/css rel="stylesheet" href="./style.css">
</head>

<body bgcolor="yellow" style="align-content: center">
<h2>Customer Update Form</h2>
	<form:form action="registerCustomer" modelAttribute="custRecordKey">
	<!-- modelAttribute="custRecordKey" this will make sure customer record is accessible in this page -->
	<!--  when you hit submit, it will take to registerCustomer link to update record  -->
		<table>
		          <form:hidden path="cid"/> <!-- this is important otherwise same id is not getting updated -->
			<tr>
				<td> Customer ID </td>
					<td> ${custRecordKey.cid} </td> 
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
				<td> <input type="submit" value="Update"> </td>
			</tr>
		</table>
	</form:form>
</body>
</html>