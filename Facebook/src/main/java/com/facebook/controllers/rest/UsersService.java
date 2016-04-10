package com.facebook.controllers.REST;

import java.util.List;
import java.util.Set;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.facebook.DAO.IUserDAO;
import com.facebook.POJO.Post;
import com.facebook.POJO.User;

@RestController
public class UsersService {
	@RequestMapping(value = "/allUsers/{id}", method = RequestMethod.GET)
	User getUser(@PathVariable("id") Integer userId) {
		return IUserDAO.getUserDAO().getUserById(userId);
	}
	
	@RequestMapping(value = "/allUsers", method = RequestMethod.GET)
	List<User> getUsers() {
		return IUserDAO.getUserDAO().getAllUsers();
	}

	@RequestMapping(value = "/allFriends/{id}", method = RequestMethod.GET)
	Set<User> getFriends(@PathVariable("id") Integer userId) {
		User u = IUserDAO.getUserDAO().getUserById(userId);
		return u.getFriends();
	}
	
	@RequestMapping(value = "/allPosts/{id}", method = RequestMethod.GET)
	Set<Post> getPosts(@PathVariable("id") Integer userId) {
		User u = IUserDAO.getUserDAO().getUserById(userId);
		return u.getOwnedPosts();
	}
}
