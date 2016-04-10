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

		String currentPage = request.getHeader("referer");
		currentPage = currentPage.substring(currentPage.lastIndexOf("/"));

		if (currentPage.contains("extProfile")) {
			User extUser = likedPost.getOwner();
			
			for (Post p : extUser.getOwnedPosts()) {
				System.err.println(p);
				if (p.getId() == id) {
					p.addLike(currentUser);
					currentUser.likePost(p);
					IPostDAO.getPostDAO().likePost(likedPost, currentUser);
				}
			}
			return "redirect:" + currentPage;

		} else {
			for (Post p : currentUser.getPosts()) {
				if (p.getId() == likedPost.getId()) {
					p.addLike(currentUser);
					currentUser.likePost(p);
					IPostDAO.getPostDAO().likePost(likedPost, currentUser);
				}
			}
			return "redirect:" + currentPage;
		}

	}

}
