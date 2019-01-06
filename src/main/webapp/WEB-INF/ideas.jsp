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
			<div class="card bg-info text-white" style="width:1060px; padding:10px; margin:0 auto; margin-top:40px; height:100px;">
					<div class='card-body' >
					<h1>Welcome, <c:out value="${user.firstname}" /><a href="/logout"><span style="float:right; font-size:15px; color:white;margin-top:40px;">Logout</span></a></h1>
				</div>
			</div>
			<h5 style="color:orange;"><i>Ideas</i></h5>
			<a href="/ascending">Low Likes</a>
			<a href="/descending">High Likes</a>
			<table class="table table-striped">
		        <thead><!-- how to get the column names to show????  -->
		            <tr style="padding: 5px; text-align: left;">
		                <th scope="col" >Name</th>
		               	<th scope="col" >Created By/Host</th>
		               	<th scope="col" >Likes</th>
		               	<th scope="col" >Action</th>
		            </tr>
		        </thead>
		        <tbody>
		              
		              	<c:forEach items="${allIdeas}" var="idea">
		              	
		              	<tr>
		                   <td><a href="/ideas/${idea.id}">${idea.content}</a></td>
		                   <td>${idea.host.firstname}</td>
		                   <td>${idea.getUsers().size()}</td>
		                    <c:choose>
		                  <c:when test="${!idea.getUsers().contains(user) }">
		                 	   <td><a href="/ideas/${idea.id}/like">Like</a></td>
		                 </c:when>
		                 <c:otherwise>
		                    
		                   <td> <a href="/ideas/${idea.id}/unlike">Unlike</a></td>
		                   </c:otherwise>
		                   </c:choose>
		                  
		                   
		                   </tr>
		                  
						</c:forEach>
		             </tbody>
		  	</table>
		   
			<h4><a href="/ideas/new">Create an Idea</a></h4>
    			
		   
		 
		 </div>
</body>
</html>