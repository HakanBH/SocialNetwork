package com.facebook.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.facebook.DAO.IPostDAO;
import com.facebook.DAO.IUserDAO;
import com.facebook.POJO.Comment;
import com.facebook.POJO.Post;
import com.facebook.POJO.User;

@Controller
public class PostController {

	@RequestMapping(value = "/commentPost", method = RequestMethod.POST)
	public String commentPost(HttpServletRequest request) {
		User currentUser = (User) request.getSession().getAttribute("currentUser");
		String commentedPostId = (String) request.getParameter("commentedPost");
		int id = Integer.parseInt(commentedPostId);

		String commentText = request.getParameter("commentText");

		Post commentedPost = IPostDAO.getPostDAO().getPostById(id);
		Comment comment = new Comment(currentUser, commentedPost, commentText);

		commentedPost.addComment(comment);
		currentUser.addComment(comment);
		IPostDAO.getPostDAO().commentPost(commentedPost, currentUser, comment);
			System.err.println(commentText);
		return "redirect:/main";
	}
}
