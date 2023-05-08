<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
      <%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Save Travel</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<h1 class="text-center">Save Travels</h1>
	<table class="table table-striped w-50 border m-auto mt-5">
		<thead>
			<tr>
      			<th scope="col">Name</th>
      			<th scope="col">Vendor</th>
      			<th scope="col">Amount</th>
      			<th scope="col">Description</th>
    		</tr>
		
		</thead>
		<tbody>
                <c:forEach var="expense" items="${expenses}">
                  <tr>
                    <td>
                      <a href="/expenses/${expense.id}">
                        <c:out value="${expense.name}" />
                      </a>
                    </td>
                    <td>
                      <c:out value="${expense.vendor}" />
                    </td>
                    <td>
                      $
                      <c:out value="${String.format('%.2f', expense.amount)}" />
                    </td>
                    <td class="d-flex align-items-center justify-content-evenly">
                      <a href="/expenses/edit/${expense.id}" class="link-warning">Edit</a>
                      <form action="/expenses/${expense.id}" method="post">
                        <input type="hidden" name="_method" value="delete">
                        <input type="submit" value="Delete" class="btn btn-sm btn-danger fw-bold">
                      </form>
                    </td>
                  </tr>
                </c:forEach>
              </tbody>
		
		
	
	</table>
	
	
	<div class="w-25 m-auto mt-5">
		<h1>Add an expense : </h1>
		<form:form action="/expenses/submit" method="POST" modelAttribute="expense">
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
                    <input type="submit" value="Submit" class="btn btn-primary">
                  </div>
		
		</form:form>
	
	</div>
	
	
	
</body>
</html>