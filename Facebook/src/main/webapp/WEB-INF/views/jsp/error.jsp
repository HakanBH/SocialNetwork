<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isErrorPage="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Error page</title>
<link
	href="<c:url value="http://fonts.googleapis.com/css?family=Roboto:400,300,100,500" />"
	rel="stylesheet">
<link
	href="<c:url value="https://fonts.googleapis.com/css?family=Montserrat:400,700" />"
	rel="stylesheet">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/bootstrap.css">

</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	<div class="container" style="margin-top: 100px">
		<div class="col-md-2" style="margin-top: 20px">
			<span class="glyphicon glyphicon-remove-circle"
				style="font-size: 90px; color: red	"> </span>
		</div>
		<div class="col-md-10">
			<h1>
				Sorry. We are experiencing some trouble right now. Please try again in a few minutes.
			</h1>
		</div>

		<div class="row">
			<div class="col-md-6">
				<h1>
					<a href="./index"> Return to main page. </a>
				</h1>
			</div>
		</div>
	</div>
</body>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
<script src="http://jqueryvalidation.org/files/dist/jquery.validate.js"></script>
<script src="./js/validation.js"></script>
<script src="./js/bg-changer.js"></script>

</html>
