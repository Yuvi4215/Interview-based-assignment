<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link type="text/css" rel="stylesheet"  href="${pageContext.request.contextPath}/login/login.css"  />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Login</title>
</head>
<body bgcolor="#BFC9CA">

	<div class="card">
		<div class="card-header">
			<div class="text-header"> Login</div>
		</div>
		<div class="card-body">
			<form action="./dashboard" method="post">
				<div class="form-group">
					<label for="libraryId">Library Id:</label> <input 
						class="form-control" name="libraryId" id="libraryId" type="text" required >
				</div>
				<div class="form-group">
					<label for="password">Password:</label> <input 
						class="form-control" name="password" id="password" type="password" required>
						<input type="checkbox" onclick="toggleVisibility()" />
				</div>
			<p class="signin">
					Don't have an acount ? <a href="./signUp" style="color: red;">Signup</a>
				</p>
				<input type="submit" class="btn" value="submit">
			<details>
	<summary>Condition</summary>
	Password should have at least 8 characters.
</details>
			</form>
		</div>
	</div>
	<script>
   function toggleVisibility() {  
  var getPasword = document.getElementById("password");  
  if (getPasword.type === "password") {  
    getPasword.type = "text";  
  } else {  
    getPasword.type = "password";  
  }  
}   
   </script>
</body>
</html>