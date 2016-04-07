package com.facebook.controllers;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.facebook.POJO.User;
import com.facebook.POJO.UserInfo;

@Controller
@RequestMapping("/settings")
public class Settings {
	@RequestMapping(method = RequestMethod.GET)
	public String getMethod(Model model, HttpServletRequest request) {
		User user = (User) (request.getSession().getAttribute("currentUser"));

		UserInfo userInfo = user.getUserInfo();

		model.addAttribute("userInfo", userInfo);
		return "settings";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String postMethod(Model model, HttpServletRequest request) {
		User user = (User) (request.getSession().getAttribute("currentUser"));

		UserInfo userInfo = user.getUserInfo();

		model.addAttribute("userInfo", userInfo);

		return "redirect:/settings";
	}
}
