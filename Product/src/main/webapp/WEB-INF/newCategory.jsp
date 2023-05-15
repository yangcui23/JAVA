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
<title>New Category</title>
</head>
<body>
<div class="container p-4 border-bottom">
		<h1 class="text-center">New Category</h1>
		<div>
			<a href="/">Home</a>
		</div>

	</div>
	<form:form action="/category/submit" method="POST" modelAttribute="category" class="f border w-50 m-auto mt-5">
		<div class="form-control d-flex justify-content-between align-items-center">
			<form:label path="categoryName" class="form-label">Name:</form:label>
			<form:errors path="categoryName" class="text-danger" />
			<form:input path="categoryName" type="text" class="form-control w-50" />
		</div>
		
		<input type="submit" value="Submit" class="btn btn-primary">
		
	
	
	</form:form>
	
</body>
</html>