<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page errorPage="error.jsp"%>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/searchBar.css">
<link
	href='http://fonts.googleapis.com/css?family=Roboto:400,300,100,500'
	rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Montserrat:400,700'
	rel='stylesheet' type='text/css'>

<c:choose>
	<c:when test="${not empty sessionScope.currentUser}">
		<div style="margin-bottom: 110px">
			<header id="fh5co-header" role="banner">
				<nav class="navbar navbar-default navbar-fixed-top"
					role="navigation">
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
								<li style="margin-top: 0.05cm; margin-right: 20px">
								<div id=searchbox>
			<form method="post" action="./searchUsers" id="search" align="right"
				style="">
				<input name="searchWord" type="text" size="40"
					placeholder="Search user..." />
			</form>
		</div>
<!-- 									<div class="search"> -->
<!-- 										<form action="./searchUsers" method="post"> -->
<!-- 											<input type="text" class="form-control input-sm" name="searchText" -->
<!-- 												maxlength="24" placeholder="Search" /> -->
<!-- 											<button type="submit" class="btn btn-search btn-primary btn-sm">Search</button> -->
<!-- 										</form> -->
<!-- 									</div> -->
								</li>
								<li><a href="./profile"> <img id="usr_pic_small"
										src="${currentUser.profilePath}" align="left">

								</a></li>

								<c:set var="uri" value="${pageContext.request.requestURI}" />

								<li
									<c:if test="${fn:contains(uri, 'main')}">class="active"</c:if>><a
									href="./main"><span> Home <span class="border"></span>
									</span></a></li>
								<li
									<c:if test="${fn:contains(uri, 'profile')}">class="active"</c:if>><a
									href="./profile"><span> Profile <span class="border"></span></span></a></li>
								<li
									<c:if test="${fn:contains(uri, 'album')}">class="active"</c:if>><a
									href="./album"><span> Albums <span class="border"></span></span></a></li>

								<li class="dropdown"><a href="#" class="dropdown-toggle"
									data-toggle="dropdown"><span> Settings <span
											class="border"></span></span></a>
									<ul class="dropdown-menu">
										<li><a href="./settings">Settings</a></li>
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
							</a> <a class="navbar-brand" href="./index"> Asocialen.com </a>
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


