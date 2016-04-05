package com.facebook.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.facebook.POJO.UserInfo;

@Controller
@RequestMapping(value="/extraInfo")
public class ExtraInfoPage {
	@RequestMapping(method = RequestMethod.GET)		
	public String getMethod(Model model) {
		UserInfo userInfo = new UserInfo();

		model.addAttribute("userInfo", userInfo);
		return "extraInfo";
	}
	
	@RequestMapping(method = RequestMethod.POST)		
	public String postMethod(Model model) {
		UserInfo userInfo = new UserInfo();

		model.addAttribute("userInfo", userInfo);
		return "extraInfo";
	}
}
