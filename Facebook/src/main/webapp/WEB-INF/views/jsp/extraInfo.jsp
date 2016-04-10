<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page errorPage="error.jsp"%>

<!DOCTYPE html">
<html>
<head>
<meta charset=UTF-8>

<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
<script src="js/imageUpload.js"></script>

<link rel="stylesheet" href="css/customStyle.css">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/imageUpload.css">


<title>Registration successful.</title>
</head>

<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	<div class="container">

		<div class="row">
			<div class="col-md-offset-2 col-md-8">
				<div class="row">
					<div class="col-md-2" style="margin-top: 20px">
						<span class="glyphicon glyphicon-ok-circle"
							style="font-size: 90px; color: #366296"> </span>
					</div>
					<div class="col-md-10">
						<h1>
							Congratulations ${currentUser.firstName}.<br> Your registration was
							successful.
						</h1>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<h3 style="margin-top: 20px">Just a few more steps before you
							can connect with your friends.</h3>
					</div>
				</div>
				<div class="form-group2">
					<h4>
						<label> Upload a picture so your friends can recognize
							you.</label>
					</h4>
					<div class="row">
						<div class="col-md-8">
							<form:form method="post" enctype="multipart/form-data"
								action="ImageUpload">
								<div class="input-group image-preview">
									<input type="text" class="form-control image-preview-filename"
										disabled="disabled"> <span class="input-group-btn">
										<!-- image-preview-clear button -->
										<button type="button"
											class="btn btn-default image-preview-clear"
											style="display: none;">
											<span class="glyphicon glyphicon-remove"></span> Clear
										</button> <!-- image-preview-input -->
										<div class="btn btn-default image-preview-input">
											<span class="glyphicon glyphicon-folder-open"></span> <span
												class="image-preview-input-title">Browse</span> <input
												type="file" accept="image/png, image/jpeg, image/gif"
												name="picture" />
											<!-- rename it -->
										</div> <input class="btn btn-info image-preview-input" type="submit"
										value="Save">
									</span>
								</div>
							</form:form>
						</div>
					</div>
				</div>
				
				<c:if test="${not empty imageError}">
					<div class="form-error" style="margin-top:-10px">
						<c:out value="${imageError}">
						</c:out>
					</div>
				</c:if>
			
				
				<form:form action="uploadInfo" id="uploadInfo"
					commandName="userInfo">


					<div class="row">
						<div class="col-md-5">
							<div class="form-group2">
								<h4>
									<label class="control-label" for="date">What is your
										birthday ?</label>
								</h4>
								<form:input path="birthday" type="date" id="birthday"
									class="form-control" />
							</div>
						</div>
						<div class="col-md-5">
							<div class="form-group2">
								<h4>
									<label class="control-label" for="mobilePhone">Phone
										Number: </label>
								</h4>
								<input type="text" name="mobilePhone" id="mobilePhone"
									placeholder="Number" class="form-control">
							</div>
						</div>
					</div>

					<div class="form-group2">
						<h4>
							<label class="control-lable" for="country"> Location: </label>
						</h4>
						<div class="row">
							<div class="col-md-4">
								<input type="text" name="country" id="country"
									placeholder="Country" class="form-control">
							</div>
							<div class="col-md-4">
								<input type="text" name="city" id="city" placeholder="City/Town"
									class="form-control">
							</div>
						</div>
					</div>

					<div class="row form-group2">
						<div class="col-md-5">
							<h4>
								<label class="control-label" for="address">Address: </label>
							</h4>
							<input type="text" name="address" id="address"
								placeholder="Address" class="form-control">
						</div>
					</div>

					<div class="row">
						<div class="form-group">
							<div class="col-md-5">
								<h4>
									<label class="control-label" for="relationshipStatus">Relationship
										Status: </label>
								</h4>
								<form:select path="relationshipStatus" id="relationshipStatus"
									class="form-control">
									<option value="" selected>---</option>
									<option value="Single">Single</option>
									<option value="In a relationship">In a relationship</option>
									<option value="Engaged">Engaged</option>
									<option value="Married">Married</option>
									<option value="Divorced">Divorced</option>
									<option value="Widowed">Widowed</option>
								</form:select>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-5">
							<div class="form-group">
								<h4>
									<label class="control-label" for="gender">Gender: </label> <label
										class="radio-inline" for="male"> <form:radiobutton
											path="gender" id="male" value="male" /> Male
									</label> <label class="radio-inline" for="female"> <form:radiobutton
											path="gender" id="female" value="female" /> Female
									</label>
								</h4>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-5">
							<input type="submit" class="form-control btn btn-info"
								value="Complete Registration">
						</div>
						<div class="col-md-offset-3 col-md-4" style="margin-top: 15px">
							<a href="./main" style="color: #263859; font-size: 15px;">Skip
								this part.</a>
						</div>
					</div>
				</form:form>
			</div>
			<div class="col-md-offset-2"></div>
		</div>
	</div>
</body>

</html>