<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="css/style.css">

<c:choose>
	<c:when test="${not empty sessionScope.currentUser}">
		<div style="margin-bottom: 100px">
			<header id="fh5co-header" role="banner">
				<nav class="navbar navbar-default" role="navigation">
					<div class="container-fluid" style="font-size: 15px !important">
						<div class="navbar-header">
							<!-- Mobile Toggle Menu Button -->
							<a href="/index" class="js-fh5co-nav-toggle fh5co-nav-toggle"
								data-toggle="collapse" data-target="#navbar"
								aria-expanded="false" aria-controls="navbar"> <i> </i>
							</a> <a class="navbar-brand" href="./main"
								style="font-size: 20px !important"> Asocialen.com </a>
						</div>
						<div id="navbar" class="navbar-collapse collapse">
							<ul class="nav navbar-nav navbar-right">
								<li>
									<a href="/profile">
										<c:choose>
											<c:when test="${currentUser.profilePicture.name == './images/default-pic.png'}">
												<img id="usr_pic_small" src="./images/default-pic.png"> 	
											</c:when>
											<c:otherwise>
												<img id="usr_pic_small" src="${currentUser.profilePath}"
													align="left">
											</c:otherwise>
										</c:choose>
									</a>
								</li>
								
								
								
								<li class="active"><a href="./main"><span>
											Home <span class="border"></span>
									</span></a></li>
								<li><a href="./profile"><span> Profile <span
											class="border"></span></span></a></li>
								<li><a href="./album"><span> Albums <span
											class="border"></span></span></a></li>

								<li class="dropdown"><a href="#" class="dropdown-toggle"
									data-toggle="dropdown"><span> Settings <span
											class="border"></span></span></a>
									<ul class="dropdown-menu">
										<li><a href="#">Settings</a></li>
										<li><a href="./logout">Log Out</a></li>
									</ul></li>
							</ul>
						</div>
					</div>
				</nav>
			</header>
		</div>
	</c:when>

	<c:otherwise>
		<div style="margin-top: 100px">
			<header id="fh5co-header" role="banner">
				<nav class="navbar navbar-default" role="navigation">
					<div class="container-fluid" style="font-size: 15px !important">
						<div class="navbar-header">
							<!-- Mobile Toggle Menu Button -->
							<a href="#" class="js-fh5co-nav-toggle fh5co-nav-toggle"
								data-toggle="collapse" data-target="#navbar"
								aria-expanded="false" aria-controls="navbar"> <i> </i>
							</a> <a class="navbar-brand" href="./index"> Facebook.com </a>
						</div>

						<div id="navbar" class="navbar-collapse collapse">
							<ul class="nav navbar-nav navbar-right">
								<li class="active"><a href="index.jsp"><span>
											Home <span class="border"></span>
									</span></a></li>
								<li><a href="#"><span> About <span
											class="border"></span></span></a></li>
								<li><a href="#"><span> Help <span class="border"></span></span></a></li>
							</ul>
						</div>
					</div>
				</nav>
			</header>
		</div>
	</c:otherwise>
</c:choose>


