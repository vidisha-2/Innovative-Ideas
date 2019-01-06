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
<body>
		<div class="container">
				<div class="card bg-info text-white" style="width:1060px; padding:10px; margin:0 auto; margin-top:40px; height:200px;">
					<div class='card-body' >
					<h1><c:out value="${idea.content}" /><h4>Created By: ${idea.host.firstname}</h4><a href="/logout"><span style="float:right; font-size:15px; color:white;margin-top:40px;">Logout</span></a></h1>
				
				</div>
				
			</div>
			<h2>Users who liked your idea:</h2>
			<table class="table table-striped">
		        <thead><!-- how to get the column names to show????  -->
		            <tr style="padding: 5px; text-align: left;">
		                <th scope="col" >Name</th>
		            </tr>
		        </thead>
		        <tbody>
		              
		              	<c:forEach items="${likedIdea}" var="idea">
		              	
		              	<tr>
		                   <td>${user.firstname}</td>
		                 </tr>
		                  
						</c:forEach>
		             </tbody>
		  	</table>
		  	<button class="btn btn-outline-success mt-2"><a href="/ideas/${idea.id}/edit">Edit</a></button>
		</div>
</body>
</html>