package com.facebook.controllers.albumsAndPictures;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.facebook.DAO.IAlbumDAO;
import com.facebook.POJO.Album;
import com.facebook.POJO.Picture;
import com.facebook.POJO.User;

@Controller
public class DeletePic {

	@RequestMapping(value = "/deletePic/{id}", method = RequestMethod.GET)
	public String mainController(@PathVariable(value = "id") Integer id, HttpServletRequest request) {
		Picture picToRemove = (Picture) IAlbumDAO.getAlbumDAO().getPicById(id);
		Album album = picToRemove.getAlbum();
		
		Iterator<Picture> it = album.getPictures().iterator();
		
		IAlbumDAO.getAlbumDAO().removePicture(id);
		Picture toDelete = null;
		while(it.hasNext()){
			toDelete = it.next();
			if(toDelete.getId() == id){
				break;
			}
		}
		album.removePicture(toDelete);
		return "redirect:/pictures/"+album.getId();
	}
}
