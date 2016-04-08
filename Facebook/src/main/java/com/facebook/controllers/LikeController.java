package com.facebook.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.facebook.DAO.IPostDAO;
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
		likedPost.addLike(currentUser);
		currentUser.likePost(likedPost);

		IPostDAO.getPostDAO().likePost(likedPost, currentUser);
		
		return "redirect:/main";
	}
}
