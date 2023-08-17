<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Search Result</title>
</head>
<body>
	<c:choose>
		<c:when test="${product ne null || ! empty product }">
		<br/><br/><h1 style='color:green; text-align:center;'>PRODUCT DETAILS</h1>
		<center> <table > 
		<tr>
		<h2><td>Product ID </td>
		<td> :: ${product.serialNo }</td></h2>
		</tr>
		
		<tr>
		<h2><td>Product NAME </td>
		<td> :: ${product.pName }</td></h2>
		</tr>
		
		<tr>
		<h2><td>Product RATE </td>
		<td> :: ${product.pRate }</td></h2>
		</tr>
		
		<tr>
		<h2><td>Product QUANTITY </td>
		<td> :: ${product.pQty }</td></h2>
		</tr>
		 </table> 
		 <br/><br/>
		 <a href='../searchForm.html'>Home Page</a>
		</center>
		</c:when>
		
		<c:otherwise>
		<br/><br/><br/>
		<h1 style='color:red; text-align:center;'>PRODUCT NOT AVAILABLE WITH ID :: ${ param.serialNo}</h1>
		<br/><br/><center><a href='../searchForm.html'>Home Page</a></center>
		</c:otherwise>
	
	</c:choose>
</body>
</html>