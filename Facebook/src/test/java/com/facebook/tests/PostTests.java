package com.facebook.tests;
 
import org.junit.Test;

import com.facebook.DAO.IPostDAO;
import com.facebook.DAO.IUserDAO;
import com.facebook.POJO.*;

public class PostTests {

	
	@Test
	public void postInsertionTest() throws Exception {
		User user = IUserDAO.getUserDAO().getUserById(1);
		User user2 = IUserDAO.getUserDAO().getUserById(2);
		
		Post p = new Post(user, "image path", "post text");
		Post p1 = new Post(user2, "image path", "post text");

		IPostDAO.getPostDAO().insertPost(p);	
		IPostDAO.getPostDAO().insertPost(p1);	
	}
 	
	
//	@Test
//	public void removePostTest() throws Exception {
//		IPostDAO.getPostDAO().removePost(1);	
//	}
//	
	
//
//	@Test 
//	public void likePostTest(){
//		User user= IUserDAO.getUserDAO().getUserById(1);
//		Post post = IPostDAO.getPostDAO().getPostById(2);
//		
//		IPostDAO.getPostDAO().likePost(post, user);
//		
//	}
	
	
//	@Test 
//	public void unlikePostTest(){
//		System.out.println("Likes before delete: ");
//		IPostDAO.getPostDAO().unlikePost(1, 2);
//		Post p = IPostDAO.getPostDAO().getPostById(1);
//		
//		System.out.println("Likes after delete:");
//		System.out.println(p.getLikes());
//	}

	
//	
//	@Test 
//	public void commentPostTest(){
//		IPostDAO.getPostDAO().commentPost(1, 2, "napisah komentar");
//	}
	

//	@Test
//	public void removeCommentTest(){
//		IPostDAO.getPostDAO().removeComment(1);
//	}
//	
	
	/*
	@Test
	public void getPostTest(){
		Post p = IPostDAO.getPostDAO().getPostById(1);
		System.out.println(p);
	}*/
}
