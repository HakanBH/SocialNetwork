package com.facebook.controllers.REST;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.facebook.DAO.IAlbumDAO;
import com.facebook.DAO.IUserDAO;
import com.facebook.POJO.Album;
import com.facebook.POJO.Picture;
import com.facebook.POJO.User;
 
@RestController
public class PictureServices {
	IAlbumDAO albumDAO = IAlbumDAO.getAlbumDAO();

	@RequestMapping(value = "/albumPictures/{albumId}", method = RequestMethod.GET)
	List<Picture> getAlbumPictures(@PathVariable("albumId") Integer albumId) {	
		Album a = albumDAO.getAlbumById(albumId);
		return a.getPictures();
	}
	
	@RequestMapping(value = "/allPictures/{userId}", method = RequestMethod.GET)
	List<Picture> getUserPictures(@PathVariable("userId") Integer userId) {	
		User u = IUserDAO.getUserDAO().getUserById(userId);
		List<Picture> result = new ArrayList<Picture>();
		for(Album a : u.getAlbums()){
			for(Picture pic: a.getPictures()){
				result.add(pic);
			}
		}	
		return result;
	}
}
