<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page errorPage="error.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">

<link
	href="//netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
	rel="stylesheet">

<link rel="stylesheet" href="css/post.css">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/customStyle.css">
<link rel="stylesheet" href="css/imageUpload.css">

<title>Asocialen.com</title>
</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	<div id="main_container">
		<jsp:include page="prof-pics.jsp"></jsp:include>

		<div class="panel panel-white panel-shadow" style="padding-left: 20px; width:100%">
			<div id="image_space">
				<a href="#"><img id="prof_pic_post" src="images/set.png"
					align="left"> </a>
			</div>
			<h1 class="text_title">SETTINGS</h1>
		</div>

		<div class="container pic_container3 panel panel-white panel-shadow"  >
			<div class="row">
				<div class="col-md-offset-2 col-md-8">
					<div class="form-group2">
						<h4>
							<label> Upload a new background picture.</label>
						</h4>
						<div class="row">
							<div class="col-md-8">
								<form:form method="post" enctype="multipart/form-data"
									action="BgImageUpload">
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
											</div> <input class="btn btn-info image-preview-input"
											type="submit" value="Save">
										</span>
									</div>
								</form:form>
							</div>
						</div>
					</div>

					<div class="form-group2">
						<h4>
							<label> Upload a new picture.</label>
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
											</div> <input class="btn btn-info image-preview-input"
											type="submit" value="Save">
										</span>
									</div>
								</form:form>
							</div>
						</div>
					</div>

					<c:if test="${not empty imageError}">
						<div class="form-error" style="margin-top: -10px">
							<c:out value="${imageError}">
							</c:out>
						</div>
					</c:if>

					<form:form action="modifyInfo" id="modifyInfo" commandName="userInfo">
						<div class="row">
							<div class="col-md-5">
								<div class="form-group2">
									<h4>
										<label class="control-label" for="date">Your birthday:</label>
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
										placeholder="Number" class="form-control"
										value="${userInfo.mobilePhone}">
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
										placeholder="Country" class="form-control"
										value="${userInfo.country}">
								</div>
								<div class="col-md-4">
									<input type="text" name="city" id="city"
										placeholder="City/Town" class="form-control"
										value="${userInfo.city}">
								</div>
							</div>
						</div>

						<div class="row form-group2">
							<div class="col-md-5">
								<h4>
									<label class="control-label" for="address">Address: </label>
								</h4>
								<input type="text" name="address" id="address"
									placeholder="Address" class="form-control"
									value="${userInfo.address}">
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
										<option value="${userInfo.relationshipStatus}" selected>${userInfo.relationshipStatus}</option>
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
											class="radio-inline" for="man"> <form:radiobutton
												path="gender" id="man" value="man" /> Man
										</label> <label class="radio-inline" for="woman"> <form:radiobutton
												path="gender" id="woman" value="woman" /> Woman
										</label>
									</h4>
								</div>
							</div>
						</div>


						<div class="row">
							<div class="col-md-5">
								<input type="submit" class="form-control btn btn-info"
									value="Change!">
							</div>
						</div>
					</form:form>
				</div>
				<div class="col-md-offset-2"></div>
			</div>
		</div>
	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script
		src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
	<script src="js/imageUpload.js"></script>

</body>
</html>