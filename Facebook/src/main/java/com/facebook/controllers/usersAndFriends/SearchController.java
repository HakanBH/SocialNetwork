package com.facebook.controllers.usersAndFriends;

import static com.facebook.controllers.MainPage.prepareSuggestions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.facebook.DAO.IUserDAO;
import com.facebook.POJO.User;

@Controller
@RequestMapping("/searchUsers")
public class SearchController {
	@RequestMapping(method=RequestMethod.POST)
	public String searchUsers(Model model,HttpServletRequest request){
		User currentUser = (User) request.getSession().getAttribute("currentUser");
		String string = request.getParameter("searchText");
		
		prepareSuggestions(model, currentUser);
		List<User> searchResults = IUserDAO.getUserDAO().searchUsers(string);
		model.addAttribute("searchResults", searchResults);
		
		return "search";
	}
}
