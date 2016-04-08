package com.facebook.DAO;

import java.util.Iterator;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;

import com.facebook.POJO.Album;
import com.facebook.POJO.Picture;
import com.facebook.POJO.User;

public class AlbumDAO implements IAlbumDAO {

	@Override
	public void insertAlbum(User u, Album a) {

		Session session = SessionDispatcher.getSession();
		try {
			session.beginTransaction();

			session.persist(a);

			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public void deleteAlbum(int albumId) {
		Session session = SessionDispatcher.getSession();
		try {
			session.beginTransaction();

			Album a = (Album) session.get(Album.class, albumId);

			session.delete(a);

			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public void uploadImage(Picture pic, Album album) {
		Session session = SessionDispatcher.getSession();
		try {
			session.beginTransaction();

			album.addPicture(pic);
			pic.setAlbum(album);

			session.persist(pic);

			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Override
	public void removePicture(int pictureId) {
		Session session = SessionDispatcher.getSession();
		try {
			session.beginTransaction();

			Picture pic = (Picture) session.get(Picture.class, pictureId);

			session.delete(pic);

			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public Album getAlbumById(int id) {
		Session session = null;
		Album album = null;
		try {
			session = SessionDispatcher.getSession();
			session.beginTransaction();

			album = (Album) session.get(Album.class, id);

			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return album;
	}

	@Override
	public Album getAlbum(User u, String title) {
		Session session = null;
		Album album = null;
		try {
			session = SessionDispatcher.getSession();

			Query query = session.createQuery("from Album where title= :albumTitle and owner = :userId");
			query.setString("albumTitle", title);
			query.setInteger("userId", u.getId());

			album = (Album) query.uniqueResult();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return album;
	}

	@Override
	public Picture getPicById(int id) {
		Session session = null;
		Picture pic = null;
		try {
			session = SessionDispatcher.getSession();
			session.beginTransaction();

			pic = (Picture) session.get(Picture.class, id);

			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return pic;
	}
}
