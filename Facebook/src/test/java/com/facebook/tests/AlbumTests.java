package com.facebook.tests;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import com.facebook.DAO.IAlbumDAO;
import com.facebook.DAO.IUserDAO;
import com.facebook.POJO.Album;
import com.facebook.POJO.Picture;
import com.facebook.POJO.User;

public class AlbumTests {

//	@Test
//	public void createAlbumTest() {
//		User u = IUserDAO.getUserDAO().getUserById(1);
//
//		Album a = new Album("Albumche", u);
//		IAlbumDAO.getAlbumDAO().insertAlbum(a);
//	}

	
	@Test 
	public void addPicturesTest (){
		Set<Picture> pics = new HashSet<Picture>(Arrays.asList(new Picture("pic12.jpg"),
				new Picture("pic32.jpg")));
		Album album = IAlbumDAO.getAlbumDAO().getAlbumById(6);

		IAlbumDAO.getAlbumDAO().addPicturesToAlbum(album,pics);
	}
	
//	@Test
//	public void removePictureTest(){
//		IAlbumDAO.getAlbumDAO().removePicture(1);
//	}
	
//	@Test
//	public void deleteAlbumTest(){
//		IAlbumDAO.getAlbumDAO().deleteAlbum(6);
//	}
}
