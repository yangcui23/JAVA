<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Omikuji Form</title>
</head>
<body>
	<h1 class="text-center">Omikuji Form</h1>
	<form action="/omikuji/submit" class="form-control w-25 d-flex flex-column gap-4 m-auto mt-5" method="POST">
	<label>Pick a number between 5 to 25</label>
	<select class="form-select" name="number"
						aria-label="Default select example">
		<option selected disabled>0</option>
			<c:forEach var="number" begin="5" end="25">
				<option value="${number}"><c:out value="${number}" />
			</c:forEach>
	</select>
	<label>Enter the name of any city.</label>
	<input type="text" name="city">
	<label>Enter the name of any real person.</label>
	<input type="text" name="person">
	<label>Enter professional endeavor or hobby</label>
	<input type="text" name="hobby">
	<label>Enter any type of living thing.</label>
	<input type="text" name="living">
	<label>Say something nice to someone</label>
	<textarea rows="5" cols="" name="something"></textarea>
	
	<p class="fst-italic"> Send and show a friend</p>
	<button class="button" type="submit">Send</button>
	</form>
</body>
</html>