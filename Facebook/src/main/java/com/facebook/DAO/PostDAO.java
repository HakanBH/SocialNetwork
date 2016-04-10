package com.facebook.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.facebook.POJO.Comment;
import com.facebook.POJO.Picture;
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
	public void insertPost(User owner, Picture pic, String text) {
		Session session = null;
		try {
			session = SessionDispatcher.getSession();
			session.beginTransaction();

			Post p = new Post(owner, pic, text);
			session.persist(p);

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
			Transaction transaction = session.beginTransaction();

			Post p = (Post) session.get(Post.class, postId);
			session.delete(p);

			transaction.commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public void likePost(Post post, User user) {
		Session session = null;
		try {
			session = SessionDispatcher.getSession();
			session.beginTransaction();

			post.addLike(user);
			session.update(post);

			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public void sharePost(Post post, User user) {
		Session session = null;
		try {
			session = SessionDispatcher.getSession();
			session.beginTransaction();

			post.addShare(user);
			user.sharePost(post);

			session.update(post);
			

			session.getTransaction().commit();
		} finally {
			if (session != null) {
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

			Post post = (Post) session.load(Post.class, postId);
			User user = (User) session.load(User.class, userId);

			post.removeLike(user);

			session.update(post);

			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public void commentPost(Post post, User user, Comment c) {
		Session session = null;
		try {
			session = SessionDispatcher.getSession();
			session.beginTransaction();

			c.setOwner(user);
			c.setPost(post);
			session.save(c);

			session.getTransaction().commit();
		} finally {
			if (session != null) {
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
			if (session != null) {
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

	@Override
	public List<Post> getAllPosts() {
		Session session = SessionDispatcher.getSession();
		try {
			session.beginTransaction();

			Query query = session.createQuery("from Post");
			List<Post> result = query.list();

			session.getTransaction().commit();

			return result;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public boolean deletePost(User u, Post p) throws Exception {
		Session session = null;
		try {
			session = SessionDispatcher.getSession();
			session.beginTransaction();

			u.removePost(p);
			session.update(u);
			session.delete(p);

			session.getTransaction().commit();

			return true;
		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<Post> getSharedPosts(User u) {
		Session session = null;
		List<Post> sharedPosts = new ArrayList<Post>();
		try {
			session = SessionDispatcher.getSession();
			session.beginTransaction();

			Query query = session.createQuery("from User u INNER JOIN u.sharedPosts p"
					+ " where u.id = :userId");
			query.setInteger("userId", u.getId());
			sharedPosts = query.list();

			session.getTransaction().commit();

		} finally {
			session.close();
		}
		return sharedPosts;
	}
}
