

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="/css/style.css">
<meta charset="BIG5">
<title>Fruity Loops</title>
</head>
<body>
	<h1 class="h text-center mt-5 text-danger">Fruit Store</h1>
	<table class="table table-striped w-50 m-auto mt-5 border border-3 border-warning">
  <thead>
    <tr>
      <th scope="col">name</th>
      <th scope="col">price</th>
      
    </tr>
  </thead>
  <tbody>
      <c:forEach var="fruits" items="${fruitsFromController}">
    <tr>
        <td><c:out value="${fruits.name}"></c:out></td>
        <td><c:out value="${fruits.price}"></c:out></td>
    </tr>
    </c:forEach>
    
</table>
	
</body>
</html>