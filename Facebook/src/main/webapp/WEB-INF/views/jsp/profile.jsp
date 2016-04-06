<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page errorPage="error.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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

		<div id="left_col">
			<div id="first_left">
				<div id="image_space">
					<a href="./settings"><img id="prof_pic_post1" src="images/prof.png"
						align="left"> </a>
				</div>
				<div id="left_name">
					<p>
						<a class="name_left" href="./settings">&nbsp;Personal Information</a>
					</p>


					</br>
					<p id="post_text">Ius id vidit volumus mandamus, vide veritus
						democritum te nec, ei eos debet libris consulatu. No mei ferri
						graeco dicunt, ad cum veri accommodare. Sed at malis omnesque
						delicata, usu et iusto zzril meliore. Dicunt maiorum eloquentiam
						cum cu, sit summo dolor essent te. Ne quodsi nusquam legendos has,
						ea dicit voluptua eloquentiam pro, ad sit quas qualisque. Eos
						vocibus deserunt quaestio ei. Blandit incorrupte</p>
				</div>
			</div>

			<div id="first_left">
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
					<img id="pictures_min" src="images/default.png" align="left">
					<img id="pictures_min" src="images/default.png" align="left">
					<img id="pictures_min" src="images/default.png" align="left">
					<img id="pictures_min" src="images/default.png" align="left">
					<img id="pictures_min" src="images/default.png" align="left">
					<img id="pictures_min" src="images/default.png" align="left">
					<img id="pictures_min" src="images/default.png" align="left">
					<img id="pictures_min" src="images/default.png" align="left">
					<img id="pictures_min" src="images/default.png" align="left">
				</div>

				<p>
					</br>&nbsp;</br>
				</p>
			</div>

			<div id="first_left">
				<div id="image_space">
					<a href="./friends"><img id="prof_pic_post" src="images/friends.png"
						align="left"> </a>
				</div>
				<div id="left_name">
					<p>
						<a class="name_left" href="./friends">&nbsp;Friends</a>
					</p>
				</div>
				<div id="photo_container">
					<img id="pictures_min" src="images/default.png" align="left">
					<img id="pictures_min" src="images/default.png" align="left">
					<img id="pictures_min" src="images/default.png" align="left">
					<img id="pictures_min" src="images/default.png" align="left">
					<img id="pictures_min" src="images/default.png" align="left">
					<img id="pictures_min" src="images/default.png" align="left">
					<img id="pictures_min" src="images/default.png" align="left">
					<img id="pictures_min" src="images/default.png" align="left">
					<img id="pictures_min" src="images/default.png" align="left">
				</div>

				<p>
					</br>&nbsp;</br>
				</p>
			</div>


		</div>
		<div id="center_col">
			<div id="create_post">
				<div id="image_space">
					<a href="#"><img id="prof_pic_post"
						src="${currentUser.profilePath}" align="left"> </img></a>
				</div>
				<div id="post_content">
					<form method="post" action="/post" id="post_text_box" align="left"
						style="">
						<input class="post_text" name="post" type="text"
							placeholder="What´s happening..." />
					</form>
				</div>
				<div id="panel">
					<a href="#"><img class="face_icon" src="images/pic.png"
						align="left"></img></a>
					<button id="post_button" type="submit" align="right">Post</button>
				</div>
			</div>
			<div id="new_post">
				<div id="post_content">
					<div id="image_space">
						<a href="#"><img id="prof_pic_post" src="images/default.png"
							align="left"> </img></a>
						<p id="post_info">
							<a href="#">User Name Here</a> </br> Time Here!
						</p>
					</div>
					<p id="post_text">Ius id vidit volumus mandamus, vide veritus
						democritum te nec, ei eos debet libris consulatu. No mei ferri
						graeco dicunt, ad cum veri accommodare. Sed at malis omnesque
						delicata, usu et iusto zzril meliore. Dicunt maiorum eloquentiam
						cum cu, sit summo dolor essent te. Ne quodsi nusquam legendos has,
						ea dicit voluptua eloquentiam pro, ad sit quas qualisque. Eos
						vocibus deserunt quaestio ei. Blandit incorrupte quaerendum in
						quo, nibh impedit id vis, vel no nullam semper audiam. Ei populo
						graeci consulatu mei, has ea stet modus phaedrum. Inani oblique ne
						has, duo et veritus detraxit. Tota ludus oratio ea mel, offendit
						persequeris ei vim. Eos dicat oratio partem ut, id cum ignota
						senserit intellegat. Sit inani ubique graecis ad, quando graecis
						liberavisse et cum, dicit option eruditi at duo. Homero salutatus
						suscipiantur eum id, tamquam voluptaria expetendis ad sed, nobis
						feugiat similique usu ex. Eum hinc argumentum te, no sit percipit
						adversarium, ne qui feugiat persecuti. Odio omnes scripserit ad
						est, ut vidit lorem maiestatis his, putent mandamus gloriatur ne
						pro. Oratio iriure rationibus ne his, ad est corrumpit splendide.
						Ad duo appareat moderatius, ei falli tollit denique eos. Dicant
						evertitur mei in, ne his deserunt perpetua sententiae, ea sea
						omnes similique vituperatoribus. Ex mel errem intellegebat
						comprehensam, vel ad tantas antiopam delicatissimi, tota ferri
						affert eu nec. Legere expetenda pertinacia ne pro, et pro impetus
						persius assueverit.</p>
					<img id="post_img" src="images/default3.png" align="center">
					<div id="panel">
						<div class="icon_div">
							<a href="#"><img class="face_icon" src="images/like.png"
								align="left" alt="Alt text">Likes</a>
						</div>
						<div class="icon_div">
							<a href="#"><img class="face_icon" src="images/Comment.png"
								align="left">Comment</a>
						</div>
						<div class="icon_div">
							<a href="#"><img class="face_icon" src="images/share.png"
								align="left">Share</a>
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
								<a href="#"><img id="prof_pic_post" src="images/default.png"
									align="left"> </img></a>
								<p id="post_info">
									<a href="#">User Name Here</a> </br> Time Here!
								</p>
							</div>
							<p id="post_text">Ius id vidit volumus mandamus, vide veritus
								democritum te nec, ei eos debet libris consulatu. No mei ferri
								graeco dicunt, ad cum veri accommodare. Sed at malis omnesque
								delicata, usu et iusto zzril meliore. Dicunt maiorum eloquentiam
								cum cu, sit summo dolor essent te. Ne quodsi nusquam legendos
								has, ea dicit voluptua eloquentiam pro, ad sit quas qualisque.
								Eos vocibus deserunt quaestio ei.</p>
							<img id="post_img" src="images/background-1.jpg" align="center">
							<div id="panel">
								<div class="icon_div">
									<a href="#"><img class="face_icon" src="images/like.png"
										align="left" alt="Alt text">Likes</a>
								</div>
								<div class="icon_div">
									<a href="#"><img class="face_icon" src="images/Comment.png"
										align="left">Comment</a>
								</div>
								<div class="icon_div">
									<a href="#"><img class="face_icon" src="images/share.png"
										align="left">Share</a>
								</div>
							</div>
						</div>
						<p>
							</br>&nbsp;</br>
						</p>
					</li>
					<li class="comment">
						<div id="post_content2">
							<div id="image_space">
								<a href="#"><img id="prof_pic_post" src="images/default.png"
									align="left"> </img></a>
								<p id="post_info">
									<a href="#">User Name Here</a> </br> Time Here!
								</p>
							</div>
							<p id="post_text">Ius id vidit volumus mandamus, vide veritus
								democritum te nec, ei eos debet libris consulatu. No mei ferri
								graeco dicunt, ad cum veri accommodare. Sed at malis omnesque
								delicata, usu et iusto zzril meliore. Dicunt maiorum eloquentiam
								cum cu, sit summo dolor essent te. Ne quodsi nusquam legendos
								has, ea dicit voluptua eloquentiam pro, ad sit quas qualisque.
								Eos vocibus deserunt quaestio ei.</p>
							<div id="panel">
								<div class="icon_div">
									<a href="#"><img class="face_icon" src="images/like.png"
										align="left" alt="Alt text">Likes</a>
								</div>
								<div class="icon_div">
									<a href="#"><img class="face_icon" src="images/Comment.png"
										align="left">Comment</a>
								</div>
								<div class="icon_div">
									<a href="#"><img class="face_icon" src="images/share.png"
										align="left">Share</a>
								</div>
							</div>
						</div>
						<p>
							</br>&nbsp;</br>
						</p>
					</li>
				</ul>
			</div>
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