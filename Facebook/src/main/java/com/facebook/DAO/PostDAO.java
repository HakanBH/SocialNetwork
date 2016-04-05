package com.facebook.DAO;

import org.hibernate.Session;

import com.facebook.POJO.Comment;
import com.facebook.POJO.Post;
import com.facebook.POJO.User;

public class PostDAO implements IPostDAO {
	
	@Override
	public void insertPost(Post post) {
		Session session = null;
		try {
			session = SessionDispatcher.getSession();
			session.beginTransaction();
			
			session.persist(post);

			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	@Override
	public void removePost(int postId) {
		Session session = null;
		try {
			session = SessionDispatcher.getSession();
			session.beginTransaction();

			Post p = (Post) session.get(Post.class, postId);
			session.delete(p);
			
			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public void likePost(Post post, User useru) {
		Session session = null;
		try {
			session = SessionDispatcher.getSession();
			session.beginTransaction();
			
			post.addLike(useru);
			session.update(post);
			
			session.getTransaction().commit();
		} finally {
			if(session!=null){
				session.close();
			}
		}
	}

	@Override
	public void unlikePost(int postId, int userId) {
		Session session = null;
		try {
			session = SessionDispatcher.getSession();
			session.beginTransaction();
			
			Post p = (Post) session.get(Post.class, postId);
			User u = (User) session.get(User.class, userId);
			
			p.removeLike(u);
			
			session.update(p);
			
			session.getTransaction().commit();
		} finally {
			if(session!=null){
				session.close();
			}
		}
	}

	@Override
	public void commentPost(int postId, int userId, String str) {
		Session session = null;
		try {
			session = SessionDispatcher.getSession();
			session.beginTransaction();
			
			Post p = (Post) session.get(Post.class, postId);
			User u = (User) session.get(User.class, userId);
			
			Comment c = new Comment(u, p, str);
			
			session.save(c);
			
			session.getTransaction().commit();
		} finally {
			if(session!=null){
				session.close();
			}
		}
	}
	
	@Override
	public void removeComment(int commentId) {
		Session session = null;
		try {
			session = SessionDispatcher.getSession();
			session.beginTransaction();
			
			Comment c = (Comment) session.get(Comment.class, commentId);
			session.delete(c);
			
			session.getTransaction().commit();
		} finally {
			if(session!=null){
				session.close();
			}
		}
	}
	
	@Override
	public Post getPostById(int id) {
		Session session = null;
		Post post = null;
		try {
			session = SessionDispatcher.getSession();
			session.beginTransaction();

			post = (Post) session.get(Post.class, id);

			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return post;
	}


}
