package com.facebook.DAO;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileDeleteStrategy;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.jasypt.util.password.BasicPasswordEncryptor;

import com.facebook.POJO.Album;
import com.facebook.POJO.Picture;
import com.facebook.POJO.Post;
import com.facebook.POJO.User;
import com.facebook.POJO.UserInfo;

public class UserDAO implements IUserDAO {
	private static final String EMAIL_CHECK_QUERY = "from User U where U.email = :email";

	@Override
	public void insertUser(User user) throws Exception {
		Session session = SessionDispatcher.getSession();
		try {
			session.beginTransaction();

			// insert extra info column
			UserInfo details = new UserInfo();
			user.setUserInfo(details);
			details.setUser(user);

			// encrypt password
			BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
			String encryptedPassword = passwordEncryptor.encryptPassword(user.getPassword());
			user.setPassword(encryptedPassword);
			session.persist(user);
				
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			throw new Exception(e);
		} finally {
			session.close();
		}
	}
	
	@Override
	public boolean deleteUser(int id) throws Exception {
		Session session = null;
		try {
			session = SessionDispatcher.getSession();
			session.beginTransaction();
			User u = (User) session.get(User.class, id);
			UserInfo info = (UserInfo) session.get(UserInfo.class, id);
			session.delete(info);
			session.delete(u);

			session.getTransaction().commit();
			
			File userDir = new File(User.STORAGE_PATH + File.separator + u.getEmail() + File.separator);
			
			FileDeleteStrategy.FORCE.delete(userDir);
			userDir.delete();
		
			return true;
		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			session.close();
		}
	}
	
	@Override
	public void updateUserInfo(User user, UserInfo info) {
		Session session = null;
		try {
			session = SessionDispatcher.getSession();

			int userId = user.getId();
			User userToUpdate = (User) session.get(User.class, userId);
			UserInfo infoToUpdate = (UserInfo) session.get(UserInfo.class, userId);

			userToUpdate.copy(user);
			infoToUpdate.copy(info);

			session.update(userToUpdate);
			session.update(infoToUpdate);

			session.beginTransaction();
			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	@Override
	public List<User> getAllUsers() {
		Session session = SessionDispatcher.getSession();
		try {
			session.beginTransaction();

			Query query = session.createQuery("from User");
			List<User> result = query.list();
			
			session.getTransaction().commit();

			return result;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public User getUserById(int id) {
		Session session = null;
		User user = null;
		try {
			session = SessionDispatcher.getSession();
			session.beginTransaction();
			
			user = (User) session.get(User.class, id);
			for(Post p : user.getOwnedPosts()){
			   Hibernate.initialize(p);
			}
				
			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return user;
	} 
	
	@Override
	public boolean isEmailTaken(String email) throws Exception {
		Session session = SessionDispatcher.getSession();
		try {
			Query query = session.createQuery(EMAIL_CHECK_QUERY);
			query.setString("email", email);

			return (query.uniqueResult() != null);
		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			session.close();
		}
	}
	
	/**
	 * @param email
	 *            - a string which is the email to be searched for.
	 * @param pass
	 *            - string - password to be searched for.
	 * @return Instance of object if there is a user with password and email
	 *         equal to the given parameters. Returns null otherwise.
	 * @throws Exception
	 */

	@Override
	public User login(String email, String pass) throws Exception {
		Session session = SessionDispatcher.getSession();
		try {
			Query query = session.createQuery(EMAIL_CHECK_QUERY);
			query.setString("email", email);
			User user = (User) query.uniqueResult();

			BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();

			if (passwordEncryptor.checkPassword(pass, user.getPassword())) {
				return user;
			} else {
				return null;
			}
		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void setProfilePicture(Picture pic , User user) {
		Session session = SessionDispatcher.getSession();
		try {
			session.beginTransaction();
			
			user.setProfilePicture(pic);
			
			session.update(user);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	@Override
	public void setBgPicture(Picture pic , User user) {
		Session session = SessionDispatcher.getSession();
		try {
			session.beginTransaction();
			user.setBgPicture(pic);;
			session.update(user);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Override
	public void addFriend(User u, User friend) {
		Session session = SessionDispatcher.getSession();
		try {
			session.beginTransaction();

			if (!u.getFriends().contains(friend)) {
				u.addFriend(friend);
				session.update(u);
			} else {
				return;
			}

			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Override
	public void removeFriend(User user, User friend) {
		Session session = SessionDispatcher.getSession();
		try {
			session.beginTransaction();

			user.removeFriend(friend);
			session.merge(user);

			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}


}
