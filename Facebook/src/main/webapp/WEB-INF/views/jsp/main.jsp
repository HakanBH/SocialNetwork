<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page errorPage="error.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">

<title>Asocialen.com</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href='http://fonts.googleapis.com/css?family=Roboto:400,300,100,500'
	rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Montserrat:400,700'
	rel='stylesheet' type='text/css'>

<link rel="stylesheet" href="css/post.css">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/customStyle.css">
<link rel="stylesheet" href="css/imageUpload.css">
<link rel="stylesheet" type="text/css"
	href="//netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
<script src="js/imageUpload.js"></script>

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
							<a class="name_left_new" href="#">&nbsp;${currentUser.firstName}
								${currentUser.lastName}</a>
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
			<!--  POST UPLOAD -->
			<form:form method="post" enctype="multipart/form-data"
				action="PostUpload">
				<div class="panel panel-white panel-shadow">
					<div class="panel-heading">
						<div id="image_space">
							<a href="#"> <img id="prof_pic_post"
								src="${currentUser.profilePath}" align="left">
							</a>
						</div>
						<h4 style="margin-left: 55px; margin-top: 25px">Upload a post
							on your timeline</h4>
					</div>
					<div class="panel-body">
						<div id="post_content">
							<textarea maxlength="255" rows="4" cols="63" class="form-control"
								name="postText" id="postText" style="resize: none"
								placeholder="What's on your mind?"></textarea>
						</div>
						<div class="input-group image-preview" align="right"
							style="margin-top: 10px">
							<span class="input-group-btn"> <!-- image-preview-clear button -->
								<button type="button"
									class="btn btn-default image-preview-clear"
									style="display: none;">
									<span class="glyphicon glyphicon-remove"></span> Clear
								</button> <!-- image-preview-input -->
								<div class="btn btn-default image-preview-input">
									<span class="glyphicon glyphicon-picture"></span> <span
										class="image-preview-input-title">Upload a picture</span> <input
										type="file" accept="image/png, image/jpeg, image/gif"
										name="picture" />
									<!-- rename it -->
								</div> <input class="btn btn-primary post image-preview-input"
								type="submit" value="Post">
							</span>
						</div>
					</div>
					<c:if test="${not empty imageError}">
						<div class="form-error" align="right">${imageError}</div>
					</c:if>
				</div>
			</form:form>
			<!-- END OF POST UPLOAD -->
			<!-- posts -->

			<c:forEach var="post" items="${posts}">
				<div class="panel panel-white post panel-shadow">
					<div class="post-heading">
						<div class="pull-left image">
							<a href="./extProfile/${post.owner.id}"><img src="${post.owner.profilePath}"
								class="img-circle avatar" alt="user profile image"></a>
						</div>
						<div class="pull-left meta">
							<div class="title h5">
								<a href="./extProfile/${post.owner.id}"><b>${post.owner.firstName}
										${post.owner.lastName}</b></a> made a post.
							</div>
							<h6 class="text-muted time">${post.created}</h6>
						</div>
					</div>
					<div class="post-description">
						<p>${post.text}</p>
						<c:if test="${not empty post.picture.name}">
							<img id="post_img" src="${post.picturePath}" align="middle">
						</c:if>

						<div class="stats">
							<c:forEach var="liked" items="${currentUser.likedPosts}">
								<c:if test="${liked eq post}">
									<c:set var="isLiked" value="true"></c:set>
								</c:if>
							</c:forEach>
							<c:choose>
								<c:when test="${isLiked eq true}">
									<form method="post" action="./unlikePost">
										<input name="unlikedPost" type="hidden" value="${post.id}">
										<div class="btn btn-default stat-item" style="color: green">
											<span class="fa fa-thumbs-up icon">
												${fn:length(post.likes)}</span> <input type="submit" class="stat">
										</div>
									</form>
								</c:when>
								<c:otherwise>
									<form method="post" action="./likePost">
										<input name="likedPost" type="hidden" value="${post.id}">
										<div class="btn btn-default stat-item">
											<span class="fa fa-thumbs-up icon">${fn:length(post.likes)}</span>
											<input type="submit" class="stat">
										</div>
									</form>
								</c:otherwise>
							</c:choose>
							<form:form method="post" action="./sharePost">
								<input type="hidden" name="sharedPost" value="${post.id}">
								<div class="btn btn-default stat-item">
									<span class="fa fa-share icon"> 12</span> <input type="submit"
										class="stat">
								</div>
							</form:form>
						</div>
					</div>

					<div class="post-footer">
						<form action="commentPost" method="post">
							<div class="input-group" style="width: 100% !important">
								<input type="hidden" name="commentedPost" value="${post.id}">
								<input type="text" name="commentText" required maxlength="60"
									placeholder="Add a comment" class="form-control"> <span
									class="input-group-btn">
									<div class="btn commentButton">
										<span>Comment</span> <input type="submit" class="commentForm" />
									</div>
								</span>
							</div>
						</form>
						<ul class="comments-list">
<<<<<<< HEAD

							<c:forEach var="postComment" items="${post.comments}">
								<li class="comment"><a class="pull-left" href="#"> <img
										class="avatar" src="${postComment.owner.profilePath}"
										alt="avatar">
								</a>
									<div class="comment-body">
										<div class="comment-heading">
											<h4 class="user">${postComment.owner.firstName}
												${postComment.owner.firstName}</h4>
=======
	
						<c:forEach var="postComment" items="${post.comments}">
								<li class="comment"><a class="pull-left" href="./extProfile/${postComment.owner.id}"> 
									<img class="avatar" src="${postComment.owner.profilePath}" alt="avatar">
								</a>
									<div class="comment-body">
										<div class="comment-heading">
											<a href="./extProfile/${postComment.owner.id}"><h4 class="user">${postComment.owner.firstName}
												${postComment.owner.firstName}</h4></a>
>>>>>>> 51ca50debfe70e08607b112a363cc23c58d655ac
											<h5 class="time">${postComment.created}</h5>
										</div>
										<p>${postComment.text}</p>
									</div></li>
							</c:forEach>
						</ul>
					</div>
				</div>
			</c:forEach>
		</div>

		<div id="right_col">
			<jsp:include page="may-know.jsp"></jsp:include>
		</div>
	</div>

</body>
</html>
