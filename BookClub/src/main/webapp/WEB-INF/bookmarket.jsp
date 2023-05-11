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
<title>Market Place</title>
</head>
<body>
	<div class="container w-50 p-5">
		<div class="d-flex justify-content-between align-items-center">
			<h4>
				Hello,<span class="text-primary"><c:out
						value="${loggedUser.userName} " /></span>. Welcome to...
			</h4>
			<a href="/books">back to the shelves</a>
		</div>
		<h1>The Book Broker!!!!</h1>
		<p>Available Books to Borrow</p>
		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Title</th>
					<th scope="col">Author Name</th>

					<th scope="col">Owner</th>
					<th scope="col">Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="book" items="${books}">
					<tr>
						<c:if test="${book.borrower == null}">
							<td><c:out value="${book.id}" /></td>
							<td><a href="/books/${book.id}"> <c:out
										value="${book.title}" />
							</a></td>
							<td><c:out value="${book.author}" /></td>
							<td><c:out value="${book.user.userName}" /></td>
							<td class="d-flex text-center align-items-center"><c:choose>
									<c:when test="${book.user.id == loggedUser.id}">
										<span class="d-flex alig-items-center"> <a href="/books/${book.id}/edit"
											class="edit text-primary">Edit  </a>  
											
											<form:form
												action="/books/${book.id}/delete" method="post">
												<input type="hidden" name="_method" value="delete">
												<input type="submit" value="Delete" class="link-danger border-0 bg-transparent ">
											</form:form>
											
											
										</span>
									</c:when>
									<c:otherwise>
										<form action="/books/${book.id}/borrow" method="POST">
											<input type="hidden" name="_method" value="put"> <input
												type="hidden" name="id" value="${book.id}" /> <input
												type="submit" value="Borrow"
												class="link-info border-0 bg-transparent">
										</form>
									</c:otherwise>
								</c:choose></td>
						</c:if>
					</tr>
				</c:forEach>
			</tbody>

		</table>

		<p class="mt-5">Books I'm Borrowing...</p>
		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Title</th>
					<th scope="col">Author Name</th>

					<th scope="col">Owner</th>
					<th scope="col">Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="book" items="${loggedUser.borrowedBooks}">
					<tr>
						<td><c:out value="${book.id}" /></td>
						<td><a href="/books/${book.id}"> <c:out
									value="${book.title}" />
						</a></td>
						<td><c:out value="${book.author}" /></td>
						<td><c:out value="${book.user.userName}" /></td>
						<td class="d-flex text-center align-items-center">
							<form action="/books/${book.id}/return" method="POST">
								<input type="hidden" name="_method" value="put"> <input
									type="hidden" name="id" value="${book.id}" /> <input
									type="submit" value="Return"
									class="link-success border-0 bg-transparent">
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>

		</table>

	</div>
</body>
</html>