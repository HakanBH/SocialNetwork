package com.facebook.controllers.usersAndFriends;

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
@RequestMapping(value = "/uploadInfo")
public class ExtraInfo {

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(
	            dateFormat, false));
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String uploadInfo(HttpServletRequest request, @ModelAttribute("userInfo") 
			UserInfo userInfo){
		User user = (User) request.getSession().getAttribute("currentUser");
		user.setUserInfo(userInfo);
		IUserDAO.getUserDAO().updateUserInfo(user, userInfo);	
		return "redirect:/main";
	}
}
