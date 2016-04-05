package com.facebook.controllers;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.facebook.DAO.IUserDAO;
import com.facebook.POJO.User;

@Controller
@RequestMapping("/profile")
public class ProfileController {
	@RequestMapping(method = RequestMethod.GET)
	public String mainController(Model model, HttpServletRequest request) {
		User currentUser = (User) request.getSession().getAttribute("currentUser");
		if (currentUser.getFriends().isEmpty()) {
			List<User> allUsers = IUserDAO.getUserDAO().getAllUsers();
			Collections.shuffle(allUsers);
			if (allUsers.size() > 4) {
				model.addAttribute("friendSuggestions", allUsers.subList(0, 4));
			} else {
				model.addAttribute("friendSuggestions", allUsers);
			}
		} else {
			List<User> friendsOfFriends = currentUser.getFriendsOfFriends();
			model.addAttribute("friendSuggestions", friendsOfFriends);
		}
		return "profile";
	}
}