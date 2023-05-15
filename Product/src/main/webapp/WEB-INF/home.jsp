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

<title>Home Page</title>
</head>
<body>
	<div class="container p-4 border-bottom">
		<h1 class="text-center">Home Page</h1>
		<div class="link d-flex flex-column">
			<a href="/products/new">New Product</a> 
			<a href="/category/new">New Category</a>
		</div>

	</div>

	<table class="table mt-5 w-50 m-auto border">
		<thead>
			<tr>
				<th scope="col">Products</th>
				<th scope="col">Categories</th>

			</tr>

		</thead>

		<tbody>
       	<tr>
       		<td>
       			<ul>
		       		<c:forEach var="product" items="${products}">
		       			<li><a href="products/<c:out value="${product.id}"/>"><c:out value="${product.name}"/></a></li>
		       		</c:forEach>
		       	</ul>
       		</td>
       		<td>
       			<ul>
		       		<c:forEach var="category" items="${categories}">
		       			<li><a href="category/<c:out value="${category.id}"/>"><c:out value="${category.categoryName}"/></a></li>
		       		</c:forEach>
		       	</ul>
       		</td>
       	</tr>
    </tbody>



	</table>
</body>
</html>