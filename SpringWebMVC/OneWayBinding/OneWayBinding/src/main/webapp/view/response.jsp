<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Application response</title>
</head>
<body bgcolor="green" style="align-content: center">
<center>
	<h1>Registration Successful</h1>
	<h2 style='color:blue; text-align:center'>Employee ID is : ${empKey.eid}</h2>
	<h2 style='color:cyan; text-align:center'>Employee Name is : ${empKey.ename}</h2>
	<h2 style='color:red; text-align:center'>Employee City is : ${empKey.ecity}</h2>
	<h2 style='color:yellow; text-align:center'>Employee Email is : ${empKey.eemail}</h2>
	<h2 style='color:black; text-align:center'>Employee Salary is : ${empKey.esalary}</h2>
</center>



</body>
</html>