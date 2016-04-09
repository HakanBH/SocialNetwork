package com.facebook.controllers.albumsAndPictures;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.facebook.DAO.IAlbumDAO;
import com.facebook.POJO.Album;
import com.facebook.POJO.User;

@Controller
@RequestMapping("/deleteAlbum")
public class DeleteAlbum {
	
	@RequestMapping(method=RequestMethod.POST)
	public String mainController(Model model, HttpServletRequest request){
			int albumId = Integer.parseInt(request.getParameter("albumToDelete"));
			
			User currentUser = (User) request.getSession().getAttribute("currentUser");
			
			Album album = IAlbumDAO.getAlbumDAO().getAlbumById(albumId);				
			IAlbumDAO.getAlbumDAO().deleteAlbum(albumId);
			currentUser.removeAlbum(album);
			
			model.addAttribute("albums",currentUser.getAlbums());
			
		return "redirect:/album";
	}

}
