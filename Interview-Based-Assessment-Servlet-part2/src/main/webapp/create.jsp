<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
  <h1>Create New Blog Post</h1>
    <form action="./created" method="post">
        Title: <input type="text" name="title"><br>
        Description: <input type="text" name="description"><br>
        Content: <textarea name="content"></textarea><br>
        <input type="submit" value="Create Post">
    </form>
</center>
</body>
</html>