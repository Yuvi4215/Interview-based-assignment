<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/css/dashboard.css" />
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/add/addCard.css" />
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/radio/radio.css" />
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
			<img alt="Admin Profile" src="../admin.jpg" >
		</div>
		</div>
			<div>
				<a href="${pageContext.request.contextPath}/admin/home" >Home</a>
			</div>
			<div>
				<a href="${pageContext.request.contextPath}/admin/add" >Add new Book</a>
			</div>
			<div>
				<a href="${pageContext.request.contextPath}/admin/update" >Search and Update </a>
			</div>
			<div>
				<a href="${pageContext.request.contextPath}/admin/bookList" >All Books List</a>
			</div>
			<div>
				<a href="${pageContext.request.contextPath}/admin/pending" >Pending Request</a>
			</div>
			<div>
				<a href="${pageContext.request.contextPath}/admin/borrower" >Borrower List</a>
			</div>
			<div style="margin-bottom: 50px">
				<a href="${pageContext.request.contextPath}/admin/logout">Logout</a>
			</div>
		</div>

		<div class="bod content">
			<form:form action="./adding" method="post" class="form"
				modelAttribute="book">
				<p class="title">Add Book</p>
				<label> <form:input type="text" class="input" path="isbn"
						required="required" /> <span>ISBN</span>
				</label>
				<label> <form:input type="text" class="input" path="title"
						required="required" /> <span>Title</span>
				</label>
				<div class="flex">
					<label> <form:input type="text" class="input" path="author"
							 /> <span>Author</span>
					</label> <label> <form:input type="text" class="input"
							path="publisher"  /> <span>Publisher</span>
					</label>
				</div>
				<div class="flex">
					<label> <form:input type="text" class="input"
							path="edition"  /> <span>Edition</span>
					</label> <label> <form:input type="text" class="input" path="genre"
							 /> <span>Genre</span>
					</label>
				</div>
				<div class="flex">
					<label> <form:input type="number" min="1960" max="2024"
							class="input" path="year"  /> <span>Year of
							Publish</span>
					</label> <label> <form:input type="number" min="1" max="2000"
							class="input" path="totalCount"  /> <span>Total
							Books</span>
					</label>
				</div>
				<button class="btn">Submit</button>
			</form:form>
			
			
			
			<!-- <form class="form" action="./adding">
				<p class="title">Add Book</p>
				<label> <input  type="text" class="input" required>
					<span>ISBN</span>
				</label>
				<label> <input  type="text" class="input" required>
					<span>Title</span>
				</label>
				<div class="flex">
					<label> <input type="text" class="input">
						<span>Author</span>
					</label> <label> <input  type="text" class="input">
						<span>Publisher</span>
					</label>
				</div>
				<div class="flex">
					<label> <input  type="text" class="input">
						<span>Edition</span>
					</label> <label> <input  type="text" class="input">
						<span>Genre</span>
					</label>
				</div>
				<div class="flex">
					<label> <input  type="number" min="1960"
						max="2024" class="input"> <span>Year of Publish</span>
					</label> <label> <input  type="number" min="1"
						max="1000" class="input" required> <span>Total Books</span>
					</label>
				</div>
				<button class="btn">Submit</button>
			</form> -->
		</div>
	</div>
</body>
</html>