<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page errorPage="error.jsp" %>
<!DOCTYPE html">
<html>
<head>
<meta charset=UTF-8>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
<script src="js/imageUpload.js"> </script>

<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/imageUpload.css">
<link rel="stylesheet" href="css/style.css">

<title>Registration successful.</title>
</head>

<body>
	<jsp:include page="navbar-logged.jsp"></jsp:include>
	<div class="container">
	
		<div class="row" style="margin-top: 100px">
			<div class="col-md-offset-2"></div>
			<div class="col-md-8">
				<div class="row">
					<div class="col-md-2" style="margin-top: 20px">
						<span class="glyphicon glyphicon-ok-circle" style="font-size:90px; color: #366296" > </span>
					</div>
					<div class="col-md-10">
						<h1>Congratulations ${user.firstName}.<br> Your registration was successful.</h1>
					</div>
				</div>	
				<div class="row">
					<div class="col-md-12">
						<h3 style="margin-top:20px">Just a few more steps before you can connect with your
							friends.</h3>
					</div>
				</div>
				<div class="row">
				
				</div>
				<form:form action="./ImageUpload" method="post" enctype="multipart/form-data">
					<div class="form-group2">
						<h4><label> Upload a picture so your friends can recognize you.</label></h4>
						<div class="row">    
					        <div class="col-md-6">  
					            <div class="input-group image-preview">
					                <input type="text" class="form-control image-preview-filename" disabled="disabled">
					                <span class="input-group-btn">
					                    
					                    <!-- image-preview-clear button -->
					                    <button type="button" class="btn btn-default image-preview-clear" style="display:none;">
					                        <span class="glyphicon glyphicon-remove"></span> Clear
					                    </button>
					                    
					                    <!-- image-preview-input -->
					                    <div class="btn btn-default image-preview-input">
					                        <span class="glyphicon glyphicon-folder-open"></span>
					                        <span class="image-preview-input-title">Browse</span>
					                        <input type="file" accept="image/png, image/jpeg, image/gif" name="profile-pic"/> <!-- rename it -->
					                    </div>
					               	</span>
					            	
					            </div>
					        </div>
					    </div>
					</div>
					
					<c:if test="${not empty imageError}">
	                	<div class="form-group2 form-error">
	                		<c:out value="${imageError}"> </c:out>
	              		</div>
	          	 	</c:if>  
					
					<div class="row">
						<div class="col-md-5">
							<div class="form-group2">	
								<h4><label class="control-label" for="date">What is your birthday ?</label> </h4>
								<input type="date" id="birthday" name="birthday" class="form-control">	
							</div>
						</div>	
						<div class="col-md-5">
							<div class="form-group2">
				   			<h4><label class="control-label" for="number">Phone Number: </label></h4>
				   				<input type="text" name="number" id="number" placeholder="Number"
									class="form-control">
							</div>	
						</div>
			   		</div>		
					
					<div class="form-group2">					
						<h4> <label class="control-lable" for="country"> Location: </label></h4>
						<div class="row">	
							<div class="col-md-4">
								<input type="text" name="country" id="country" placeholder="Country"
									class="form-control">
							</div>
							<div class="col-md-4">
								<input type="text" name="city" id="city" placeholder="City/Town" 
									class="form-control" >
							</div>
						</div>
			   		</div>
			   		
			   		<div class="row form-group2">
		   				<div class="col-md-5">
		   				<h4><label class="control-label" for="address">Address: </label></h4>
		   					<input type="text" name="address" id="address" placeholder="Address" 
								class="form-control" >
						</div>
			   		</div>
			   		
			   		<div class="row">
			   			<div class="form-group">
			   				<div class="col-md-5">
			   					<h4> <label class="control-label" for="relationship">Relationship Status: </label></h4>
								<select name="relationship" id="relationship" class="form-control">
									<option value="" selected>---</option>
									<option value="single">Single</option>
									<option value="inRelationship">In a relationship</option>
									<option value="engaged">Engaged</option>
									<option value="married">Married</option>
									<option value="moto">Divorced</option>
									<option value="аgro">Widowed</option>
								</select>
							</div>
			   			</div>
			   		</div>
			   		<div class="row">
			   			<div class="col-md-5">
							<div class="form-group">					
								<h4><label class="control-label" for="gender">Gender: </label>
								<label class="radio-inline" for="man">
							    	<input type="radio" name="gender" id="man" value="man"> Man
							   	</label> 
						   		<label class="radio-inline" for="woman">
						    		<input type="radio" name="gender" id="woman" value="woman"> Woman				   		
						   		</label></h4>
							</div>
				   		</div> 
			   		</div>
			   		<div class="row">
			   			<div class="col-md-5">
			   				<input type="submit" class="form-control btn btn-info" value="Complete Registration"> 
				   		</div>
				   		<div class="col-md-offset-3 col-md-4" style="margin-top: 17px" >
				   			<a href="/main" style="color:blue; font-size:20px;" >Skip this part.</a>
				   		</div>
			   		</div>
			  	</form:form>
			</div>
			<div class="col-md-offset-2"></div>
		</div>
	</div>
</body>

</html>