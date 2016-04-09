<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page errorPage="error.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href='http://fonts.googleapis.com/css?family=Roboto:400,300,100,500'
	rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Montserrat:400,700'
	rel='stylesheet' type='text/css'>

<link
	href="//netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="css/post.css">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/customStyle.css">
<title>Asocialen.com</title>
</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	<div id="main_container">
		<jsp:include page="prof-pics.jsp"></jsp:include>

		<div id="album_title">
			<div id="image_space">
				<a href="#"><img id="prof_pic_post" src="images/friends.png"
					align="left"> </a>
			</div>
			<h1 class="text_title">FRIENDS</h1>
		</div>

		<div class="pic_container3">

			<c:forEach var="friend" items="${currentUser.friends}">
				<div class="friend_container">
					<div class="friend_pic">
						<a href="#"><img id="friend_pic_size"
							src="${friend.profilePath}" align="left"></a>
					</div>
					<div class="friend_name">
						<a href="#" class="name_friend">${friend.firstName}
							${friend.lastName}</a>
					</div>
					<div class="friend_button">
						<form action="./unfollowUser" method="POST">
							<input name="userToRemove" type="hidden" value="${friend.id}">
							<input type="submit" id="post_button2" value="Unfollow!">
						</form>
					</div>
				</div>
			</c:forEach>



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