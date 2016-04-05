<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Asocialen.com</title>
<link rel="stylesheet" href="css/customStyle.css">
</head>
<body>
<div id="first_right">

				<div id="image_space">
					<a href="#"><img id="know" src="images/know.png" align="left">
					</a>
				</div>
				<div id="left_name">
					<p>
						<a class="name_left" href="#">&nbsp;People you might know</a>
					</p>

					<c:forEach var="suggestion" items="${friendSuggestions}">
						<div class="whoToAdd">
							<div id="profpicknow">
								<a href=""> <img id="profpicture60"
									src="${suggestion.profilePath}"
									align="right">
								</a>
							</div>
							<a href="" id="nickname_info1"><b>
									${suggestion.firstName} ${suggestion.lastName} </b></a>
							<form action="./Follow" method="post">
								<input type="hidden" value="" name="following"> <input
									type="hidden" value="./home.jsp" name="link2page">
								<button id="post_button2" type="submit">Follow</button>
							</form>
						</div>
					</c:forEach>
				</div>
			</div>
</body>
</html>