package com.facebook.controllers.posts;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.facebook.DAO.IPostDAO;
import com.facebook.DAO.SessionDispatcher;
import com.facebook.POJO.Post;
import com.facebook.POJO.User;

@Controller
public class LikeController {
	@RequestMapping(value = "/likePost", method = RequestMethod.POST)
	public String likePost(HttpServletRequest request) {
		User currentUser = (User) request.getSession().getAttribute("currentUser");
		String likedPostId = (String) request.getParameter("likedPost");
		int id = Integer.parseInt(likedPostId);

		Post likedPost = IPostDAO.getPostDAO().getPostById(id);

		for (Post p : currentUser.getPosts()) {
			if (p.getId() == likedPost.getId()) {
				p.addLike(currentUser);
				currentUser.likePost(p);
				IPostDAO.getPostDAO().likePost(likedPost, currentUser);
			}
		}

		return "redirect:/main";
	}

}
