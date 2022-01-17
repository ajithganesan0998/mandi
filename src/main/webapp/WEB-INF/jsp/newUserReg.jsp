<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<meta charset="utf-8">
</head>
<body>
<div>    </div>
<div class="container  borderreg " >
<h1>Mandi User Registration</h1>
<form id="RegistrationForm" name="RegistrationForm" method = "Post">
<div class="row">
<div class="col-6">
 <div class="form-group">
    <label for="email">Name:</label>
    <input type="email" class="form-control" id="name" name="Name" >
  </div>
  </div>
  <div class="col-6">
   <div class="form-group">
    <label for="email">DOB:</label>
    <input type="email" class="form-control" id="Dob" name="Dob">
  </div>
  </div>
  <div class="col-6">
 <div class="form-group">
    <label for="email">Email address:</label>
    <input type="email" class="form-control" id="email" name="Email">
  </div>
  </div>
  <div class="col-6">
   <div class="form-group">
    <label for="email">Password:</label>
    <input type="email" class="form-control" id="password" name="Password">
  </div>
  </div>
  <div class="col-6">
 <div class="form-group">
    <label for="email">User:</label>
    <input type="email" class="form-control" id="userName" name="UserName" >
  </div>
  </div>
  <div class="col-6">
   <div class="form-group">
    <label for="email">PAN:</label>
    <input type="email" class="form-control" id="pan" name="PAN">
  </div>
  </div>
  <div class="col-6">
 <div class="form-group">
    <label for="email">Second Factor Auth:</label>
    <input type="email" class="form-control" id="sfauth" name="SfAuth">
  </div>
  </div>
  <div class="col-6">
   <div class="form-group">
    <label for="email">State:</label>
    <input type="email" class="form-control" id="state" name="State">
  </div>
  </div>
  <div class="col-6">
 <div class="form-group">
    <label for="email">City:</label>
    <input type="email" class="form-control" id="city" name="City">
  </div>
  </div>
  
  
  </div>
  <div class="d-flex justify-content-center mt-3 login_container">
				 	<button type="button" name="button" class="btn login_btn" onclick = "userSubmit()">Submit</button>
				   </div>
				     </form>
				   
  </div>
  </body>
<script>
function userSubmit()
{
alert("tyst"+document.getElementById("RegistrationForm"));
document.getElementById("RegistrationForm").action = "newUserCreate";
document.getElementById("RegistrationForm").submit();

}
</script>
<style>
.module-border-wrap {
  max-width: 250px;
  padding: 1rem;
  position: relative;
  background: linear-gradient(to right, red, purple);
  padding: 3px;
}

.borderreg {
border-style: outset;
margin: 50px 15px 40px 80px;
background-color: white
}
</style>