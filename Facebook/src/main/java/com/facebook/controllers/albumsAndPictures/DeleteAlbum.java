package com.facebook.controllers.albumsAndPictures;

import java.util.Iterator; 

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

	@RequestMapping(method = RequestMethod.POST)
	public String mainController(Model model, HttpServletRequest request) {
		String albumToDelete = request.getParameter("albumToDelete");
		int albumId = Integer.parseInt(albumToDelete);

		IAlbumDAO.getAlbumDAO().deleteAlbum(albumId);
		
		User currentUser = (User) request.getSession().getAttribute("currentUser");

		Iterator<Album> it = currentUser.getAlbums().iterator();
		Album toDelete = null;
		while(it.hasNext()){
			toDelete = it.next();
			if(toDelete.getId() == albumId){
				break;
			}
		}
		currentUser.removeAlbum(toDelete);
		return "redirect:/album";
	}

}
