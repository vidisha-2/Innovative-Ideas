<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
		<link rel='stylesheet' href="/css/style.css">
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
		<style>
							body {font-family: monospace;}
					* {box-sizing: border-box;}
					
					/* Button used to open the contact form - fixed at the bottom of the page */
					.open-button {
					  background-color: #9cab4e;
					  color: white;
					  padding: 16px 20px;
					  border: none;
					  cursor: pointer;
					  opacity: 0.8;
					  position: relative;
					  top:150px;
					  left:590px;
					  bottom: 23px;
					 
					  width: 280px;
					  font-family: monospace;
					}
					/* login open button */
					#open-button {
					  background-color: #9cab4e;
					  color: white;
					  padding: 16px 20px;
					  border: none;
					  cursor: pointer;
					  opacity: 0.8;
					  position: relative;
					  bottom: -206px;
					  left: 303px;
					  width: 280px;
					  font-family: monospace;
					}
					/* The popup form - hidden by default */
					.form-popup {
					  display: none;
					  position: fixed;
					  bottom: 0;
					  right: 15px;
					  border: 3px solid #f1f1f1;
					  z-index: 9;
					  padding:20px;
					}
					
					.form-popup-login {
					  display: none;
					  position: relative;
    				  width: 300px;
					  left: 70px;
					  border: 3px solid #f1f1f1;
					  z-index: 9;
					  padding:7px;
					}
					
					/* Add styles to the form container */
					.form-container {
					 max-width: 500px;
					  max-height:900px;
					  padding: 20px;
					  background-color: white;
					}
					
					/* Full-width input fields */
					.form-container input[type=text], .form-container input[type=password] {
					  width: 100%;
					  padding: 10px;
					  margin: 2px 0 2px 0;
					  border: none;
					  background: #f1f1f1;
					}
					
					/* When the inputs get focus, do something */
					.form-container input[type=text]:focus, .form-container input[type=password]:focus {
					  background-color: #ddd;
					  outline: none;
					}
					
					/* Set a style for the submit/login button */
					.form-container .btn {
					  background-color: #e91e63;
					  color: white;
					  padding: 10px 15px;
					  border: none;
					  cursor: pointer;
					  width: 100%;
					  margin-bottom:10px;
					  opacity: 0.8;
					}
					
					/* Add a red background color to the cancel button */
					.form-container .cancel {
					  background-color: #00bcd4;
					}
					
					/* Add some hover effects to buttons */
					.form-container .btn:hover, .open-button:hover {
					  opacity: 1;
					}
					</style>
</head>
<body>
	<h1 style="text-align:center; margin-top:40px; font-family: monospace;">Welcome to Innovative Ideas</h1>
		<button class="open-button" onclick="openRegForm()">Registration Form</button>
		<div class="form-popup" id="myForm">
			<h1 style="text-align:center;">Register</h1>
    
		     <p style="color:red"><form:errors path="user.*"/></p>

		    <form:form method="POST" action="/registration" modelAttribute="user" class="form-container">
		        <p>
		            <form:label path="firstname">First Name:</form:label>
		            <form:input path="firstname"/>
		        </p>
		        <p>
		            <form:label path="lastname">Last Name:</form:label>
		            <form:input path="lastname"/>
		        </p>
		         <p style="color:red;"><c:out value="${error}"/></p>
		        <p>
		            <form:label path="email">Email:</form:label>
		            <form:input type="email" path="email"/>
		        </p>
		         <p>
		            <form:label path="location">City:</form:label>
		            <form:input path="location"/>
		        </p>
		        
		     
		        <p>
		            <form:label path="password">Password:</form:label>
		            <form:password path="password"/>
		        </p>
		        <p>
		            <form:label path="passwordConfirmation">Password Confirmation:</form:label>
		            <form:password path="passwordConfirmation"/>
		        </p>
		        <input type="submit" value="Register!" class="btn"/>
		       <button type="button" class="btn cancel" onclick="closeRegForm()">Close</button>
		    </form:form>
		    </div>
		 
		  <button id="open-button" onclick="openLoginForm()">Login</button>
				<div class="form-popup-login" id="myloginForm">
			 <h1 style="text-align:center;">Login</h1>
			    <p style="color:red"><c:out value="${error_msg}" /></p>
			    <form method="post" action="/login" class="form-container">
			        <p>
			            <label for="email">Email</label>
			            <input type="text" id="email" name="email"/>
			        </p>
			        <p>
			            <label for="password">Password</label>
			            <input type="password" id="password" name="password"/>
			        </p>
			        <input type="submit" value="Login!" class="btn"/>
			        <button type="button" class="btn cancel" onclick="closeLoginForm()">Close</button>
			    </form>    
		   </div>
		  
		  
		  <script>
			function openRegForm() {
			    document.getElementById("myForm").style.display = "block";
			}
			
			function closeRegForm() {
			    document.getElementById("myForm").style.display = "none";
			}
			function openLoginForm() {
			    document.getElementById("myloginForm").style.display = "block";
			}
			
			function closeLoginForm() {
			    document.getElementById("myloginForm").style.display = "none";
			}
			</script>
		  
</body>
</html>