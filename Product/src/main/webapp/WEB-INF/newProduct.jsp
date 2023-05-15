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
<title>New Product</title>
</head>
<body>
	<div class="container p-4 border-bottom">
		<h1 class="text-center">New Product</h1>
		<div>
			<a href="/">Home</a>
		</div>

	</div>
	<form:form action="/products/submit" method="POST" modelAttribute="product" class="f border w-50 m-auto mt-5">
		<div class="form-control d-flex justify-content-between align-items-center">
			<form:label path="name" class="form-label">Name:</form:label>
			<form:errors path="name" class="text-danger" />
			<form:input path="name" type="text" class="form-control w-50" />
		</div>
		<div class="form-control d-flex justify-content-between align-items-center">
			<form:label path="description" class="form-label">Description:</form:label>
			<form:errors path="description" class="text-danger" />
			<form:input path="description" type="text" class="form-control w-50" />
		</div>
		<div class="form-control d-flex justify-content-between align-items-center">
			<form:label path="price" class="form-label">Price:</form:label>
			<form:errors path="price" class="text-danger" />
			<form:input path="price" type="number" class="form-control w-50" placeholder="0.0"/>
		</div>
		
		<input type="submit" value="Submit" class="btn btn-primary">
		
	
	
	</form:form>
</body>
</html>