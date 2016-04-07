package com.facebook.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.facebook.DAO.IUserDAO;
import com.facebook.POJO.User;
@Controller

public class ExtProfile {
	@RequestMapping(value="/extProfile/{id}", method=RequestMethod.GET)
	public String mainController(@PathVariable(value="id") Integer id, HttpServletRequest request){
		System.err.println(id);
		User extUser = (User)IUserDAO.getUserDAO().getUserById(id);
		request.getSession().setAttribute("extUser", extUser);
		
		return "redirect:/extProfile";
	}
	
	@RequestMapping(value="/extProfile", method=RequestMethod.GET)
	public String cont(HttpServletRequest request){
		User extUser = (User) request.getSession().getAttribute("extUser");
		System.err.println(extUser);
		return "/extProfile";
	}
}
