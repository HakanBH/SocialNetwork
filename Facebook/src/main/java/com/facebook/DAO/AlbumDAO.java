package com.facebook.DAO;

import java.util.Set;

import org.hibernate.Session;

import com.facebook.POJO.Album;
import com.facebook.POJO.Picture;

public class AlbumDAO implements IAlbumDAO {

	@Override
	public void insertAlbum(Album a) {
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
	public void addPicturesToAlbum(Album a, Set<Picture> pictures) {
		Session session = SessionDispatcher.getSession();
		try {
			session.beginTransaction();

			for(Picture p:pictures){
				System.out.println(p);
				a.addPicture(p);
			}
			System.out.println(a);
			session.update(a);
			
			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
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



}
