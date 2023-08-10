<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/css/dashboard.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="header">
		<h1>Library Portal</h1>
		<p>
			Student ::
			<marquee>${student}</marquee>
		</p>
	</div>

	<div class="row">
		<div class="bodnav">
			<div class="img">
		<div class="admin_img">
			<img alt="Student Profile" src="../student.jpg" >
		</div>
		</div>
		
			<div>
				<a href="${pageContext.request.contextPath}/student/home" >Home</a>
			</div>
			<div>
				<a href="${pageContext.request.contextPath}/student/search" >Search Book</a>
			</div>
			<div>
				<a href="${pageContext.request.contextPath}/student/bookList" >All Books List</a>
			</div>
			<div>
				<a href="${pageContext.request.contextPath}/student/pending" >My Request</a>
			</div>
			<div>
				<a href="${pageContext.request.contextPath}/student/borrowed" >Borrowed books</a>
			</div>
			<div>
				<a href="${pageContext.request.contextPath}/student/fine" >Fine</a>
			</div>
			<div>
				<a href="${pageContext.request.contextPath}/student/logout" >Logout</a>
			</div>
		</div>

			<div class="bod content">
			<h2>Main Content</h2>
			<p style="font-weight: bold;">1. Book Search Based on ISBN,
				Title, Author, and Genre:</p>
			<p>* ISBN search allows finding specific books using a unique
				identifier, providing detailed information about the book.<br/> * Title
				search helps find books by their name, useful when the exact title
				is known but other details are not.<br/> * Author search enables
				discovering books written by a specific author.<br/> * Genre search
				assists in locating books within a particular category, such as
				fiction, educational, or science fiction</p>

			<p style="font-weight: bold;">2. See Book Requested by Student
				and Status is Pending:</p>

			<p>* Students can request books, and administrators can view
				pending requests for approval.<br/> * Information includes student
				details, book title, author, and request date.</p>

			<p style="font-weight: bold;">3. See Borrowed Books:</p>

			<p>* Students and library staff can check the books currently
				borrowed, including due dates for returns.</p>

			<p style="font-weight: bold;">4.	See Fine Student Has to Pay:</p>

			<p>* This feature displays outstanding fines for students, which
				may include late return fines or lost book fines.<br/> * It helps remind
				students of unpaid fines and encourages timely payment.</p>
		</div>
	</div>
</body>
</html>