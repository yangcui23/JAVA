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
<link rel="stylesheet" type="text/css" href="/css/style.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<title>Login and Register</title>
</head>
<body>
	<div class="container">
		<div class="top p-5">
			<h1 class="header">Book Club</h1>
			<p class="des">A place for friends to share thoughts on books</p>
		</div>
		<div class="bot d-flex">
			<div class="left w-50 p-5">
				<form:form action="/register" modelAttribute="newUser" method="POST">
					<h2>Register</h2>
			<div>
				<form:label path="userName" class="form-label mt-5">Username:</form:label>
				<form:errors path="userName" class="text-danger" />
				<form:input path="userName" type="text" class="form-control" />
			</div>
			<div>
				<form:label path="email" class="form-label mt-5">Email:</form:label>
				<form:errors path="email" class="text-danger" />
				<form:input path="email" type="text" class="form-control" />
			</div>
			<div>
				<form:label path="password" class="form-label mt-5">Password:</form:label>
				<form:errors path="password" class="text-danger" />
				<form:input path="password" type="password" class="form-control" />
			</div>
			<div>
				<form:label path="confirm" class="form-label mt-5">Confirm Password:</form:label>
				<form:errors path="confirm" class="text-danger" />
				<form:input path="confirm" type="password" class="form-control" />
			</div>
			<input type="Submit" class="btn btn-primary mt-5" value="Register">
				</form:form>
			</div>
			<div class="right w-50 p-5">
				<form:form action="/login" medthod="POST" modelAttribute="newLogin">
			<h2>Login</h2>
			<div>
				<form:label path="email" class="form-label mt-5">Email:</form:label>
				<form:errors path="email" class="text-danger" />
				<form:input path="email" type="text" class="form-control" />
			</div>
			<div>
				<form:label path="password" class="form-label mt-5">Password:</form:label>
				<form:errors path="password" class="text-danger" />
				<form:input path="password" type="password" class="form-control" />
			</div>
			
			<input type="Submit" class="btn btn-danger mt-5" value="Login">

		</form:form>
			
			</div>		
		</div>
	
	</div>

</body>
</html>