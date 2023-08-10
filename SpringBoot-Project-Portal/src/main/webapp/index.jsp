<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/dashbord/user.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Interface</title>
</head>
<body>

	<h1>Library Portal</h1>

	<div class="img">
		<div class="adim_img">
			<h2>ADMIN</h2>
			<a href="./admin/login"> <img src="admin.jpg " alt="Click for Admin Login."
				></a>
		</div>
		<div class="std_img">
			<h2>STUDENT</h2>
			<a href="./student/login"><img src="student.jpg" alt="Click for Student Login."></a>
		</div>
	</div>
</body>
</html>