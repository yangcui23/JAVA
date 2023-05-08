<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<title>Dojos</title>
</head>
<body>
	<form:form action="/dojos/submit" method="POST" modelAttribute="dojo" class="form form-control w-25 m-auto mt-5 ">
		<div>
		<h1 class="mt-5" >New Dojo</h1>
		<a href="/ninjas">Create A Ninja</a>
		
		</div>
		<form:label path="location"  class="form-label mt-5">Location:</form:label>
		<form:errors path="location" class="text-danger" />
		<form:input  path="location" type="text" class="form-control" name="location" />
	
		<button type="Submit" class="btn btn-primary mt-5">Create</button>
	</form:form>
</body>
</html>