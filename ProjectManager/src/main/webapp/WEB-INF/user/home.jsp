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
<title>Login and register</title>
</head>
<body>
		<h1 class="text-primary text-center">Project Manager</h1>
		<p class="text-center">A place for teams to manage projects!!!</p>
	<div class="container p-5 d-flex justify-content-between">

	<div class="form p-5">
	
	
		<form:form action="/register" medthod="POST" modelAttribute="newUser">
			<h2>Register</h2>
			<div>
				<form:label path="firstName" class="form-label mt-5">First Name:</form:label>
				<form:errors path="firstName" class="text-danger" />
				<form:input path="firstName" type="text" class="form-control" />
			</div>
			<div>
				<form:label path="lastName" class="form-label mt-5">Last Name:</form:label>
				<form:errors path="lastName" class="text-danger" />
				<form:input path="lastName" type="text" class="form-control" />
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
	
	<div class="form p-5">
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
				<form:input path="password" type="text" class="form-control" />
			</div>
			
			<input type="Submit" class="btn btn-danger mt-5" value="Login">

		</form:form>
	
	</div>



	</div>


</body>
</html>