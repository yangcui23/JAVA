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
<title>Add category into product</title>
</head>
<body>
	<div class="container p-4 border-bottom">
		<h1 class="text-center">
			<c:out value="${ category.categoryName} " />
		</h1>
		<div class="link">
			<a href="/">Home</a>
		</div>

	</div>
	<div class="container p-4 border-bottom">
		<h3>Product</h3>
		<ul>
			<c:forEach var="product" items="${assignedProducts}">
				<li><c:out value="${product.name}"></c:out></li>
			</c:forEach>
		</ul>
	</div>
	<div class="container mt-5">
	<h2>Add to category :</h2>
	<form:form action="/category/${category.id}/assign" modelAttribute="category" method="POST" class="mt-5 d-flex flex-column">

		<select name="productId" id="productId" class="input">
			
			<c:forEach var="product" items="${unassignedProducts}">
				<option value="${product.id}">${product.name}</option>
			</c:forEach>
		</select>

		<input type="submit" value="Add to product" class="btn btn-primary mt-3"/>

	</form:form>
	
	
	</div>
</body>
</html>