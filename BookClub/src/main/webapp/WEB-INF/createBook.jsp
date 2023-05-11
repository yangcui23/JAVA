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
<link rel="stylesheet" type="text/css" href="/css/newFile.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<title>New book</title>
</head>
<body>
	<div class="container p-5">
		<div class="d-flex justify-content-between align-items-center">
			<h1>Add a Book to Your Shelf!</h1>
			<a href="/books">Back to shelves</a>
		</div>
		<div class="form">
			<form:form action="/books/create" modelAttribute="books">
				<div class="col d-flex justify-content-between align-items-center">
					<form:label path="title" class="form-label">Title:</form:label>
					<form:errors path="title" class="text-danger" />
					<form:input path="title" type="text" class="form-control w-50" />
				</div>
				<div class="col d-flex justify-content-between align-items-center mt-5">
					<form:label path="author" class="form-label">Author Name:</form:label>
					<form:errors path="author" class="text-danger" />
					<form:input path="author" type="text" class="form-control w-50" />
				</div>
				<div>
					<form:label path="thoughts" class="form-label mt-5">My thoughts about the book:</form:label>
					<form:errors path="thoughts" class="text-danger" />
					<form:textarea path="thoughts" type="text" class="form-control" />
				</div>
				
				
				<input type="submit" value="Submit" class="btn btn-primary mt-5"/>
				



			</form:form>

		</div>
	</div>
</body>
</html>