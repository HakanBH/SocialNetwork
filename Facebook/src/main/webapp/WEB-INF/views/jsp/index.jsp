<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>    
<%@ page errorPage="error.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href='http://fonts.googleapis.com/css?family=Roboto:400,300,100,500' rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="css/bootstrap.css">
	<spring:message code="label.welcome" var="welcome" />
	<spring:message code="label.welcomeMessage" var="welcomeMessage" />
	
<title>Asocialen.com</title>

</head>
<body>
	
	<jsp:include page="navbar.jsp"></jsp:include>	
	<div id="wrap">
		<img class="bgfade"	src="images/backgrounds/background-2.jpg">
		<img class="bgfade"	src="images/backgrounds/background-1.jpg">
		<img class="bgfade"	src="images/backgrounds/background-3.jpg">		
		<img class="bgfade"	src="images/backgrounds/background-4.jpg">
		<img class="bgfade"	src="images/backgrounds/background-5.jpg">
	</div>
	
	<div class="container" style="margin-top: 150px">
		<div class="row">
			<div class="col-md-offset-1 col-md-5" style="margin-top:50px">			
				<h1 class="main-font" style="font-size:35px"> <spring:message code="label.welcome"></spring:message> </h1>
				<h3 class="main-font" style="font-size:20px"> <spring:message code="label.welcomeMessage"></spring:message></h3>
			</div>
			<div class="col-md-offset-1 col-md-4" >
				<div class="panel panel-login">
					<div class="panel-heading">
						<div class="row">
							<div class="col-xs-6">
								<a href="#" class="active" id="login-form-link"><spring:message code="label.login"></spring:message></a>
							</div>
							<div class="col-xs-6">
								<a href="#" id="register-form-link"><spring:message code="label.register"></spring:message></a>
							</div>
						</div>
						<hr>
					</div>
					
					<div class="panel-body">
						<div class="row">
							<div class="col-lg-12">
	 							<jsp:include page="registerForm.jsp"></jsp:include>		
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<div class="footer">Copyright &copy; 2016. All rights reserved.</div>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
	<script	src="http://jqueryvalidation.org/files/dist/jquery.validate.js"></script>
	<script src="js/validation.js"></script>
	<script src="js/bg-changer.js"></script>
	
</body>
</html>