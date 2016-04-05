package com.facebook.controllers;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.facebook.DAO.IUserDAO;
import com.facebook.POJO.Post;
import com.facebook.POJO.User;

@Transactional
@Controller
@RequestMapping("/main")
public class MainPage {
	@RequestMapping(method = RequestMethod.GET)
	@Transactional
	public String mainController(Model model, HttpServletRequest request) {
		User currentUser = (User) request.getSession().getAttribute("currentUser");
		
		if(currentUser.getFriends().isEmpty()){
			List<User> allUsers = IUserDAO.getUserDAO().getAllUsers();
			Collections.shuffle(allUsers);
			model.addAttribute("friendSuggestions", allUsers.subList(0, 4));
		} else{
			List<User> friendsOfFriends = currentUser.getFriendsOfFriends();
			model.addAttribute("friendSuggestions", friendsOfFriends);
		}

		Collection<Post> posts = currentUser.getPosts();
		System.out.println(posts);
		if(!posts.isEmpty()){
			model.addAttribute("posts",posts);
		}
		return "main";
	}
}
