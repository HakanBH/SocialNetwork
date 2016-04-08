package com.facebook.controllers.usersAndFriends;

import static com.facebook.controllers.MainPage.prepareSuggestions;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.facebook.DAO.IUserDAO;
import com.facebook.POJO.User;
import com.facebook.POJO.UserInfo;
import com.facebook.controllers.MainPage;
@Controller

public class ExtProfile {
	@RequestMapping(value="/extProfile/{id}", method=RequestMethod.GET)
	public String mainController(Model model, @PathVariable(value="id") Integer id, HttpServletRequest request){
		System.err.println(id);
		User extUser = (User)IUserDAO.getUserDAO().getUserById(id);
		request.getSession().setAttribute("extUser", extUser);
		ProfileController.preparePics(model, extUser);
		
		return "redirect:/extProfile";
	}
	
	@RequestMapping(value="/extProfile", method=RequestMethod.GET)
	public String cont(Model model, HttpServletRequest request){
		User currentUser = (User) request.getSession().getAttribute("currentUser");
		User extUser = (User) request.getSession().getAttribute("extUser");
		UserInfo userInfo = extUser.getUserInfo();
		request.getSession().setAttribute("userInfo", userInfo);
		prepareFriends(model, extUser);
		MainPage.prepareSuggestions(model, currentUser);
		ProfileController.preparePics(model,extUser);
		return "/extProfile";
	}
	
	public static void prepareFriends(Model model, User currentUser){
		
		Set<User> friends = (Set<User>) currentUser.getFriends() ;
			model.addAttribute("friends", friends);
		
	}
}