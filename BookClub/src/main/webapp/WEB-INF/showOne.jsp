<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
    <!DOCTYPE html>
    <html>

    <head>
      <meta charset="UTF-8">
      <title>Book Details</title>
      <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
      <link rel="stylesheet" type="text/css" href="/css/style.css">
    </head>

    <body>
      <div class="container mx-auto p-5">
        <div class="card mx-auto p-5 rounded-0">
          <div class="d-flex mb-4 justify-content-between align-items-center">
            <h2 class="text"><c:out value="${book.title}"/></h2>
            <a href="/books">Back to the shelves</a>
          </div>
          <div>
            <p class="mb-0">
              <c:choose>
                <c:when test="${book.user.id == loggedUser.id}">
                  <span class="font text-danger">You</span>
                   read
                </c:when>
                <c:otherwise>
                  <span class="font text-warning"><c:out value="${book.user.userName}" /></span>
                   read
                </c:otherwise>
              </c:choose>
              <span class="title">
                <c:out value="${book.title}" />
              </span>
              by
              <span class="author me-0">
                <c:out value="${book.author}" />
              </span>
            </p>
          </div>
          <p class="mb-4">Here are
            <c:choose>
              <c:when test="${book.user.id == loggedUser.id}">
                your thoughts:
              </c:when>
              <c:otherwise>
                <c:out value="${book.user.userName}" />'s thoughts:
              </c:otherwise>
            </c:choose>
          </p>
          <div class="border-top border-bottom mx-5 p-4 mb-4">
            <p class="mb-0">
              <em>
                <c:out value="${book.thoughts}" />
              </em>
            </p>
          </div>
          <div class="d-flex justify-content-end ">
            <c:if test="${book.user.id == loggedUser.id}">
              <a href="/books/${book.id}/edit" class="btn btn-warning">Edit</a>
              <form:form action="/books/${book.id}/delete" method="post">
              	<input type="hidden" name="_method" value="delete">
    			<input type="submit" value="Delete" class="btn btn-danger" >
              </form:form>
              
            </c:if>
          </div>
        </div>
      </div>
    </body>

    </html>