package com.facebook.controllers.albumsAndPictures;
import java.io.File;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.facebook.DAO.IAlbumDAO;
import com.facebook.DAO.IUserDAO;
import com.facebook.POJO.Album;
import com.facebook.POJO.Picture;
import com.facebook.POJO.User;
import com.facebook.POJO.UserInfo;

@Controller

public class AlbumFileUpload{
	private static final int BUFFER_SIZE = 1024 * 1024;

	@RequestMapping(value = "/albumFileUpload/{id}", method = RequestMethod.POST)
	public String uploadImage(@PathVariable(value="id") Integer id, HttpServletRequest request) {
		Album thisAlbum = IAlbumDAO.getAlbumDAO().getAlbumById(id);
		
		
		
		User user = (User) request.getSession().getAttribute("currentUser");

		String filePath = User.STORAGE_PATH + user.getEmail() + File.separator + thisAlbum.getTitle() + File.separator;
		new File(filePath).mkdirs();
		// Check that we have a file upload request
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (isMultipart) {
			String fileName;
			try {
				Album album = IAlbumDAO.getAlbumDAO().getAlbum(user, thisAlbum.getTitle());
				if (album == null) {
					album = new Album(thisAlbum.getTitle(), user);
					IAlbumDAO.getAlbumDAO().insertAlbum(user,album);
				}
				System.err.println("09999999999" + filePath + "req " + request + "album " + album );
				fileName = createFile(request, filePath, album);
				Picture bgPic = new Picture(fileName);
				IAlbumDAO.getAlbumDAO().uploadImage(bgPic, album);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return "redirect:/pictures/" + id;

	}

	public String createFile(HttpServletRequest request, String filePath, Album album) throws Exception {

		DiskFileItemFactory factory = new DiskFileItemFactory();
		// maximum size that will be stored in memory
		factory.setSizeThreshold(BUFFER_SIZE);
		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);
		// maximum file size to be uploaded.
		upload.setSizeMax(BUFFER_SIZE);

		// Parse the request to get file items.
		List fileItems = upload.parseRequest(request);
		// Process the uploaded file items
		Iterator i = fileItems.iterator();
		File file = null;

		while (i.hasNext()) {
			FileItem fi = (FileItem) i.next();

			if (!fi.isFormField()) {
				// Get the uploaded file parameters
				String fileName = fi.getName();
				String extension = FilenameUtils.getExtension(fileName);

				boolean isImage = extension.equals("gif") || extension.equals("jpg") || extension.equals("png");
				if (!isImage || fi.getSize() > BUFFER_SIZE) {
					request.setAttribute("imageError",
							"File must be an image with size less than " + BUFFER_SIZE + " bytes.");
					return "forward:/albums";
				}
				// Write the file
				file = new File(filePath + album.getTitle() + (album.getPictures().size() + 1) + "." + extension);
				fi.write(file);
			}
		}
		return file.getName();
	}
}
