package com.facebook.DAO;

import java.util.Set;

import com.facebook.POJO.Album;
import com.facebook.POJO.Picture;

public interface IAlbumDAO {
	static IAlbumDAO getAlbumDAO() {
		return new AlbumDAO();
	}

	void insertAlbum(Album a);
	void deleteAlbum(int albumId);
	
	void addPicturesToAlbum(Album a, Set<Picture> pics);
	void removePicture(int pictureId);

	Album getAlbumById(int id);


}
