package com.facebook.tests;

import org.junit.Test;

import com.facebook.DAO.IUserDAO;
import com.facebook.POJO.User;

public class FriendshipTests {
	IUserDAO userDAO = IUserDAO.getUserDAO();
//	@Test
//	public void addFriendshipTest() {
//		
//		User user1 = userDAO.getUserById(2);
//		User user2 = userDAO.getUserById(3);
//		User user3 = userDAO.getUserById(4);
//		User user4 = userDAO.getUserById(6);
//
//		userDAO.addFriend(user4, user1);
//		userDAO.addFriend(user4, user2);
//		userDAO.addFriend(user4, user3);
//		userDAO.addFriend(user4, user1);
//		userDAO.addFriend(user4, user2);
//		userDAO.addFriend(user4, user3);
//	
//	}	
	
//	@Test
//	public void removeFriendshipTest(){
//		User user1 = userDAO.getUserById(1);
//		User user2 = userDAO.getUserById(2);
//		
//		userDAO.removeFriend(user1, user2);
//		
//		System.out.println(user1.getFriends());
//	}

	@Test
	public void getFrindsOfFriendsTest(){
		User user = userDAO.getUserById(1);
		for(User u : user.getFriendsOfFriends()){
			System.out.println(u);
		}
	}
}
