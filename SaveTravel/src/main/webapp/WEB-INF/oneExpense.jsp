<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="/css/style.css">
<title>Show One Expense</title>
</head>
<body>
	 <div class="container mx-auto p-5">
          <div class="d-flex align-items-center justify-content-between mb-3">
            <h3 class="heading">Expense Details</h3>
            <a href="/expenses">Go back</a>
          </div>
          <div class=" mx-auto p-10">
            <div class="row mt-5">
              <div class="col">
                <p class="fw-bold">Expense Name :</p>
              </div>
              <div class="col">
                <c:out value="${expense.name}" />
              </div>
            </div>
            <div class="row mt-5">
              <div class="col">
                <p class="fw-bold">Description : </p>
              </div>
              <div class="col">
                <c:out value="${expense.description}" />
              </div>
            </div>
            <div class="row mt-5">
              <div class="col">
                <p class="fw-bold">Vendor Name : </p>
              </div>
              <div class="col">
                <c:out value="${expense.vendor}" />
              </div>
            </div>
            <div class="row mt-5">
              <div class="col">
                <p class="fw-bold">Amount spend : </p>
              </div>
              <div class="col">
                <c:out value="${String.format('%.2f', expense.amount)}" />
              </div>
            </div>
          </div>
        </div>

</body>
</html>