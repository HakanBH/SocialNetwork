package com.facebook.controllers.REST;

import java.util.Set;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.facebook.DAO.IPostDAO;
import com.facebook.POJO.Post;
import com.facebook.POJO.User;

@RestController
public class PostServices {
	IPostDAO postDAO = IPostDAO.getPostDAO();

	@RequestMapping(value = "/getPost/{id}")
	Post getPost(@PathVariable("id") Integer postId) {
		return postDAO.getPostById(postId);
	}
	
	@RequestMapping(value = "/postLikers/{id}", method = RequestMethod.GET)
	Set<User> getPostLikes(@PathVariable("id") Integer postId) {	
		Post p = postDAO.getPostById(postId);
		return p.getLikes();
	}
	
	@RequestMapping(value = "/postShares/{id}", method = RequestMethod.GET)
	Set<User> getPostShares(@PathVariable("id") Integer postId) {	
		Post p = postDAO.getPostById(postId);
		return p.getShares();
	}
}
