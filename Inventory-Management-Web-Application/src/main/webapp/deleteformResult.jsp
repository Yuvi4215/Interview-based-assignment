<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Delete Page</title>
</head>
<body>
	<c:choose>
		<c:when test="${status eq 'success' }">
		"<br/><br/><br/><h1 style='color:green; text-align:center;'>RECORD DELETED SUCCESFULLY</h1>
		<center><br/><a href='../deleteForm.html'>Home Page</a></center>
		</c:when>
		
		<c:when test="${status eq 'failled' }">
		<br/><br/><br/><h1 style='color:red; text-align:center;'>REGISTRATION FAILLED</h1>
		<center><br/><a href='../deleteForm.html'>Home Page</a></center>
		</c:when>
	
		<c:otherwise>
		<br/><br/><br/><h1 style='color:gray; text-align:center;'>RECORD NOT FOUND</h1>
		<center><br/><a href='../deleteForm.html'>Home Page</a></center>
		</c:otherwise>
	</c:choose>
</body>
</html>