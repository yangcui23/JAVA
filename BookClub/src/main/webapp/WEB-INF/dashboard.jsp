<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="/css/style.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<title>Books</title>
</head>
<body>
	<div class="container p-5">
		<div class=" d-flex justify-content-between align-items-center">
			<h1>
				Welcome,
				<c:out value="${loggedUser.userName} " />
			</h1>
			<a href="/logout">Logout</a>

		</div>
		<div class=" d-flex justify-content-between align-items-center">
			<p class="des">Books form everyone's shelves:</p>
			<a href="/bookmarket">Book Market</a>
			<a href="/books/new">+ Add to my shelf!</a>
		</div>

		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Title</th>
					<th scope="col">Author Name</th>
					<th scope="col">Posted By</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="books" items="${books}">
					<tr>
						<td><c:out value="${books.id} "/></td>
						<td><a href="/books/${books.id}">
                        <c:out value="${books.title}" />
                      </a></td>
						<td><c:out value="${books.author}"/></td>
						<td><c:out value="${books.user.userName}"/></td>
					</tr>
				
				
				</c:forEach>
				
			</tbody>

		</table>

	</div>
</body>
</html>