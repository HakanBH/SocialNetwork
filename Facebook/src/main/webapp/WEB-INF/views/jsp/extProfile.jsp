<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page errorPage="error.jsp"%>

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
<link rel="stylesheet" href="css/imageUpload.css">
<link rel="stylesheet" type="text/css"
	href="//netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css">


<title>Asocialen.com</title>
</head>

<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	<div id="main_container">

		<div id="user_prof"
			style="background-image: url('${extUser.bgPath}');">
			<div id="pic_name_block">
				<a href="#"><img id="profpicturemain"
					src="${extUser.profilePath}" align="left"></a>
				<p id="user_name">${extUser.firstName}${extUser.lastName}</p>
			</div>
		</div>
		<div id="left_col">

			<div class="panel panel-white panel-shadow">
				<div id="image_space">
					<a href="./settings"><img id="prof_pic_post1"
						src="images/prof.png" align="left"> </a>
				</div>
				<div id="left_name">
					<p>
						<a class="name_left" href="./settings">&nbsp;Personal
							Information</a>
					</p>

					</br>
					<c:if test="${ not empty extUser.userInfo.relationshipStatus}">
						<p id="post_text" style="font-weight: bold; font-size: 20px;">Relationship
							status: ${extUser.userInfo.relationshipStatus}</p>
					</c:if>

					<c:if test="${ not empty extUser.userInfo.birthday}">
						<p id="post_text" style="font-weight: bold; font-size: 20px;">Birthday:
							${extUser.userInfo.birthday}</p>
					</c:if>

					<c:if test="${ not empty extUser.userInfo.gender}">
						<p id="post_text" style="font-weight: bold; font-size: 20px;">Gender:
							${extUser.userInfo.gender}</p>
					</c:if>

					<c:if test="${ not empty extUser.userInfo.city}">
						<p id="post_text" style="font-weight: bold; font-size: 20px;">City:
							${extUser.userInfo.city}</p>
					</c:if>
					<c:if test="${ not empty extUser.userInfo.country}">
						<p id="post_text" style="font-weight: bold; font-size: 20px;">Country:
							${extUser.userInfo.country}</p>
					</c:if>
					</br>


				</div>
			</div>

			<div class="panel panel-white panel-shadow">
				<div id="image_space">
					<a href="./album"><img id="prof_pic_post1" src="images/pic.png"
						align="left"> </a>
				</div>
				<div id="left_name">
					<p>
						<a class="name_left" href="./album">&nbsp;Pictures</a>
					</p>
				</div>

				<div id="photo_container">
					<c:forEach begin="0" end="8" var="picture" items="${pictures}">
						<c:if test="${not empty picture.name}">
							<a href="./pictures/${picture.album.id}"><img
								id="pictures_min"
								src="images/${extUser.email}/${picture.album.title}/${picture.name}"
								align="left"></a>
						</c:if>
					</c:forEach>
				</div>

				<p>
					</br>&nbsp;</br>
				</p>
			</div>

			<div class="panel panel-white panel-shadow">
				<div id="image_space">
					<a href="./friends"><img id="prof_pic_post"
						src="images/friends.png" align="left"> </a>
				</div>
				<div id="left_name">
					<p>
						<a class="name_left" href="./friends">&nbsp;Friends</a>
					</p>
				</div>

				<div id="photo_container">
					<c:forEach begin="0" end="8" var="friend" items="${friends}">
						<a href="./extProfile/${friend.id}"><img id="pictures_min"
							src="${friend.profilePath}" align="left"></a>
					</c:forEach>
				</div>

				<p>
					</br>&nbsp;</br>
				</p>
			</div>
		</div>

		<div id="center_col">
			<!-- posts -->
			<c:forEach var="post" items="${extUser.ownedPosts}">
				<div class="panel panel-white post panel-shadow">
					<div class="post-heading">
						<div class="pull-left image">
							<a href="./extProfile/${post.owner.id}"><img
								src="${post.owner.profilePath}" class="img-circle avatar"
								alt="user profile image"></a>
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
											<span class="fa fa-thumbs-up icon">
												${fn:length(post.likes)}</span> <input type="submit" class="stat">
										</div>
									</form>
								</c:otherwise>
							</c:choose>

							<c:forEach var="shared" items="${currentUser.sharedPosts}">
								<c:if test="${shared eq post}">
									<c:set var="isShared" value="true"></c:set>
								</c:if>
							</c:forEach>
							<c:choose>
								<c:when test="${isShared eq true}">
									<div class="btn btn-default stat-item" style="color: #1E7FC5">
										<span class="fa fa-share icon">
											${fn:length(post.shares)}</span> <input type="submit" class="stat">
									</div>
								</c:when>
								<c:otherwise>
									<form method="post" action="./sharePost">
										<input type="hidden" name="sharedPost" value="${post.id}">
										<div class="btn btn-default stat-item">
											<span class="fa fa-share icon">
												${fn:length(post.shares)} </span> <input type="submit" class="stat">
										</div>
									</form>
								</c:otherwise>
							</c:choose>
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
							<c:forEach var="postComment" items="${post.comments}">
								<li class="comment"><a class="pull-left"
									href="./extProfile/${postComment.owner.id}"> <img
										class="avatar" src="${postComment.owner.profilePath}"
										alt="avatar">
								</a>
									<div class="comment-body">
										<div class="comment-heading">
											<a href="./extProfile/${postComment.owner.id}">
												<h4 class="user">${postComment.owner.firstName}
													${postComment.owner.firstName}</h4>
											</a>

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

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script
		src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
	<script src="http://jqueryvalidation.org/files/dist/jquery.validate.js"></script>
	<script src="js/validation.js"></script>
	<script src="js/bg-changer.js"></script>
</body>
</html>