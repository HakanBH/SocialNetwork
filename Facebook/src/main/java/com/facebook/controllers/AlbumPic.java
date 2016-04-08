package com.facebook.controllers;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.facebook.DAO.IAlbumDAO;
import com.facebook.DAO.IUserDAO;
import com.facebook.POJO.Album;
import com.facebook.POJO.Picture;
import com.facebook.POJO.User;
import com.facebook.POJO.UserInfo;

@Controller

public class AlbumPic {
	@RequestMapping(value="/pictures/{id}", method=RequestMethod.GET)
	public String mainController(@PathVariable(value="id") Integer id, HttpServletRequest request){
			User currentUser = (User) request.getSession().getAttribute("currentUser");
			Album selectedAlbum =  (Album)IAlbumDAO.getAlbumDAO().getAlbumById(id);
			Set<Picture> pictureSet = new HashSet<Picture>(selectedAlbum.getPictures());
			
			request.getSession().setAttribute("selectedAlbum", selectedAlbum);
			request.getSession().setAttribute("selectedPictures", pictureSet);
		return "redirect:/pictures";
	}
	
		
		@RequestMapping(value="/pictures", method=RequestMethod.GET)
		public String cont(Model model, HttpServletRequest request){
			Album selectedAlbum = (Album) request.getSession().getAttribute("selectedAlbum");
			request.getSession().getAttribute("selectedPictures");
			return "/album_pics";
		}
}
