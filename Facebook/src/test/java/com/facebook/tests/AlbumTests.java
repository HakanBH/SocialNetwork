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

//	
	@Test 
	public void addPicturesTest () throws InterruptedException{
		Album album = IAlbumDAO.getAlbumDAO().getAlbumById(18);
		Picture pic = new Picture("name");
		
		IAlbumDAO.getAlbumDAO().uploadImage(pic, album);
	}
	
//	@Test
//	public void removePictureTest(){
//		IAlbumDAO.getAlbumDAO().removePicture(8);
//		IAlbumDAO.getAlbumDAO().removePicture(9);
//	}
	
//	@Test
//	public void getAlbum(){
//		System.out.println(IAlbumDAO.getAlbumDAO().getAlbum(25, "profilePics"));
//	}
	
//	@Test
//	public void getPictureTest(){
//		System.out.println(IAlbumDAO.getAlbumDAO().getPicById(1));
//	}

//	@Test
//	public void deleteAlbumTest(){
//		IAlbumDAO.getAlbumDAO().deleteAlbum(3);
//	}
	
//	@Test
//	public void deleteAllAlbums(){
//		for(int i=0;i<100;i++){
//			Album a = IAlbumDAO.getAlbumDAO().getAlbumById(i);
//			if(a!=null){
//				IAlbumDAO.getAlbumDAO().deleteAlbum(a.getId());
//			}
//		}
//	}
	
//	@Test 
//	public void setTitleTest(){
//		Album a = IAlbumDAO.getAlbumDAO().getAlbumById(21);
//		IAlbumDAO.getAlbumDAO().updateTitle(a, "new title 1");
//	}
}
