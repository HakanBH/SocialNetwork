<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ page errorPage="error.jsp" %>
<!DOCTYPE html>
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <link href='http://fonts.googleapis.com/css?family=Roboto:400,300,100,500' rel='stylesheet' type='text/css'>
      <link href='https://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
      	  <link rel="stylesheet" href="css/post.css">
      	  <link href="css/lightbox.css" rel="stylesheet">
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
               <a href="#"><img id="prof_pic_post" src="images/pic.png" align="left" > </a>
			    </div>
				<h1 class="text_title">MY ALBUM TITLE</h1>
	  </div>
	  <div class="pic_container2">
	  
		<div class="responsive">
  <div class="img">
    <a href="images/backgrounds/background-1.jpg" data-lightbox="album"  style="text-decoration:none; color:black;">
      <img class="album_pic" src="images/backgrounds/background-1.jpg" alt="Trolltunga Norway" width="300" height="200">
    <div class="desc"> Title a very very very very very very long title + number of likes 0<a href="#"><span class="glyphicon glyphicon-thumbs-up"> </span></a></div>
	</a>
  </div>
</div>
	  
	  			  
			<div class="responsive">
  <div class="img">
    <a href="images/backgrounds/background-1.jpg" data-lightbox="album"  style="text-decoration:none; color:black;">
      <img class="album_pic" src="images/backgrounds/background-1.jpg" alt="Trolltunga Norway" width="300" height="200">
    <div class="desc"> Title a very very very very very very long title + number of likes 0<a href="#"><img class="face_icon" src="images/like.png" align="right" alt="Alt text"></a></div>
	</a>
  </div>
</div>
	 	  
	  			  
			<div class="responsive">
  <div class="img">
    <a href="images/backgrounds/background-1.jpg" data-lightbox="album"  style="text-decoration:none; color:black;">
      <img class="album_pic" src="images/backgrounds/background-1.jpg" alt="Trolltunga Norway" width="300" height="200">
    <div class="desc"> Title a very very very very very very long title + number of likes 0<a href="#"><img class="face_icon" src="images/like.png" align="right" alt="Alt text"></a></div>
	</a>
  </div>
</div>
	  	  
	  			  
			<div class="responsive">
  <div class="img">
    <a href="images/backgrounds/background-1.jpg" data-lightbox="album"  style="text-decoration:none; color:black;">
      <img class="album_pic" src="images/backgrounds/background-1.jpg" alt="Trolltunga Norway" width="300" height="200">
    <div class="desc"> Title a very very very very very very long title + number of likes 0<a href="#"><img class="face_icon" src="images/like.png" align="right" alt="Alt text"></a></div>
	</a>
  </div>
</div>
	  	  
	  			  
			<div class="responsive">
  <div class="img">
    <a href="images/backgrounds/background-1.jpg" data-lightbox="album"  style="text-decoration:none; color:black;">
      <img class="album_pic" src="images/backgrounds/background-1.jpg" alt="Trolltunga Norway" width="300" height="200">
    <div class="desc"> Title a very very very very very very long title + number of likes 0<a href="#"><img class="face_icon" src="images/like.png" align="right" alt="Alt text"></a></div>
	</a>
  </div>
</div>
	  	  
	  			  
			<div class="responsive">
  <div class="img">
    <a href="images/backgrounds/background-1.jpg" data-lightbox="album"  style="text-decoration:none; color:black;">
      <img class="album_pic" src="images/backgrounds/background-1.jpg" alt="Trolltunga Norway" width="300" height="200">
    <div class="desc"> Title a very very very very very very long title + number of likes 0<a href="#"><img class="face_icon" src="images/like.png" align="right" alt="Alt text"></a></div>
	</a>
  </div>
</div>
	  	  
	  			  
			<div class="responsive">
  <div class="img">
    <a href="images/backgrounds/background-1.jpg" data-lightbox="album"  style="text-decoration:none; color:black;">
      <img class="album_pic" src="images/backgrounds/background-1.jpg" alt="Trolltunga Norway" width="300" height="200">
    <div class="desc"> Title a very very very very very very long title + number of likes 0<a href="#"><img class="face_icon" src="images/like.png" align="right" alt="Alt text"></a></div>
	</a>
  </div>
</div>
	   

</div>

<div id="upload_pic"> 
<form class="upload_form" method="post" action="./FileUpload" name="file" enctype="multipart/form-data">
<h3 style="font-weight:bold;">Upload a new picture</h3>
  <input type="file" name="newPic" accept="image/png, image/jpeg, image/gif">
  <input type="hidden" value="currentAlbum" name="currentAlbum">
 <button id="post_button2" type="submit">Upload!</button>
</form>

<form class="upload_form" method="post" action="./ChangeName" name="albumName" style="margin-top:50px;">
<h3 style="font-weight:bold;">Rename your album</h3>
  <input id="country" type="text" name="newName" value="OldName" placeholder="New Name">
  <input type="hidden" value="currentAlbum" name="currentAlbum">
 <button id="post_button2" type="submit">Rename!</button>
</form>
</div>

<div class="corte"></div>
						</div>
 
	
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
      <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
      <script	src="http://jqueryvalidation.org/files/dist/jquery.validate.js"></script>
      <script src="js/validation.js"></script>
      <script src="js/bg-changer.js"></script>
	  <script src="js/lightbox-plus-jquery.js"></script>
   </body>
</html>