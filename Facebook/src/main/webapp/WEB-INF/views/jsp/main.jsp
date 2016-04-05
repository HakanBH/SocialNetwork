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
<link href='http://fonts.googleapis.com/css?family=Roboto:400,300,100,500'
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
			<div id="first_left">
				<div id="image_space">
					
					<img id="prof_pici" src="${currentUser.profilePath}"
								align="left">
					
				</div>
				<div id="left_name">
					<p>
						<a class="name_left_new" href="#">&nbsp;${currentUser.firstName}
							${currentUser.lastName}</a>
					</p>
				</div>

				<br>
				<div style="float: none; margin-top: 20px;">
					<ul class="left-list">

						<li>
							<div class="link_container">
								<a href="./profile"><img id="prof_pic_post" src="images/prof.png"
									align="left"></a><a class="name_left2" href="./profile">
									&nbsp; Profile</a>
							</div>
						</li>

						<li>
							<div class="link_container">
								<a href="./friends"><img id="prof_pic_post" src="images/friends.png"
									align="left"></a><a class="name_left2" href="./friends">
									&nbsp;Friends</a>
							</div>
						</li>

						<li>
							<div class="link_container">
								<a href="./album"><img id="prof_pic_post" src="images/pic.png"
									align="left"></a><a class="name_left2" href="./album">
									&nbsp;Albums</a>
							</div>
						</li>

						<li>
							<div class="link_container">
								<a href="./settings"><img id="prof_pic_post" src="images/set.png"
									align="left"></a><a class="name_left2" href="./settings">
									&nbsp;Settings</a>
							</div>
						</li>
					</ul>
				</div>
			</div>
		</div>
		
		<div id="center_col">
			<div id="create_post">
				<div id="image_space">
					<a href="#"> <img id="prof_pic_post"
						src="${currentUser.profilePath}"
						align="left">
					</a>
				</div>
				<div id="post_content">
					<form method="post" action="/post" id="post_text_box" 
						style="">
						<textarea rows="4" cols="63" class="form-control" name="info"
							id="info" style="resize: none" placeholder="What's on your mind?"></textarea>
					</form>
				</div>
				<div id="panel">
					<a href="#"><img class="face_icon" src="images/pic.png"
						align="left"></img></a>
					<button id="post_button" type="submit" >Post</button>
				</div>
			</div>
				 	<!-- posts -->
			<c:forEach var="post" items="${posts}">
				<div id="new_post">
					<div id="post_content">
						<div id="image_space">
							<a href="#"><img id="prof_pic_post"
								src=${currentUser.firstName } align="left"> </a>
							<p id="post_info">
								<a href="#">${currentUser.firstName} ${currentUser.lastName}</a>
								<br> ${post.created}
							</p>
						</div>
						<p id="post_text">
							${post.text}
						</p>
						<img id="post_img" src="images/image.png" align="middle">
						<div class="row">
							<div class="col-md-offset-1 col-md-8">
								<div class="icon_div">
									<a href="#"><span class="glyphicon glyphicon-thumbs-up"></span>
										Likes</a>
								</div>
								<div class="icon_div">
									<a href="#"><span class="glyphicon glyphicon-comment"></span>
										Comment</a>
								</div>
								<div class="icon_div">
									<a href="#"><span class="glyphicon glyphicon-share"></span>
										Share</a>
								</div>
							</div>
						</div>
						<div id="input-group">
							<img id="prof_pic_post" src="images/default.png" align="left">
							<input class="form-comment" placeholder="Add a comment"
								type="text">
						</div>
					</div>

					<ul class="comments-list">
						<li class="comment">
							<div id="post_content2">
								<div id="image_space">
									<a href="#"><img id="prof_pic_post"
										src="images/default.png" align="left"> </a>
									<p id="post_info">
										<a href="#">User Name Here</a>  Time Here!
									</p>
								</div>
								<p id="post_text">Ius id vidit volumus mandamus, vide
									veritus democritum te nec, ei eos debet libris consulatu. No
									mei ferri graeco dicunt, ad cum veri accommodare. Sed at malis
									omnesque delicata, usu et iusto zzril meliore. Dicunt maiorum
									eloquentiam cum cu, sit summo dolor essent te. Ne quodsi
									nusquam legendos has, ea dicit voluptua eloquentiam pro, ad sit
									quas qualisque. Eos vocibus deserunt quaestio ei.</p>
								<img id="post_img" src="images/background-1.jpg" align="middle">
								<div id="panel">
									<div class="icon_div">
										<a href="#"><img class="face_icon" src="images/like.png"
											align="left" alt="Alt text">Likes</a>
									</div>
									<div class="icon_div">
										<a href="#"><img class="face_icon"
											src="images/Comment.png" align="left">Comment</a>
									</div>
									<div class="icon_div">
										<a href="#"><img class="face_icon" src="images/share.png"
											align="left">Share</a>
									</div>
								</div>
							</div>
							<p>
								<br>&nbsp;<br>
							</p>
						</li>
						<li class="comment">
							<div id="post_content2">
								<div id="image_space">
									<a href="#"><img id="prof_pic_post"
										src="images/default.png" align="left"> </a>
									<p id="post_info">
										<a href="#">User Name Here</a> <br> Time Here!
									</p>
								</div>
								<p id="post_text">Ius id vidit volumus mandamus, vide
									veritus democritum te nec, ei eos debet libris consulatu. No
									mei ferri graeco dicunt, ad cum veri accommodare. Sed at malis
									omnesque delicata, usu et iusto zzril meliore. Dicunt maiorum
									eloquentiam cum cu, sit summo dolor essent te. Ne quodsi
									nusquam legendos has, ea dicit voluptua eloquentiam pro, ad sit
									quas qualisque. Eos vocibus deserunt quaestio ei.</p>
							</div>
							<p>
								<br>&nbsp;<br>
							</p>
						</li>
					</ul>
				</div>
			</c:forEach>
		</div>



		<div id="right_col">
			<jsp:include page="may-know.jsp"></jsp:include>
		</div>
	</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>

</body>
</html>
