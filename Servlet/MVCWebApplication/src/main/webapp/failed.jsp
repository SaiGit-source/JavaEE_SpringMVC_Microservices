<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Failure</title>
</head>
<body bgcolor="red" style="align-content: center">
<h1>Welcome to our Dynamic web application using JSP</h1>
<h2><marquee>Dynamic response generated!</marquee></h2>
<h2>SignUp failed!!! Sorry</h2>
<% String name = (String)session.getAttribute("name"); %>
<h2>Hey <%=name %>, you failed to register to this webapp</h2>
</html>