package com.facebook.DAO;

import com.facebook.POJO.Post;
import com.facebook.POJO.User;

public interface IPostDAO {
	static IPostDAO getPostDAO() {
		return new PostDAO();
	}

	Post getPostById(int id);

	void insertPost(Post post);
	void removePost(int postId);
	
	void likePost(Post p, User u);
	void unlikePost(int postId, int userId);


	void commentPost(int postId, int userId, String str);
	void removeComment(int commentId);
}
