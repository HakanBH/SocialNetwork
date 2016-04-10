package com.facebook.controllers.posts;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.facebook.DAO.IPostDAO;
import com.facebook.POJO.Post;
import com.facebook.POJO.User;

@Controller
public class UnlikeController {
	@RequestMapping(value = "/unlikePost", method = RequestMethod.POST)
	public String unlikePost(HttpServletRequest request) {
		User currentUser = (User) request.getSession().getAttribute("currentUser");
		String unlikedPostId = (String) request.getParameter("unlikedPost");

		int id = Integer.parseInt(unlikedPostId);
		
		String currentPage = request.getHeader("referer");
		currentPage = currentPage.substring(currentPage.lastIndexOf("/"));

		Post unlikedPost = IPostDAO.getPostDAO().getPostById(id);

		for (Post p : currentUser.getPosts()) {
			if (p.getId() == unlikedPost.getId()) {
				p.removeLike(currentUser);
				currentUser.unlikePost(p);
				IPostDAO.getPostDAO().unlikePost(unlikedPost.getId(), currentUser.getId());
			}
		}

		return "redirect:" + currentPage;
	}
}
