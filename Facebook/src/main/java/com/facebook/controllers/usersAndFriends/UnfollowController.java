package com.facebook.controllers.usersAndFriends;

import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.facebook.DAO.IUserDAO;
import com.facebook.POJO.User;

@Controller
public class UnfollowController {

	@RequestMapping(value="/unfollowUser", method=RequestMethod.POST)
	public String unfollow(HttpServletRequest request){
		String userToremoveId = request.getParameter("userToRemove");
		int id = Integer.parseInt(userToremoveId);
		
		User currentUser = (User) request.getSession().getAttribute("currentUser");
		IUserDAO.getUserDAO().removeFriend(currentUser.getId(), id);
	
		Iterator<User> it = currentUser.getFriends().iterator();

		User userToUnfollow  = null;
		while(it.hasNext()){
			userToUnfollow  = it.next();
			if(userToUnfollow.getId() == id ){
				break;
			}
		}
		currentUser.removeFriend(userToUnfollow);
		return "redirect:/friends";
	}
}		