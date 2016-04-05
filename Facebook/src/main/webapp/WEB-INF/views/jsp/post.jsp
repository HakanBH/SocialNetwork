<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div id="new_post">
	<div id="post_content">
		<div id="image_space">
			<a href="#"><img id="prof_pic_post" src=${currentUser.firstName }
				align="left"> </a>
			<p id="post_info">
				<a href="#">${currentUser.firstName} ${currentUser.lastName}</a> <br>
				${post.created}
			</p>
		</div>
		<p id="post_text">${post.text}</p>
		<img id="post_img" src="images/image.png" align="middle">
		<div class="row">
			<div class="col-md-offset-1 col-md-8">
				<div class="icon_div">
					<a href="#"><span class="glyphicon glyphicon-thumbs-up"></span>
						Likes</a>
				</div>
				<div class="icon_div">
					<a href="#"><span class="glyphicon glyphicon-comment"></span>
						Comment</a>
				</div>
				<div class="icon_div">
					<a href="#"><span class="glyphicon glyphicon-share"></span>
						Share</a>
				</div>
			</div>
		</div>
		<div id="input-group">
			<img id="prof_pic_post" src="images/default.png" align="left">
			<input class="form-comment" placeholder="Add a comment" type="text">
		</div>
	</div>

	<ul class="comments-list">
		<li class="comment">
			<div id="post_content2">
				<div id="image_space">
					<a href="#"><img id="prof_pic_post" src="images/default.png"
						align="left"> </a>
					<p id="post_info">
						<a href="#">User Name Here</a> Time Here!
					</p>
				</div>
				<p id="post_text">Ius id vidit volumus mandamus, vide veritus
					democritum te nec, ei eos debet libris consulatu. No mei ferri
					graeco dicunt, ad cum veri accommodare. Sed at malis omnesque
					delicata, usu et iusto zzril meliore. Dicunt maiorum eloquentiam
					cum cu, sit summo dolor essent te. Ne quodsi nusquam legendos has,
					ea dicit voluptua eloquentiam pro, ad sit quas qualisque. Eos
					vocibus deserunt quaestio ei.</p>
				<img id="post_img" src="images/background-1.jpg" align="middle">
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
				<br>&nbsp;<br>
			</p>
		</li>
		<li class="comment">
			<div id="post_content2">
				<div id="image_space">
					<a href="#"><img id="prof_pic_post" src="images/default.png"
						align="left"> </a>
					<p id="post_info">
						<a href="#">User Name Here</a> <br> Time Here!
					</p>
				</div>
				<p id="post_text">Ius id vidit volumus mandamus, vide veritus
					democritum te nec, ei eos debet libris consulatu. No mei ferri
					graeco dicunt, ad cum veri accommodare. Sed at malis omnesque
					delicata, usu et iusto zzril meliore. Dicunt maiorum eloquentiam
					cum cu, sit summo dolor essent te. Ne quodsi nusquam legendos has,
					ea dicit voluptua eloquentiam pro, ad sit quas qualisque. Eos
					vocibus deserunt quaestio ei.</p>
			</div>
			<p>
				<br>&nbsp;<br>
			</p>
		</li>
	</ul>
</div>
