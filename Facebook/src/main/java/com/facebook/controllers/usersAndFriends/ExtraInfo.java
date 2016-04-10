package com.facebook.controllers.usersAndFriends;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
public class ExtraInfo {

	@InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                new SimpleDateFormat("yyyy-MM-dd"), true));
    }
	
	@RequestMapping(value="/extraInfo", method = {RequestMethod.GET ,RequestMethod.POST})		
	public String getMethod(Model model) {
		UserInfo userInfo = new UserInfo();

		model.addAttribute("userInfo", userInfo);
		return "extraInfo";
	}
	
	@RequestMapping(value = "/uploadInfo", method = RequestMethod.POST)
	public String uploadInfo(HttpServletRequest request, @ModelAttribute("userInfo") 
			UserInfo userInfo){
		User user = (User) request.getSession().getAttribute("currentUser");
		user.setUserInfo(userInfo);
		IUserDAO.getUserDAO().updateUserInfo(user, userInfo);	
		return "redirect:/main";
	}
}
