package com.facebook.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.facebook.DAO.IUserDAO;
import com.facebook.POJO.User;

@Controller
@RequestMapping(value = "/register")
public class RegistrationController {
	@RequestMapping(method = RequestMethod.POST)
	public String registerUser(Model model, @ModelAttribute("user") User user, HttpServletRequest request) {
		try {	
			if (!IUserDAO.getUserDAO().isEmailTaken(user.getEmail())) {
				User registered = new User(user.getEmail(), user.getPassword(), user.getFirstName(),
						user.getLastName());
				IUserDAO.getUserDAO().insertUser(registered);
				return "extraInfo";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("regError", "An account with such email already exists.");
		return "forward:/index";
	}
}
