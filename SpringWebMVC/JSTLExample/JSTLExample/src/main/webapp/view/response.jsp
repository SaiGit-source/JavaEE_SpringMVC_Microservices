<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTLArrays</title>
</head>
<body>
<center>
	<h1 style='color:blue; text-align:center'>Displaying Data From an Array/Collection</h1>
	<h2><c:forEach var="bookName"  items="${booksKey}">${bookName}, </c:forEach></h2>
</center>

</body>
</html>