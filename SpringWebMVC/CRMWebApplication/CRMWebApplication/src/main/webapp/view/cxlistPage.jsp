<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer List Page</title>
</head>
<title>Application response</title>
<link type=text/css rel="stylesheet" href="./style.css">
</head>
<body bgcolor="green" style="align-content: center">
<A href="registration">Click to register new customer</A>
<center>
	<h1 style='color:blue; text-align:center'>Customer List Data</h1>
	<table border="1">
	
	   	<tr>
    	<th>First Name</th>
    	<th>Last Name</th>
    	<th>City</th>
    	<th>Update Data</th>
    	<th>Delete Data</th>
    	</tr>
		
		<c:forEach var="custRec"  items="${cxlistKey}">
		 <c:url var="UpdateCust" value="/updateRecord"> 
    	 <c:param name="cxid" value="${custRec.cid}"></c:param></c:url>
    	 <!--  this will take cxid to the 'updateRecord' page -->
    	 <c:url var="DeleteCust" value="/deleteRecord"> 
    	 <c:param name="cxid" value="${custRec.cid}"></c:param></c:url>
    	 <!--  it puts cxid onto 'deleteRecord' url -->
		
	    	      <tr>
    	           <td>${custRec.cfirstName}</td>
    	           <td>${custRec.clastName}</td>
    	           <td>${custRec.ccity}</td>   
    	           <td><a href="${UpdateCust}">Update Record</a> </td>
    	           <td><a href="${DeleteCust}">Delete Record</a> </td>
    	          </tr> 
    	 </c:forEach>
    </table>
</center>

</body>
</html>