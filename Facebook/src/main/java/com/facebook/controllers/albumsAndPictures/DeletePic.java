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
	
	@RequestMapping(value="/deletePic/{id}", method=RequestMethod.GET)
	public String mainController(@PathVariable(value="id") Integer id, HttpServletRequest request){
			Picture picToRemove = (Picture) IAlbumDAO.getAlbumDAO().getPicById(id);
			Album album = picToRemove.getAlbum();
			
			album.getPictures().remove(picToRemove);

		System.err.println(album.getPictures().contains(picToRemove));
		HashSet<Picture> set = (HashSet<Picture>) request.getSession().getAttribute("selectedPictures");
		set.remove(picToRemove);
			IAlbumDAO.getAlbumDAO().removePicture(picToRemove.getId());
		return "redirect:/pictures";
	}

}
