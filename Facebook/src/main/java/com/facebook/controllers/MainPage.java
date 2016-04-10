package com.facebook.controllers;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.facebook.DAO.IPostDAO;
import com.facebook.DAO.IUserDAO;
import com.facebook.POJO.Comment;
import com.facebook.POJO.Post;
import com.facebook.POJO.User;

@Controller
@RequestMapping("/main")
public class MainPage {
	@RequestMapping(method = {RequestMethod.GET,RequestMethod.POST})
	public String mainController(Model model, HttpServletRequest request) {
		User currentUser = (User) request.getSession().getAttribute("currentUser");
		
		prepareSuggestions(model, currentUser);
		
		Collection<Post> posts = currentUser.getPosts();
		if(!posts.isEmpty()){
			model.addAttribute("posts",posts);
		}

		return "main";
	}

	@RequestMapping(value="/addFriend", method = RequestMethod.GET)
	public String addFriend(HttpServletRequest request){
		String userToAddId = request.getParameter("userToAdd");
		int id = Integer.parseInt(userToAddId);
		
		User userToAdd = IUserDAO.getUserDAO().getUserById(id);
		User currentUser = (User) request.getSession().getAttribute("currentUser");
		IUserDAO.getUserDAO().addFriend(currentUser, userToAdd);
		
		
		return "redirect:/main";
	}
	
	
	
	public static void prepareSuggestions(Model model, User currentUser){
		if (currentUser.getFriends().isEmpty() || currentUser.getFriendsOfFriends().size() < User.NUMBER_OF_FRIEND_SUGGESTIONS) {
			List<User> allUsers = IUserDAO.getUserDAO().getAllUsers();
			Collections.shuffle(allUsers);
			//remove current user and his friends from suggestions(removeAll didn't work !?)
			allUsers.remove(currentUser);
			for(User u:currentUser.getFriends()){
				allUsers.remove(u);
			}

			if (allUsers.size() > User.NUMBER_OF_FRIEND_SUGGESTIONS) {
				model.addAttribute("friendSuggestions", allUsers.subList(0, User.NUMBER_OF_FRIEND_SUGGESTIONS));
			} else {
				model.addAttribute("friendSuggestions", allUsers);
			}
		} else {
			List<User> friendsOfFriends = currentUser.getFriendsOfFriends();
			model.addAttribute("friendSuggestions", friendsOfFriends);
		}
	}
}
