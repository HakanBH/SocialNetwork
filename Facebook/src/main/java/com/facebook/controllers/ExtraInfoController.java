package com.facebook.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.facebook.POJO.UserInfo;

@Controller
@RequestMapping("/extraInfo")
public class ExtraInfoController {
	private static final long serialVersionUID = 1L;
	private static final int BUFFER_SIZE = 1024 * 1024;
	
	@RequestMapping(method = RequestMethod.GET)
	public String showRegistrationForm(Model model) {
		UserInfo userInfo = new UserInfo();
		model.addAttribute("userInfo", userInfo);
		return "extraInfo";
	}
}
