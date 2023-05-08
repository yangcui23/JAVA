<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Edit Expense</title>
</head>
<body>
	<div class="w-25 m-auto mt-5">
	<div class="d-flex justify-content-between">
		<h1>Edit an expense : </h1>
		<a href="/expenses">Go back</a>
	
	</div>
		
		<form:form action="/expenses/${expense.id}" method="POST" modelAttribute="expense">
		<input type="hidden" name="_method" value="put">
			<div class="mb-3">
                    <form:label path="name" for="formInput" class="form-label">Expense Name:</form:label>
                    <form:input type="text" class="form-control" id="formInput" path="name" />
                    <form:errors path="name" class="text-danger" />
                  </div>
                  <div class="mb-3">
                    <form:label path="vendor" for="formInput" class="form-label">Vendor:
                    </form:label>
                    <form:input type="text" class="form-control" id="formInput" path="vendor" placeholder="" />
                    <form:errors path="vendor" class="text-danger" />
                  </div>
                  <div class="mb-3">
                    <form:label path="amount" for="formInput" class="form-label">Amount:
                    </form:label>
                    <form:input type="double" class="form-control" id="formInput" path="amount" placeholder="" />
                    <form:errors path="amount" class="text-danger" />
                  </div>
                  <div class="mb-3">
                    <form:label path="description" for="formControlTextarea" class="form-label">
                      Description:</form:label>
                    <form:textarea path="description" class="form-control" id="formControlTextarea" rows="3" />
                    <form:errors path="description" class="text-danger" />
                  </div>
                  <div class="d-flex justify-content-end">
                    <input type="submit" value="Update" class="btn btn-primary">
                  </div>
		
		</form:form>
	
	</div>
</body>
</html>