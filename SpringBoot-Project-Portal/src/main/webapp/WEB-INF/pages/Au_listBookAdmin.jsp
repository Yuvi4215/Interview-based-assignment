<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/css/dashboard.css" />
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/button/button.css" />
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/table/table.css" />
	<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/pagination/paging.css" />
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
			<h1 style="margin-left: 40%; color: royalblue; letter-spacing: 3px;">All
				Books</h1>
			<table>
				<tr>
					<th style="border-top-left-radius: 25px;">ISBN</th>
					<th>Title</th>
					<th>Author</th>
					<th>Total</th>
					<th>Borrowed</th>
					<th>available</th>
					<th style="border-top-right-radius: 25px;">Update</th>
				</tr>

				<c:forEach var="book" items="${list }">
					<tr>
						<td><c:out value="${book.isbn }"></c:out></td>
						<td><c:out value="${book.title }"></c:out></td>
						<td><c:out value="${book.author }"></c:out></td>
						<td style="text-align: center;"><c:out
								value="${book.totalCount }"></c:out></td>
						<td style="text-align: center;"><c:out
								value="${book.borrowed }"></c:out></td>
						<td style="text-align: center;"><c:out
								value="${book.available }"></c:out></td>
						<td style="text-align: center;"><a
							href="${pageContext.request.contextPath}/admin/updating?parameter=${book.isbn}&type=isbn">Update</a></td>

					</tr>
				</c:forEach>

			</table>
		</div>
	</div>
	<div class="pagination">
		<c:if test="${pageNo>1 }">
			<a
				href='${pageContext.request.contextPath}/admin/bookList?pageNo=${pageNo-1}'>previous</a>

		</c:if>

		<c:forEach var='i' begin='1' end='${pagesCount}' step="1">
			<a
				href='${pageContext.request.contextPath}/admin/bookList?pageNo=${i}'>${i}</a>

		</c:forEach>

		<c:if test="${pageNo<pagesCount }">
			<b> <a
				href='${pageContext.request.contextPath}/admin/bookList?pageNo=${pageNo+1}'>next</a>
			</b>
		</c:if>
	</div>
</body>
</html>