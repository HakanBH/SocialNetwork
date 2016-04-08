package com.facebook.controllers.usersAndFriends;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.facebook.DAO.IUserDAO;
import com.facebook.POJO.User;

@Controller
@RequestMapping("/friends")
public class Friends {
	@RequestMapping(method=RequestMethod.GET)
	public String mainController(HttpServletRequest request){
			User currentUser = (User) request.getSession().getAttribute("currentUser");
		return "friends";
	}
	
	@RequestMapping(value="/removeFriend", method = RequestMethod.GET)
	public String removeFriend(HttpServletRequest request){
		String userToremoveId = request.getParameter("userToRemove");
		int id = Integer.parseInt(userToremoveId);
		
		User userToRemove = IUserDAO.getUserDAO().getUserById(id);
		User currentUser = (User) request.getSession().getAttribute("currentUser");
		
		IUserDAO.getUserDAO().removeFriend(currentUser, userToRemove);
		
		System.err.println(currentUser);
		System.err.println(userToRemove);
		return "redirect:/friends";
	}
}