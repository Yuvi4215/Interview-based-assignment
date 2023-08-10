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
	href="${pageContext.request.contextPath}/table/table.css" />
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/button/button.css" />
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
			<h1 style="margin-left: 20%;">Borrower List</h1>
			<table>
				<tr>
					<th style="border-top-left-radius: 25px;">Transaction Id</th>
					<th>Student Id</th>
					<th>ISBN</th>
					<th>Status</th>
					<th style="border-top-right-radius: 25px;">Delete</th>
				</tr>
				<c:choose>
					<c:when test="${! empty list }">
						<c:forEach var="trancation" items="${list }">
							<tr>
								<td><c:out value="${trancation.trancationId}"></c:out></td>
								<td><c:out value="${trancation.libraryId}"></c:out></td>
								<td><c:out value="${trancation.isbn}"></c:out></td>
								<td style="text-align: center;"><c:out value="${trancation.status }"></c:out></td>
								<td style="text-align: center;"><a
									href="${pageContext.request.contextPath}/admin/delete?parameter=${trancation.trancationId }">Delete</a></td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="4" style="text-align: center;">No Pending
								Request Found</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</table>
		</div>
	</div>
</body>
</html>