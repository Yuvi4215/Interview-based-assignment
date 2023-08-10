<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/css/dashboard.css" />
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/table/table.css" />
	<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/bottom_option/card.css" />
</head>
<body>
	<div class="header">
		<h1>Library Portal</h1>
		<p>
			Student ::
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
			<div class="card">
				<p class="title">Output</p>
				<table>
					<tr>
						<th style="border-top-left-radius: 25px;">Result ::</th>

						<td>${message}</td>
					</tr>

				</table>
			</div>
		</div>
	</div>
</body>
</html>