package com.facebook.controllers.posts;

import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.facebook.DAO.IPostDAO;
import com.facebook.POJO.Post;
import com.facebook.POJO.User;

@Controller
public class DeleteController {

	@RequestMapping(value="/deletePost", method=RequestMethod.POST)
	public String deletePost(HttpServletRequest request){
		User currentUser = (User) request.getSession().getAttribute("currentUser");
		String postToDeleteId = (String) request.getParameter("postToDelete");
		int id = Integer.parseInt(postToDeleteId);
		
		Iterator<Post> it = currentUser.getOwnedPosts().iterator();

		Post toDelete = null;
		while(it.hasNext()){
			toDelete = it.next();
			if(toDelete.getId() == id){
				break;
			}
		}
		
		currentUser.removePost(toDelete);
		IPostDAO.getPostDAO().removePost(id);
		
		return "redirect:/profile";
	}
}
