<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page errorPage="error.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">

<title>Home page</title>
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


<style type="text/css">
</style>
</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>



	<div id="main_container">
		<div id="left_col">
			<div class="panel panel-white panel-shadow">
				<div class="panel-heading" style="padding-bottom: 30px">
					<div id="image_space">
						<img id="prof_pici" src="${currentUser.profilePath}" align="left">
					</div>
					<div id="left_name">
						<p>
							<a class="name_left_new" href="#">&nbsp;${currentUser.firstName} ${currentUser.lastName}</a>
						</p>
					</div>
				</div>
				<div class="panel-body">
					<ul class="left-list">
						<li>
							<div class="link_container">
								<a href="./profile"><img id="prof_pic_post"
									src="images/prof.png" align="left"></a><a class="name_left2"
									href="./profile"> &nbsp; Profile</a>
							</div>
						</li>

						<li>
							<div class="link_container">
								<a href="./friends"><img id="prof_pic_post"
									src="images/friends.png" align="left"></a><a
									class="name_left2" href="./friends"> &nbsp;Friends</a>
							</div>
						</li>

						<li>
							<div class="link_container">
								<a href="./album"><img id="prof_pic_post"
									src="images/pic.png" align="left"></a><a class="name_left2"
									href="./album"> &nbsp;Albums</a>
							</div>
						</li>

						<li>
							<div class="link_container">
								<a href="./settings"><img id="prof_pic_post"
									src="images/set.png" align="left"></a><a class="name_left2"
									href="./settings"> &nbsp;Settings</a>
							</div>
						</li>
					</ul>
				</div>
			</div>
		</div>

		<div id="center_col">
			<div class="panel panel-white panel-shadow">
				<div class="panel-heading" style="padding-bottom: 60px">
					<div id="image_space">
						<a href="#"> <img id="prof_pic_post"
							src="${currentUser.profilePath}" align="left">
						</a>
						<a href="#"><img class="face_icon" src="images/pic.png"
							align="right"></img></a>
					</div>
				</div>
				<div class="panel-body">
					<div id="post_content">
						<form method="post" action="/post" id="post_text_box" style="">
							<textarea maxlength="255" rows="4" cols="63" class="form-control"
								name="info" id="info" style="resize: none"
								placeholder="What's on your mind?"></textarea>
						</form>
					</div>
					<div id="panel">
						<button id="post_button" type="submit">Post</button>
					</div>
				</div>
			</div>
			<!-- posts -->
			<c:forEach var="post" items="${posts}">
				<div class="panel panel-white post panel-shadow">
					<div class="post-heading">
						<div class="pull-left image">
							<a href="#"><img src="${post.owner.profilePath}"
								class="img-circle avatar" alt="user profile image"></a>
						</div>
						<div class="pull-left meta">
							<div class="title h5">
								<a href="#"><b>${post.owner.firstName}
										${post.owner.lastName}</b></a> made a post.
							</div>
							<h6 class="text-muted time">${post.created}</h6>
						</div>
					</div>
					<div class="post-description">
						<p>${post.text}</p>
						<div class="stats">
							<a href="#" class="btn btn-default stat-item"> <i
								class="fa fa-thumbs-up icon"></i>2
							</a> <a href="#" class="btn btn-default stat-item"> <i
								class="fa fa-share icon"></i>12
							</a>
						</div>
					</div>
					<div class="post-footer">
						<div class="input-group">
							<input type="text" class="form-control"
								placeholder="Add a comment"> <span
								class="input-group-addon"> <a href="#"><i
									class="fa fa-edit"></i></a>
							</span>
						</div>
						<ul class="comments-list">
							<li class="comment"><a class="pull-left" href="#"> <img
									class="avatar" src="http://bootdey.com/img/Content/user_1.jpg"
									alt="avatar">
							</a>
								<div class="comment-body">
									<div class="comment-heading">
										<h4 class="user">Gavino Free</h4>
										<h5 class="time">5 minutes ago</h5>
									</div>
									<p>Sure, oooooooooooooooohhhhhhhhhhhhhhhh</p>
								</div>
								<ul class="comments-list">
									<li class="comment"><a class="pull-left" href="#"> <img
											class="avatar"
											src="http://bootdey.com/img/Content/user_3.jpg" alt="avatar">
									</a>
										<div class="comment-body">
											<div class="comment-heading">
												<h4 class="user">Ryan Haywood</h4>
												<h5 class="time">3 minutes ago</h5>
											</div>
											<p>Relax my friend</p>
										</div></li>
									<li class="comment"><a class="pull-left" href="#"> <img
											class="avatar"
											src="http://bootdey.com/img/Content/user_2.jpg" alt="avatar">
									</a>
										<div class="comment-body">
											<div class="comment-heading">
												<h4 class="user">Gavino Free</h4>
												<h5 class="time">3 minutes ago</h5>
											</div>
											<p>Ok, cool.</p>
										</div></li>
								</ul></li>
						</ul>
					</div>
				</div>
			</c:forEach>
		</div>

		<div id="right_col">
			<jsp:include page="may-know.jsp"></jsp:include>
		</div>
	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script
		src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>

</body>
</html>
