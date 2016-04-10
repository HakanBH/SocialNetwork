<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page errorPage="error.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link
	href='http://fonts.googleapis.com/css?family=Roboto:400,300,100,500'
	rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Montserrat:400,700'
	rel='stylesheet' type='text/css'>
<link href="css/post.css" rel="stylesheet">
<link href="css/lightbox.css" rel="stylesheet">
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/customStyle.css" rel="stylesheet">
<link href="css/imageUpload.css" rel="stylesheet">
<title>Asocialen.com</title>
</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	<div id="main_container">

		<jsp:include page="prof-pics.jsp"></jsp:include>

		<div class="panel panel-white panel-shadow"
			style="width: 100%; padding-left: 20px;">
			<div id="image_space">
				<a href="#"><img id="prof_pic_post" src="images/pic.png"
					align="left"> </a>
			</div>
			<h1 class="text_title">${selectedAlbum.title}</h1>
		</div>
		<div class="pic_container2 panel panel-white panel-shadow">
			<c:choose>
				<c:when test="${empty selectedPictures}">
					<div style="margin-left: 20px; height: 300px">
						<h2>This album is empty.</h2>
					</div>
				</c:when>
				<c:otherwise>
					<c:forEach var="pic" items="${selectedPictures}">
						<div class="responsive">
							<div class="img">
								<a id="basic"
									href="images/${currentUser.email}/${selectedAlbum.title}/${pic.name}"
									data-lightbox="album" pic-id="${pic.id}"
									style="text-decoration: none; color: black;"> <img
									class="album_pic"
									src="images/${currentUser.email}/${selectedAlbum.title}/${pic.name}"
									alt="${pic.name} Pic Not Found" width="300" height="200">
									<div class="desc">${pic.name}</div>
								</a>
							</div>
						</div>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</div>

		<div id="upload_pic" class="panel panel-white panel-shadow">


			<h3 style="font-weight: bold; margin-left: 20px;">Upload a
				picture</h3>
			<form:form method="POST"
				action="./albumFileUpload/${selectedAlbum.id}"
				enctype="multipart/form-data">
				<div class="btn btn-primary" style="height:34px; margin-left:25px; ">
					<input type="file" style="opacity:0; margin-top: -3px; height: 100%; width: 130px;"
						name="file"/>
						<p style="margin-top: -18px;">Choose file</p>

				</div>
				<input type="submit" class="btn btn-primary"
					style="margin-top: -1px;; width: 100px" value="Upload!" />


			</form:form>

			</span>



			<form class="upload_form" method="post" action="./renameAlbum"
				name="albumName" style="margin-top: 50px;">
				<h3 style="font-weight: bold;">Rename your album</h3>
				<input id="country" type="text" name="newName"
					style="margin-top: 7px; height: 34px"
					value="${selectedAlbum.title}" placeholder="New Name"> <input
					type="hidden" value="${selectedAlbum.id}" name="albumToRename">
				<button id="post_button2" class="btn btn-primary"
					style="margin-top: -3px;; width: 100px" type="submit">Rename!</button>
			</form>

			<form class="upload_form" method="post" action="./deleteAlbum"
				name="deleteAlbumForm" style="margin-top: 50px;">
				<h3 style="font-weight: bold;">Delete this album</h3>
				<input id="country" type="hidden" name="albumToDelete"
					value="${selectedAlbum.id}" placeholder="New Name">
				<button id="post_button2" class="btn btn-primary"
					style="margin-top: -3px;; width: 130px," type="submit">Delete
					Album!</button>
			</form>
		</div>


		<div class="corte"></div>
	</div>
	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script
		src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
	<script src="http://jqueryvalidation.org/files/dist/jquery.validate.js"></script>
	<script src="js/validation.js"></script>
	<script src="js/bg-changer.js"></script>
	<script src="js/lightbox-plus-jquery.js"></script>
</body>
</html>