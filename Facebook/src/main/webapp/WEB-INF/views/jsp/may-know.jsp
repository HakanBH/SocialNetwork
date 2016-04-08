<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div class="panel panel-white panel-shadow">
	<div class="panel-heading">
		<div id="image_space">
			<a href="#"><img id="know" src="images/know.png" align="left">
			</a>
		</div>

		<div id="left_name">
			<p>
				<a class="name_left" href="#">&nbsp;People you might know</a>
			</p>
		</div>
	</div>
	<div class="panel-body">
		<c:forEach var="suggestion" items="${friendSuggestions}">
			<div class="whoToAdd">
				<div id="profpicknow">
					<a href="extProfile/${suggestion.id}"> <img id="profpicture60"
						src="${suggestion.profilePath}" align="right">
					</a>
				</div>
				<a href="" id="nickname_info1"><b> ${suggestion.firstName}
						${suggestion.lastName} </b></a>
				<form action="main/addFriend" method="GET">
					<input name="userToAdd" type="hidden" value="${suggestion.id}"> 
					<input type="submit" id="post_button2" value="Follow">
				</form>
			</div>
		</c:forEach>
	</div>
</div>
