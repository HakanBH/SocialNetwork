package com.facebook.tests;

import org.junit.Test;

import com.facebook.DAO.IUserDAO;
import com.facebook.POJO.User;

public class FriendshipTests {

	@Test
	public void addFriendshipTest() {
		
		User user1 = IUserDAO.getUserDAO().getUserById(1);
		User user2 = IUserDAO.getUserDAO().getUserById(2);
		User user3 = IUserDAO.getUserDAO().getUserById(3);

		IUserDAO.getUserDAO().addFriend(user1, user3);
		IUserDAO.getUserDAO().addFriend(user1, user2);
	}	
	
	@Test
	public void removeFriendshipTest(){
		User user1 = IUserDAO.getUserDAO().getUserById(1);
		User user2 = IUserDAO.getUserDAO().getUserById(2);
		
		IUserDAO.getUserDAO().removeFriend(user1, user2);
		
		System.out.println(user1.getFriends());
	}
}
