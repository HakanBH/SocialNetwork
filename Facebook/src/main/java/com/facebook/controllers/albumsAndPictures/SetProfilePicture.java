package com.facebook.controllers.albumsAndPictures;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.facebook.DAO.IAlbumDAO;
import com.facebook.DAO.IUserDAO;
import com.facebook.POJO.Picture;
import com.facebook.POJO.User;

@Controller
@RequestMapping(value = "/SetProfilePicture/{pic_id}")
public class SetProfilePicture {
	@RequestMapping(method = RequestMethod.POST)
	public String deletePicture(@PathVariable("pic_id")	Integer picId, HttpServletRequest request) {
		
		Picture pic = IAlbumDAO.getAlbumDAO().getPicById(picId);
		User currUser = (User) request.getSession().getAttribute("user");	
		IUserDAO.getUserDAO().setProfilePicture(pic, currUser);

		return "redirect:/Profile";
	}
}
