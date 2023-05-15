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
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<title>Create Project</title>
</head>
<body>

	<div class="container p-5">
		<h1 class="text-primary">Create a Project</h1>

		<div class="w-50 p-5">


			<form:form action="/project/create" medthod="POST"
				modelAttribute="project">

				<div>
					<form:label path="title" class="form-label mt-5">Title :</form:label>
					<form:errors path="title" class="text-danger" />
					<form:input path="title" type="text" class="form-control" />
				</div>
				<div>
					<form:label path="description" class="form-label mt-5">Description :</form:label>
					<form:errors path="description" class="text-danger" />
					<form:textarea path="description" type="text" class="form-control" />
				</div>
				<div>
					<form:label path="dueDate" class="form-label mt-5">Due Date:</form:label>
					<form:errors path="dueDate" class="text-danger" />
					<form:input path="dueDate" type="date" class="form-control" />
				</div>
				<form:input type="hidden" path="lead" value="${user}" class="form-control"/>

				<div class="d-flex align-items-center mt-4 justify-content-end gap-5">

					<a href="/dashboard" class="btn btn-danger">Cancel</a> <input
						type="Submit" class="btn btn-primary" value="Submit">
				</div>


			</form:form>
			


		</div>
	</div>
</body>
</html>