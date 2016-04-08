package com.facebook.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.facebook.POJO.User;
import com.facebook.POJO.UserLogin;

@Controller
@RequestMapping(value="/index")
public class IndexPage {
	@RequestMapping(method = RequestMethod.GET)		
	public String getMethod(Model model, HttpServletRequest request) {
		if(request.getSession().getAttribute("currentUser") != null){
			return "redirect:/main";
		}
		
		User user = new User();
		UserLogin userLogin = new UserLogin();
	
		model.addAttribute("user", user);
		model.addAttribute("userLogin", userLogin);
		return "index";
	}
	
	@RequestMapping(method = RequestMethod.POST)		
	public String postMethod(Model model) {
		User user = new User();
		UserLogin userLogin = new UserLogin();

		model.addAttribute("user", user);
		model.addAttribute("userLogin", userLogin);
		return "index";
	}
}
