package com.facebook.tests;
 
import javax.persistence.Transient;

import org.hibernate.Hibernate;
import org.junit.Test;

import com.facebook.DAO.IPostDAO;
import com.facebook.DAO.IUserDAO;
import com.facebook.DAO.PostDAO;
import com.facebook.DAO.UserDAO;
import com.facebook.POJO.*;

public class PostTests {
	IPostDAO postDao = IPostDAO.getPostDAO();
//	
//	@Test
//	public void postInsertionTest() throws Exception {
//		User user = IUserDAO.getUserDAO().getUserById(1);
//		
//		Post p1 = new Post(user, "image path", "Post 1. Some text here.");
//		Post p2 = new Post(user, "image path", "Post 2. Some text here.");
//		Post p3 = new Post(user, "image path", "Post 3. Some text here.");
//		
//		postDao.insertPost(p1);
//		postDao.insertPost(p2);
//		postDao.insertPost(p3);
//	}

//	@Test
//	public void getPostsOfUser(){
//		User user = IUserDAO.getUserDAO().getUserById(1);
//		System.out.println(user.getOwnedPosts());
//	}
	
//	@Test
//	public void getPostsOfFriends(){
//		User user = IUserDAO.getUserDAO().getUserById(9);
//		System.out.println(user.getPosts());
//	}
//	
	
//	@Test
//	public void removePostTest() throws Exception {
//		IPostDAO.getPostDAO().removePost(1);	
//	}
//	
	
//
//	@Test 
//	public void likePostTest(){
//		User user= IUserDAO.getUserDAO().getUserById(2);
//		Post post = IPostDAO.getPostDAO().getPostById(8);
//		
//		IPostDAO.getPostDAO().likePost(post, user);
//	}
//	
	
//	@Test 
//	public void unlikePostTest(){
//		IPostDAO.getPostDAO().unlikePost(8, 2);
//	}

	
//	@Test
//	public void deleteAllPosts() throws Exception{
//		for(Post p: IPostDAO.getPostDAO().getAllPosts()){
//			System.err.println(p);
//			IPostDAO.getPostDAO().deletePost(p.getOwner(),p);
//		}
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
