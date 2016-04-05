<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ page errorPage="error.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <link href='http://fonts.googleapis.com/css?family=Roboto:400,300,100,500' rel='stylesheet' type='text/css'>
      <link href='https://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
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
               <a href="#"><img id="prof_pic_post" src="images/pic.png" align="left" > </a>
			    </div>
				<h1 class="text_title">ALBUMS</h1>
	  </div>
	  
	  <div class="pic_container">
	  <div class="polaroid" align="left">
	  <a href="./pictures" style="text-decoration:none; color:black;">
	<img class="album" src="images/backgrounds/background-1.jpg" alt="Norway">
	
	<div class="desc">
	
		<p style="text-decoration:none;">The Troll's tongue in Hardanger, Norway</p>
	</div>
	</a>
	</div>
	
	 <div class="polaroid" align="left">
	  <a href="#" style="text-decoration:none; color:black;">
	<img class="album" src="images/backgrounds/background-1.jpg" alt="Norway">
	
	<div class="desc">
	
		<p style="text-decoration:none;">The Troll's tongue in Hardanger, Norway</p>
	</div>
	</a>
	</div>
	
	 <div class="polaroid" align="left">
	  <a href="#" style="text-decoration:none; color:black;">
	<img class="album" src="images/backgrounds/background-1.jpg" alt="Norway">
	
	<div class="desc">
	
		<p style="text-decoration:none;">The Troll's tongue in Hardanger, Norway</p>
	</div>
	</a>
	</div>
	
	 <div class="polaroid" align="left">
	  <a href="#" style="text-decoration:none; color:black;">
	<img class="album" src="images/backgrounds/background-1.jpg" alt="Norway">
	
	<div class="desc">
	
		<p style="text-decoration:none;">The Troll's tongue in Hardanger, Norway</p>
	</div>
	</a>
	</div>
	
	 <div class="polaroid" align="left">
	  <a href="#" style="text-decoration:none; color:black;">
	<img class="album" src="images/backgrounds/background-1.jpg" alt="Norway">
	
	<div class="desc">
	
		<p style="text-decoration:none;">The Troll's tongue in Hardanger, Norway</p>
	</div>
	</a>
	</div>
	
	 <div class="polaroid" align="left">
	  <a href="#" style="text-decoration:none; color:black;">
	<img class="album" src="images/backgrounds/background-1.jpg" alt="Norway">
	
	<div class="desc">
	
		<p style="text-decoration:none;">The Troll's tongue in Hardanger, Norway</p>
	</div>
	</a>
	</div>
	
	 <div class="polaroid" align="left">
	  <a href="#" style="text-decoration:none; color:black;">
	<img class="album" src="images/backgrounds/background-1.jpg" alt="Norway">
	
	<div class="desc">
	
		<p style="text-decoration:none;">The Troll's tongue in Hardanger, Norway</p>
	</div>
	</a>
	</div>
	
	 <div class="polaroid" align="left">
	  <a href="#" style="text-decoration:none; color:black;">
	<img class="album" src="images/backgrounds/background-1.jpg" alt="Norway">
	
	<div class="desc">
	
		<p style="text-decoration:none;">The Troll's tongue in Hardanger, Norway</p>
	</div>
	</a>
	</div>
	  
</div>

<div id="new_album" style="height:130px;"> 

<form class="upload_form" method="post" action="./NewAlbum" name="albumName">
<h3 style="font-weight:bold;">Create a new album</h3>
  <input id="country" type="text" name="newName" placeholder="Album Name">
 <button id="post_button2" type="submit">Create!</button>
</form>
</div>
						</div>
     
	
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
      <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
      <script	src="http://jqueryvalidation.org/files/dist/jquery.validate.js"></script>
      <script src="js/validation.js"></script>
      <script src="js/bg-changer.js"></script>
   </body>
</html>