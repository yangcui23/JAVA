<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
      <%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Create A Ninja</title>
</head>
<body>
<body>
          <div class="container mx-auto p-5 w-25">
            <div class="form-control mx-auto p-4 rounded-0">
              <a href="/dojos">Dashboard</a>
              <h2 class="mb-4">New Ninja</h2>
              <form:form action="/ninjas/create" method="POST" modelAttribute="ninja">
                <div class="mb-3">
                  <form:label path="dojo" for="formInput" class="form-label">Select Dojo:
                  </form:label>
                  <form:select class="form-select" path="dojo">
                    <form:option value="">Choose one</form:option>
                    <c:forEach var="dojo" items="${dojos}">
                      <form:option value="${dojo.id}">
                        <c:out value="${dojo.location} location" />
                      </form:option>
                    </c:forEach>
                  </form:select>
                </div>
                <div class="mb-3">
                  <form:label path="firstName" for="formInput" class="form-label">First Name:</form:label>
                  <form:errors path="firstName" class="text-danger" />
                  <form:input type="text" class="form-control" id="formInput" path="firstName" />
                </div>
                <div class="mb-3">
                  <form:label path="lastName" for="formInput" class="form-label">Last Name:
                  </form:label>
                  <form:errors path="lastName" class="text-danger" />
                  <form:input type="text" class="form-control"  path="lastName" />
                </div>
                <div class="mb-3">
                  <form:label path="age" for="formInput" class="form-label">Age:
                  </form:label>
                  <form:errors path="age" class="text-danger" />
                  <form:input type="number" class="form-control" id="formInput" path="age" />
                </div>
                <input type="submit" value="Create" class="btn btn-primary mt-3">
              </form:form>
            </div>
          </div>

</body>
</html>