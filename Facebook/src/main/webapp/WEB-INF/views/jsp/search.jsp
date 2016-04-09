<%@ page language="java" contentType="text/html; UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/post.css">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/customStyle.css">
<link rel="stylesheet" href="css/imageUpload.css">

<title>Search results for " "</title>
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
			<div class="panel panel-white panel-shadow">
				<div class="panel-heading">
					<h2>Search results:</h2>
				</div>

				<c:choose>
					<c:when test="${not empty searchResults}">
						<c:forEach var="user" items="${searchResults}">
							<div class="panel-body">
								<div class="search-result" style="height: 140px">
									<div style="padding-left: 7px; padding-top: 5px">
										<img id="prof_pici" src="${user.profilePath}">
									</div>
									<div style="padding-left: 140px;">
										<h3>${user.firstName} ${user.lastName}</h3>
										<p>${user.userInfo.city},
											${user.userInfo.relationshipStatus }</p>
									</div>
									<div style="position: relative">
										<form action="main/addFriend" method="GET">
											<input name="userToAdd" type="hidden" value="4"> <input
												type="submit" style="position: absolute; margin-left: 260px"
												class="btn btn-primary" value="Follow">
										</form>
									</div>
								</div>
							</div>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<div class="panel-body">
							<h2>No results found for {}</h2>
						</div>
					</c:otherwise>
				</c:choose>
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
	<script src="js/imageUpload.js"></script>
</body>
</html>