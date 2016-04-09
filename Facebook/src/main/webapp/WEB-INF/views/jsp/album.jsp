<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page errorPage="error.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link
	href='http://fonts.googleapis.com/css?family=Roboto:400,300,100,500'
	rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Montserrat:400,700'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="css/post.css">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/customStyle.css">
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
			<h1 class="text_title">ALBUMS</h1>
		</div>

		<div class="pic_container panel panel-white panel-shadow">
			<c:choose>
				<c:when test="${empty albums}">
					<div style="margin-left:20px; height: 300px">
						<h2>No albums to show.</h2>
					</div>
				</c:when>
				<c:otherwise>
					<c:forEach var="album" items="${albums}">
						<div class="polaroid" align="left">
							<a href="./pictures/${album.id}"
								style="text-decoration: none; color: black;"> <c:choose>
									<c:when test="${not empty album.pictures[0]}">
										<img class="album"
											src="images/${currentUser.email}/${album.title}/${album.pictures[0].name}"
											alt="${album.title}">
									</c:when>
									<c:otherwise>
										<h1
											style="height: 90px; text-align: center; margin-top: 100px; font-weight: bold;">Empty
											album</h1>
									</c:otherwise>
								</c:choose>

								<div class="desc">
									<p style="text-decoration: none;">${album.title}</p>
								</div>
							</a>
						</div>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</div>

		<div id="new_album" class="panel panel-white panel-shadow"
			style="height: 130px;">

			<form class="upload_form" method="post" action="./createAlbum"
				name="albumName">
				<h3 style="font-weight: bold;">Create a new album</h3>
				<input id="country" type="text" name="newName"
					placeholder="Album Name">
				<button id="post_button2" type="submit">Create!</button>
			</form>
		</div>
	</div>


	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script
		src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
	<script src="http://jqueryvalidation.org/files/dist/jquery.validate.js"></script>
	<script src="js/validation.js"></script>
	<script src="js/bg-changer.js"></script>
</body>
</html>