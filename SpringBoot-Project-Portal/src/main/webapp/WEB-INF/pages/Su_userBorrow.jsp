<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
	href="${pageContext.request.contextPath}/bottom_option/card.css" />
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
			<div class="card">
				<p class="title">Borrowed Details</p>
				<table>
					<tr>
						<th style="border-top-left-radius: 25px;">Transaction Id</th>
						<th>ISBN</th>
						<th>Admin</th>
						<th style="border-top-right-radius: 25px;">Status</th>
					</tr>
					
					<c:choose>
						<c:when test="${! empty list }">
							<c:forEach var="trancation" items="${list }">
								<tr>
									<td style="text-align: center;"><c:out
											value="${trancation.trancationId }"></c:out></td>
									<td style="text-align: center;"><c:out
											value="${trancation.isbn }"></c:out></td>
									<td style="text-align: center;"><c:out
											value="${trancation.staffId }"></c:out></td>
									<td style="text-align: center;"><c:out
											value="${trancation.status }"></c:out></td>
								</tr>
							</c:forEach>
						</c:when>
					
						<c:otherwise>
						<tr>
						<td colspan="4" style="text-align: center;"> No Books found </td>
						</tr>
						</c:otherwise>
					</c:choose>



				</table>

			</div>
		</div>
	</div>
</body>
</html>