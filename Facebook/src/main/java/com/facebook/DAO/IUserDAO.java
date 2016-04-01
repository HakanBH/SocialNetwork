package com.facebook.DAO;

import com.facebook.POJO.Picture;
import com.facebook.POJO.User;
import com.facebook.POJO.UserInfo;

public interface IUserDAO {
	static IUserDAO getUserDAO() {
		return new UserDAO();
	}
	
	User getUserById(int id);
	User login(String email, String password) throws Exception  ;
	boolean isEmailTaken(String email) throws Exception  ;
	
	void insertUser(User user) throws Exception ;
	boolean deleteUser(int id) throws Exception;
	
	void addProfileImage(int userId, Picture imagePath);
	
	void addFriend(User u, User friend);
	void removeFriend(User user, User friend);

	void updateUserInfo(User user, UserInfo info);

}