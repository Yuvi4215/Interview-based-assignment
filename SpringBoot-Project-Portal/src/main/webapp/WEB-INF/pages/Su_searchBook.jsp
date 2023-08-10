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
			<form class="form" action="./searching">
				<p class="title">Book Search</p>
				<label> <input name="parameter" type="text" class="input" required>
					<span>ISBN/Author/Title/Genre</span>
				</label>

				<div>
					<label>Search by:</label>
				</div>

				<div class="radio-buttons-container">
					<div class="radio-button">
						<input name="type" id="radio2" class="radio-button__input"
							type="radio" required="required" value="isbn"> <label
							for="radio2" class="radio-button__label"> <span
							class="radio-button__custom"></span> ISBN
						</label>
					</div>
					<div class="radio-button">
						<input name="type" id="radio1" class="radio-button__input"
							type="radio" required="required" value="author"> <label
							for="radio1" class="radio-button__label"> <span
							class="radio-button__custom"></span>Author
						</label>
					</div>
					<div class="radio-button">
						<input name="type" id="radio3" class="radio-button__input"
							type="radio" required="required" value="title"> <label
							for="radio3" class="radio-button__label"> <span
							class="radio-button__custom"></span>Title
						</label>
					</div>
					<div class="radio-button">
						<input name="type" id="radio4" class="radio-button__input"
							type="radio" required="required" value="genre"> <label
							for="radio4" class="radio-button__label"> <span
							class="radio-button__custom"></span>Genre
						</label>
					</div>
				</div>
				<button class="btn">Search</button>
			</form>
		</div>
	</div>
</body>
</html>