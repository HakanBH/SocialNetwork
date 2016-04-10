package com.facebook.controllers.albumsAndPictures;

import java.io.File;
import java.util.HashSet;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.facebook.DAO.IAlbumDAO;
import com.facebook.DAO.IUserDAO;
import com.facebook.POJO.Album;
import com.facebook.POJO.Picture;
import com.facebook.POJO.User;

@Controller
@RequestMapping("/createAlbum")
public class CreateAlbum {
	
	@RequestMapping(method=RequestMethod.POST)
	public String mainController(HttpServletRequest request){
			String title = request.getParameter("newName");
			User currentUser = (User) request.getSession().getAttribute("currentUser");
			if(title != null && title.length() > 0 && !currentUser.checkAlbumByTitle(title)){
				
				String filePath = User.STORAGE_PATH + currentUser.getEmail() + File.separator + title + File.separator;
				new File(filePath).mkdirs();
			
			Album newAlbum = new Album(title, currentUser);
			IAlbumDAO.getAlbumDAO().insertAlbum(currentUser, newAlbum);
			currentUser.addAlbum(newAlbum);
			}
			
		return "redirect:/album";
	}

}
