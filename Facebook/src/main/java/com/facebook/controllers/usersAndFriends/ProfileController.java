package com.facebook.controllers.usersAndFriends;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.facebook.POJO.Album;
import com.facebook.POJO.Picture;
import com.facebook.POJO.User;
import com.facebook.POJO.UserInfo;

import static com.facebook.controllers.MainPage.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/profile")
public class ProfileController {
	@RequestMapping(method = RequestMethod.GET)
	public String mainController(Model model, HttpServletRequest request) {
		User currentUser = (User) request.getSession().getAttribute("currentUser");
		UserInfo userInfo = currentUser.getUserInfo();
		request.getSession().setAttribute("userInfo", userInfo);
		prepareSuggestions(model, currentUser);
		prepareFriends(model, currentUser);
		preparePics(model,currentUser);
		return "profile";
	}
	
	public static void prepareFriends(Model model, User currentUser){
	
		Set<User> friends = (Set<User>) currentUser.getFriends() ;
			model.addAttribute("friends", friends);
	}
	
	public static void preparePics(Model model, User currentUser){
		Set<Album> albums = (Set<Album>) currentUser.getAlbums();
		List<Picture> picList = new ArrayList<Picture>();
		for(Album album : albums){
			for(Picture p: album.getPictures()){
				picList.add(p);
			}
		}
		Collections.shuffle(picList);
		model.addAttribute("pictures", picList);
	}
}