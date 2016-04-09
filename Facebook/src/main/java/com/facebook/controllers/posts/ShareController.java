package com.facebook.controllers.posts;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.facebook.DAO.IAlbumDAO;
import com.facebook.DAO.IPostDAO;
import com.facebook.POJO.Album;
import com.facebook.POJO.Picture;
import com.facebook.POJO.Post;
import com.facebook.POJO.User;

@Controller
public class ShareController {
	private static final String STORAGE = "C:" + File.separator + "images " + File.separator + "users" + File.separator;

	@RequestMapping(value = "/sharePost", method = RequestMethod.POST)
	public String likePost(HttpServletRequest request) {
		User currentUser = (User) request.getSession().getAttribute("currentUser");
		String sharedPostId = (String) request.getParameter("sharedPost");
		int id = Integer.parseInt(sharedPostId);
		
		Post sharedPost = IPostDAO.getPostDAO().getPostById(id);
		User postOwner = sharedPost.getOwner();
		String picName = sharedPost.getPicture().getName();
		Album album = IAlbumDAO.getAlbumDAO().getAlbum(currentUser, "PostPictures");
		
		if(album == null){
			album = new Album("PostPictures", currentUser);
			IAlbumDAO.getAlbumDAO().insertAlbum(currentUser, album);
		}
		
		// get shared picture location
		String source = User.STORAGE_PATH + postOwner.getEmail() + File.separator + "PostPictures" + File.separator;
		File sourceImage = new File(source + sharedPost.getPicture().getName());
		
		// generate new picture location an name
		String extension = picName.substring(picName.lastIndexOf("."));
		picName="post-pic" + (album.getPictures().size() + 1) + extension;
		String destination = User.STORAGE_PATH + currentUser.getEmail() + File.separator + "PostPictures" + File.separator;
		new File(destination).mkdirs();
		File destImage = new File(destination + picName);
		
		try {
			FileUtils.copyFile(sourceImage, destImage);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Picture pic = new Picture(picName);
		
		IAlbumDAO.getAlbumDAO().uploadImage(pic, album);
		
		Post newPost = new Post(currentUser, pic, sharedPost.getText());
		IPostDAO.getPostDAO().insertPost(newPost);
		IPostDAO.getPostDAO().sharePost(sharedPost, currentUser);
		
		for(Post p : currentUser.getPosts()){
			if(p.getId() == sharedPost.getId()){
				p.addShare(currentUser);
				currentUser.sharePost(p);
			}
		}
		currentUser.addPost(newPost);
		return "redirect:/main";
	}
}
