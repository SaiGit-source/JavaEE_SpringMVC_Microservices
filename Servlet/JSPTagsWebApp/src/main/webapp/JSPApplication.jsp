<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Web Application</title>
</head>
<body>
<h1>JSP Web App to generate Dynamic response</h1>
<!--  behind the scene, JSP file is getting converted to Servlet and Servlet is getting deployed onto Server -->
<!--  whatever view pages we want to show to client anything like Registration etc can be written in JSP -->

<!--  import statements in jsp, we write a tag that's directive tag -->
<%@ page import="java.util.Date"
import="java.io.PrintWriter"
%>

<!-- declaration tag: all declaration can be written here -->
<% 
	int age = 28;
%>

<!--  within Scriptlet tag, whatever code you want to write -->
<!--  the code we write here will be considered as body of a service() method -->
<%
	String name=request.getParameter("uname");
	String city=request.getParameter("ucity");
	Date date=new Date();
	out.println(date);
	out.println("\nHello "+name);
	out.println("\nI know you are from "+city);
	PrintWriter writer=response.getWriter();
%>

<h1><%=date %></h1>
<h2><%=city %></h2>
<h3>Hello your age is <%= age %></h3>

</body>
</html>