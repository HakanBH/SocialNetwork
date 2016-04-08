package com.facebook.DAO;

import java.util.Collection;
import java.util.List;

import com.facebook.POJO.Album;
import com.facebook.POJO.Picture;
import com.facebook.POJO.User;
import com.facebook.POJO.UserInfo;

public interface IUserDAO {
	static IUserDAO getUserDAO() {
		return new UserDAO();
	}
	
	void insertUser(User user) throws Exception;
	boolean deleteUser(int id) throws Exception;
	void updateUserInfo(User user, UserInfo info);

	User getUserById(int id);
	List<User> getAllUsers();

	boolean isEmailTaken(String email) throws Exception;
	User login(String email, String password) throws Exception;
	
	void setProfilePicture(Picture pic, User currUser);
	
	void addFriend(User u, User friend);
	void removeFriend(User user, User friend);

	void setBgPicture(Picture pic, User user);

	List<User> searchUsers(String str);
}