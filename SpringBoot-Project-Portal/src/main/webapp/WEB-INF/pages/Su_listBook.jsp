<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/button/button.css" />
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/table/table.css" />
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/css/dashboard.css" />
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/pagination/paging.css" />
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
					<img alt="Student Profile" src="../student.jpg">
				</div>
			</div>
			<div>
				<a href="${pageContext.request.contextPath}/student/home">Home</a>
			</div>
			<div>
				<a href="${pageContext.request.contextPath}/student/search">Search
					Book</a>
			</div>
			<div>
				<a href="${pageContext.request.contextPath}/student/bookList">All
					Books List</a>
			</div>
			<div>
				<a href="${pageContext.request.contextPath}/student/pending">My
					Request</a>
			</div>
			<div>
				<a href="${pageContext.request.contextPath}/student/borrowed">Borrowed
					books</a>
			</div>
			<div>
				<a href="${pageContext.request.contextPath}/student/fine">Fine</a>
			</div>
			<div>
				<a href="${pageContext.request.contextPath}/student/logout">Logout</a>
			</div>
		</div>

		<div class="bod content">
			<table>
				<tr>
					<th style="border-top-left-radius: 25px;">ISBN</th>
					<th>Title</th>
					<th>Author</th>
					<th>Genre</th>
					<th>available</th>
					<th style="border-top-right-radius: 25px;">Borrow</th>
				</tr>

				<c:forEach var="book" items="${list }">
					<tr>
						<td><c:out value="${book.isbn }"></c:out></td>
						<td><c:out value="${book.title }"></c:out></td>
						<td><c:out value="${book.author }"></c:out></td>
						<td><c:out value="${book.genre }"></c:out></td>
						<td style="text-align: center;"><c:out
								value="${book.available }"></c:out></td>
						<td style="text-align: center;">
						<c:if test = "${limit < 4}">
						<a	href="${pageContext.request.contextPath}/student/request?isbn=${book.isbn}">Add</a>
						</c:if>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
		<div class="pagination">
			<c:if test="${pageNo>1 }">
			<a href='${pageContext.request.contextPath}/student/bookList?pageNo=${pageNo-1}'>previous</a>
			
		</c:if>

		<c:forEach var='i' begin='1' end='${pagesCount}' step="1">
			<a href='${pageContext.request.contextPath}/student/bookList?pageNo=${i}'>${i}</a> 
			
		</c:forEach>
		
		<c:if test="${pageNo<pagesCount }">
			<b> <a href='${pageContext.request.contextPath}/student/bookList?pageNo=${pageNo+1}'>next</a> 
			</b>
		</c:if>
	</div>
</body>
</html>