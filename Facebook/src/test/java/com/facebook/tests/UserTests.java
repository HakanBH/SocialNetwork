package com.facebook.tests;


import java.sql.Date; 

import org.junit.Test;

import com.facebook.DAO.IAlbumDAO;
import com.facebook.DAO.IUserDAO;
import com.facebook.POJO.Picture;
import com.facebook.POJO.User;

public class UserTests {
	IUserDAO userDAO = IUserDAO.getUserDAO();
//	@Test 
//	public void getAllUsersTest(){
//		for(User u : IUserDAO.getUserDAO().getAllUsers()){
//			System.out.println(u);
//		}
//	}

//	@Test
//	public void setProfilePictureTest(){
//		Picture pic = IAlbumDAO.getAlbumDAO().getPicById(2);
//		User user = IUserDAO.getUserDAO().getUserById(1);
//		
//		IUserDAO.getUserDAO().setProfilePicture(pic, user);
//	}
//	

//	@Test
//	public void userInsertion() throws Exception {
//		User user = new User("martin.hyusein@gmail.com", "1234", "Hakan", "Hyusein");
//		User user1 = new User("bojo.hyusein@gmail.com", "1234", "Hakan", "Hyusein");
//		User user2 = new User("angel.hyusein@gmail.com", "1234", "Hakan", "Hyusein");
//		User user3 = new User("svetlio.hyusein@gmail.com", "1234", "Hakan", "Hyusein");
//
//		userDAO.insertUser(user);
//		userDAO.insertUser(user1);
//		userDAO.insertUser(user2);
//		userDAO.insertUser(user3);
//	} 

//	
//	@Test
//	public void updateUserInfo(){
//		User user = IUserDAO.getUserDAO().getUserById(35);
//		UserInfo info = new UserInfo("Bulgaria","Sofia","gen.Kiril Botev",
//					Date.valueOf("1994-05-17"),"male","0887989190","single",""); 
//		IUserDAO.getUserDAO().updateUserInfo(user, info);
//	}


//	@Test
//	public void deleteUserById() throws Exception  {
//		boolean wasDeleted = IUserDAO.getUserDAO().deleteUser(1);
//		System.out.println(wasDeleted);
//	}
	
//	@Test
//	public void deleteAllUsers() throws Exception{
//		for(User u: IUserDAO.getUserDAO().getAllUsers()){
//			System.err.println(u);
//			IUserDAO.getUserDAO().deleteUser(u.getId());
//		}
//	}

//	@Test
//	public void loginTest() throws Exception  {
//
//		User u = IUserDAO.getUserDAO().login("hakanaaaaaaaaaa.hyusein@gmail.com", "1234");
//		User u1 = IUserDAO.getUserDAO().login("deniz.hyusein@gmail.com", "1234");
//		User u2 = IUserDAO.getUserDAO().login("sevim.hyusein@gmail.com", "1234");
//
//		System.out.println(u1);
//	}
	
//	@Test
//	public void takenEmailTest() throws Exception{
//		boolean isTaken = IUserDAO.getUserDAO().isEmailTaken("hakan.hyusein@abv.bg");
//		System.out.println(isTaken);	
//	}
//	@Test
//	public void testChangeProfilePic() throws Exception{
//		IUserDAO.getUserDAO().addProfileImage(10, "[image path]");
//		User updateUser = IUserDAO.getUserDAO().getUserById(10);
//		System.out.println(updateUser);
//	}
	
}
