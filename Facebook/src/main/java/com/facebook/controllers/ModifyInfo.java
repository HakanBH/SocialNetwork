package com.facebook.controllers;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.facebook.POJO.UserInfo;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.facebook.DAO.IUserDAO;
import com.facebook.POJO.User;

@Controller
@RequestMapping(value = "/modifyInfo")
public class ModifyInfo{
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(
	            dateFormat, false));
	}
	@RequestMapping(method = RequestMethod.POST)
	public String uploadInfo(HttpServletRequest request, @ModelAttribute("modifyInfo") 
			UserInfo userInfo){
		
		User user = (User) request.getSession().getAttribute("currentUser");
		IUserDAO.getUserDAO().updateUserInfo(user, userInfo);	
		user.setUserInfo(userInfo);	

		request.getSession().setAttribute("currentUser", user);
		
		return "redirect:/settings";
	}
}
