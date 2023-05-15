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
<title>Dash board</title>
</head>
<body>
	<div class="container p-5">
		<div class="d-flex justify-content-between">
			<h1>
				Welcome,
				<c:out value="${loggedUser.firstName} "></c:out>
				!
			</h1>
			<form action="/logout" method="POST">
                  <button class="border-0 bg-transparent text-primary mb-3">Logout</button>
             </form>

		</div>
		<div class="mt-2 d-flex justify-content-between align-items-center">
			<p>All Projects</p>
			<a href="/project/new">+ new project</a>

		</div>

		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">Project</th>
					<th scope="col">Team Lead</th>
					<th scope="col">Due Date</th>
					<th scope="col">Actions</th>


				</tr>

			</thead>
			<c:forEach var="project" items="${projects}">
                  <tr>
                    <c:if test="${project.lead.id != user_id && project.users.contains(loggedUser) == false}">
                      <td>
                        <a href="/projects/${project.id}">
                          <c:out value="${project.title}" />
                        </a>
                      </td>
                      <td>
                        <c:out value="${project.lead.firstName}" />
                      </td>
                      <td>
                        <fmt:formatDate pattern="MMM dd" value="${project.dueDate}" />
                      </td>
                      <td class="text-center">
                        <form action="/projects/join/${project.id}" method="POST">
                          <input type="hidden" name="_method" value="put">
                          <input type="hidden" name="id" value="${project.id}" />
                          <input type="submit" value="Join Team" class="link-primary border-0 bg-transparent">
                        </form>
                      </td>
                    </c:if>
                  </tr>
                </c:forEach>
              </tbody>



		</table>

		<p>Your Project</p>
		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">Project</th>
					<th scope="col">Team Lead</th>
					<th scope="col">Due Date</th>
					<th scope="col">Actions</th>


				</tr>

			</thead>
			<tbody>
                  <c:forEach var="project" items="${projects}">
                    <tr>
                      <c:if test="${project.lead.id == user_id}">
                        <td>
                          <a href="/projects/${project.id}">
                            <c:out value="${project.title}" />
                          </a>
                        </td>
                        <td>
                          <c:out value="${project.lead.firstName}" />
                        </td>
                        <td>
                          <fmt:formatDate pattern="MMM dd" value="${project.dueDate}" />
                        </td>
                        <td class="text-center">
                          <a href="/projects/edit/${project.id}" class="link-warning">Edit</a>
                        </td>
                      </c:if>
                    </tr>
                  </c:forEach>
                  <c:forEach var="project" items="${loggedUser.projects}">
                    <tr>
                      <td>
                        <a href="/projects/${project.id}">
                          <c:out value="${project.title}" />
                        </a>
                      </td>
                      <td>
                        <c:out value="${project.lead.firstName}" />
                      </td>
                      <td>
                        <fmt:formatDate pattern="MMM dd" value="${project.dueDate}" />
                      </td>
                      <td class="text-center">
                        <form action="/projects/leave/${project.id}" method="POST">
                          <input type="hidden" name="_method" value="put">
                          <input type="hidden" name="id" value="${project.id}" />
                          <input type="submit" value="Leave Team" class="link-danger border-0 bg-transparent">
                        </form>
                      </td>
                    </tr>
                  </c:forEach>
                </tbody>


		</table>



	</div>
</body>
</html>