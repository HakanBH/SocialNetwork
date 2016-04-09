package com.facebook.controllers.usersAndFriends;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/friends")
public class Friends {
	@RequestMapping(method=RequestMethod.GET)
	public String mainController(HttpServletRequest request){
		return "friends";
	}
}