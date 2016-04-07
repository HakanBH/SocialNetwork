package com.facebook.controllers;

import javax.servlet.http.HttpServletRequest; 

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.facebook.DAO.IUserDAO;
import com.facebook.POJO.User;
import com.facebook.POJO.UserLogin;

@Controller
@RequestMapping(value="/login")
public class LoginController {
	@RequestMapping(method = RequestMethod.POST)
	public String login(Model model, @ModelAttribute("userLogin") UserLogin userLogin, HttpServletRequest request) {
		try {
			User user = IUserDAO.getUserDAO().login(userLogin.getEmail(), userLogin.getPassword());
			if (user != null) {
				request.getSession().setAttribute("currentUser", user);
				return "redirect:/main";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("loginError", "Wrong email or password.");
		return "forward:/index";
	}
}
