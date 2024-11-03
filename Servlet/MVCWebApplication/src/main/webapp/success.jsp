<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Success</title>
</head>
<body bgcolor="green" style="align-content: center">
<h1>Welcome to our Dynamic web application using JSP</h1>
<h2><marquee>Dynamic response generated!</marquee></h2>
<h2>SignUp successful!!!</h2>
<% 	String name = (String)session.getAttribute("name"); 
	String email = (String)session.getAttribute("email"); 
%>

<h2>Congratulations <%= name %>, you have registered to this webapp</h2>
<h2>Your registered email is <%= email %></h2>
</html>