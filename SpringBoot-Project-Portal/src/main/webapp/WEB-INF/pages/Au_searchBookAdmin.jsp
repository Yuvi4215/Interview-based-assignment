<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
			<form class="form"
				action="${pageContext.request.contextPath}/admin/updating">
				<p class="title">Book Search</p>
				<label> <input  type="text" name="parameter" class="input" required>
					<span>ISBN/Title</span>
				</label>

				<div>
					<label>Search by:</label>
				</div>

				<div class="radio-buttons-container">

					<div class="radio-button">
						<input name="type" id="radio1" class="radio-button__input"
							type="radio"  value="ISBN" required> <label
							for="radio1" class="radio-button__label"> <span
							class="radio-button__custom"></span>ISBN
						</label>
					</div>
					<div class="radio-button">
						<input name="type" id="radio2" class="radio-button__input"
							type="radio"  value="title" required> <label
							for="radio2" class="radio-button__label"> <span
							class="radio-button__custom"></span> Title
						</label>
					</div>
				</div>
				<button class="btn">Search</button>
			</form>
		</div>
	</div>
</body>
</html>