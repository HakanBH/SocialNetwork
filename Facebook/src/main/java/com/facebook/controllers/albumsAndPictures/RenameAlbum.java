package com.facebook.controllers.albumsAndPictures;

import java.io.File;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.facebook.DAO.IAlbumDAO;
import com.facebook.POJO.Album;
import com.facebook.POJO.User;

@Controller
@RequestMapping("/renameAlbum")
public class RenameAlbum {

	@RequestMapping(method = RequestMethod.POST)
	public String mainController(Model model, HttpServletRequest request) {
		String albumToRename = request.getParameter("albumToRename");
		String newTitle = request.getParameter("newName");
		int albumId = Integer.parseInt(albumToRename);
		User currentUser = (User) request.getSession().getAttribute("currentUser");
		
		String oldTitle = IAlbumDAO.getAlbumDAO().getAlbumById(albumId).getTitle();
		if (newTitle != null && newTitle.length() > 0 && !oldTitle.equals("ProfilePictures")
				&& !oldTitle.equals("PostPictures") && !oldTitle.equals("BgPictures")) {
			

			String filePath = User.STORAGE_PATH + currentUser.getEmail() + File.separator + oldTitle + File.separator;
			String newFilePath = User.STORAGE_PATH + currentUser.getEmail() + File.separator + newTitle + File.separator;
			File oldFolder =new File(filePath);
			if(oldFolder.isDirectory()){
				oldFolder.renameTo(new File(newFilePath));
			}else{
				oldFolder.mkdir();	
				oldFolder.renameTo(new File(newFilePath));
			}
			
			IAlbumDAO.getAlbumDAO().getAlbumById(albumId).setTitle(newTitle);

			Iterator<Album> it = currentUser.getAlbums().iterator();

			Album toRename = null;
			while (it.hasNext()) {
				toRename = it.next();
				if (toRename.getId() == albumId) {
					break;
				}
			}
			toRename.setTitle(newTitle);
		}
		return "redirect:/album";
	}

}
