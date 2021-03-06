package com.facebook.DAO;

import java.util.List;

import com.facebook.POJO.Comment;
import com.facebook.POJO.Picture;
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
	void unlikePost(int likedPost, int currentUser);

	void commentPost(Post commentedPost, User currentUser, Comment comment);
	void removeComment(int commentId);

	List<Post> getAllPosts();

	boolean deletePost(User u, Post p) throws Exception;

	void sharePost(Post post, User user);

	void insertPost(User owner, Picture pic, String text);

	List<Post> getSharedPosts(User u);
}
