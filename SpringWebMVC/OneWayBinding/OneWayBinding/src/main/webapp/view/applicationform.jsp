<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Registration Form</title>
</head>
<body bgcolor="yellow" style="align-content: center">
<h2>Employee Registration Form</h2>
<form method="post">
	<table>
		<tr>
			<td> Employee ID </td>
			<td> <input type="text" name="eid"></td>
		</tr>
	
		<tr>
			<td> Employee Name </td>
			<td> <input type="text" name="ename"></td>
		</tr>
				
		<tr>
			<td> Employee Email ID </td>
			<td> <input type="text" name="eemail"></td>
		</tr>
				
		<tr>
			<td> Employee City </td>
			<td> <input type="text" name="ecity"></td>
		</tr>
		
		<tr>
			<td> Employee Salary </td>
			<td> <input type="text" name="esalary"></td>
		</tr>
		
		<tr>
			<td> <input type="submit" value="SignUp"> </td>
		</tr>
	</table>
</form>


</body>
</html>