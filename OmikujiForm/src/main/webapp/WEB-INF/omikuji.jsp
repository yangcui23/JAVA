<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">

<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Show Omikuji</title>
</head>
<body>
	<h1 class="text-center">Here's Your Omikuji!!</h1>
	<div class="w-25 h-75 m-auto">
	<p>In <span class="fs-6 fw-bold ">${number}</span> years, you will live in <span  class="fs-6 fw-bold ">${city} </span> with <span  class="fs-6 fw-bold ">${person}</span> as your roommate, <span  class="fs-6 fw-bold ">${hobby}</span> for a living. The next time you see a 
	<span  class="fs-6 fw-bold ">${living}</span> , you will have good luck. Also <span  class="fs-6 fw-bold ">${something}</span> </p>
	<a href="/omikuji">Go back</a>
	</div>
	
</body>
</html>