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
			Admin ::
			<marquee>${admin}</marquee>
		</p>
	</div>

	<div class="row">
		<div class="bodnav">
			<div class="img">
				<div class="admin_img">
					<img alt="Admin Profile" src="../admin.jpg">
				</div>
			</div>

			<div>
				<a href="${pageContext.request.contextPath}/admin/home">Home</a>
			</div>
			<div>
				<a href="${pageContext.request.contextPath}/admin/add">Add new
					Book</a>
			</div>
			<div>
				<a href="${pageContext.request.contextPath}/admin/update">Search
					and Update </a>
			</div>
			<div>
				<a href="${pageContext.request.contextPath}/admin/bookList">All
					Books List</a>
			</div>
			<div>
				<a href="${pageContext.request.contextPath}/admin/pending">Pending
					Request</a>
			</div>
			<div>
				<a href="${pageContext.request.contextPath}/admin/borrower">Borrower
					List</a>
			</div>
			<div style="margin-bottom: 50px">
				<a href="${pageContext.request.contextPath}/admin/logout">Logout</a>
			</div>
		</div>

		<div class="bod content">
			<h2>Main Content</h2>
			<p style="font-weight: bold;">1. Add New Book to Library Portal:</p>
			<p>As an admin, you have the authority to add new books to the
				library's database. When a new book is acquired, you can enter its
				details into the system. The information to be input includes the
				book's title, author, ISBN, genre, publication date, publisher, and
				any other relevant metadata. By adding books to the database, you
				make them accessible for students and staff to search and borrow.</p>

			<p style="font-weight: bold;">2. Search and Update Existing Book:</p>

			<p>Admins can search the library database for existing books
				based on various parameters like title, author, ISBN, or genre. The
				ability to search helps verify book availability, check stock
				levels, and update any book information if needed, such as updating
				the status or edition. This ensures that the library's
				catalog remains up-to-date and accurate.</p>

			<p style="font-weight: bold;">3. See List of All Books in
				Database:</p>

			<p>Admins can access a comprehensive list of all books available
				in the library database. This feature provides an overview of the
				entire collection and helps identify any missing or duplicate
				entries. It is an essential tool for managing inventory and
				evaluating the library's collection to meet the needs of students
				and faculty.</p>

			<p style="font-weight: bold;">4. See Pending Book Requests Made
				by Students with Transaction ID to Approve:</p>

			<p>When students request to borrow a book, their requests appear
				in a pending status. Admins can view these pending requests, which
				include the student's details, the book they want to borrow, and a
				unique transaction ID for each request. Admins have the authority to
				approve or deny these requests based on book availability and
				library policies. Upon approval, the book's status changes to
				"approved"," allowing the student to check out the
				book.</p>

			<p style="font-weight: bold;">5. See Borrowed Books and Student
				IDs of Borrowers:</p>

			<p>Admins can access a list of all books currently borrowed by
				students. This list includes the book titles, authors, due dates for
				return, and the respective student IDs of those who borrowed the
				books. The borrowed books list helps admins track the status of each
				book, identify overdue books, and remind students to return borrowed
				items on time. Additionally, having access to student IDs helps
				maintain accurate records of borrowing history and fines.</p>
		</div>
	</div>

</body>
</html>