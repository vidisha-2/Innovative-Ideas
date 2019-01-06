<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ideas</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
		<link rel='stylesheet' href="/css/style.css">
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
		<style>
			.container{
				padding: 40px;
			}
			.form-control{
				width: 200px;
			}
			.error{
				color: red;
			}
					
		</style>
</head>
<body>
		<div class="container">
				<h1>Create a new idea</h1>
			<form:form action="/ideas/create" method="post" modelAttribute="idea" class="form-group mt-2">
				    <p>
				        <form:label path="content">COntent:</form:label>
				        <form:errors path="content" class='error'/>
				        <form:input path="content" class='form-control'/>
				    </p>
				    <input type="hidden" name="host" value="${user.id}"/> 
				    <input type="submit" value="Create" class='btn btn-outline-success mt-2'/>
				</form:form>  
				<button class="btn btn-outline-success mt-2"><a href="/home">Back</a></button>
		</div>
</body>
</html>