package com.facebook.controllers.posts;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.facebook.DAO.IAlbumDAO;
import com.facebook.DAO.IPostDAO;
import com.facebook.POJO.*;
import com.facebook.exceptions.UploadException;

@Controller
@RequestMapping(value = "/PostUpload")
public class PostUpload {
	private static final int BUFFER_SIZE = 1024 * 1024;
	private static final String PICTURE_FOLDER = "PostPictures";
	private String postText;
	
	@RequestMapping(method = RequestMethod.POST)
	public String uploadPost(Model model, HttpServletRequest request) {
		User currentUser = (User) request.getSession().getAttribute("currentUser");
		String filePath = User.STORAGE_PATH + currentUser.getEmail() + File.separator + PICTURE_FOLDER + File.separator;
		new File(filePath).mkdirs();
		// Check that we have a file upload request
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		
		String currentPage = request.getHeader("referer");
		currentPage = currentPage.substring(currentPage.lastIndexOf("/"));

		if (isMultipart) {
			Album album = IAlbumDAO.getAlbumDAO().getAlbum(currentUser, PICTURE_FOLDER);
			if (album == null) {
				album = new Album(PICTURE_FOLDER, currentUser);
				IAlbumDAO.getAlbumDAO().insertAlbum(currentUser, album);
			}
			
			String picName = null;
			try {
				picName = uploadPic(request, filePath, album);
			} catch (UploadException e) {
				return "redirect:" + currentPage;
			} catch (Exception e) {
				request.setAttribute("imageError", "Error uploading image.");
				return "redirect:" + currentPage;
			} 
			
			Picture postPicture = new Picture(picName);
			album.addPicture(postPicture);
			IAlbumDAO.getAlbumDAO().uploadImage(postPicture, album);

			Post p = new Post(currentUser, postPicture, this.postText);
			IPostDAO.getPostDAO().insertPost(p);
			currentUser.addPost(p);
		}
				
		model.addAttribute("posts", currentUser.getPosts());
		
		return "redirect:" + currentPage;
	}

	public String uploadPic(HttpServletRequest request, String filePath, Album album) throws Exception   {
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// maximum size that will be stored in memory
		factory.setSizeThreshold(BUFFER_SIZE);
		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);
		// maximum file size to be uploaded.
		upload.setSizeMax(BUFFER_SIZE);

		// Parse the request to get file items.
		List<FileItem> fileItems = upload.parseRequest(request);
		// Process the uploaded file items
		Iterator<FileItem> i = fileItems.iterator();
		File file = null;

		while (i.hasNext()) {
			FileItem item = (FileItem) i.next();
			if (!item.isFormField()) {
				// Get the uploaded file parameters
				String fileName = item.getName();
				String extension = FilenameUtils.getExtension(fileName);

				boolean isImage = extension.equals("gif") || extension.equals("jpg") || extension.equals("png");
				if(item.getSize()==0){
					return null;
				}
				if (!isImage || item.getSize() > BUFFER_SIZE) {
					request.setAttribute("imageError", "File must be an image with size less than 1 MB.");
					throw new UploadException();
				}
				// Write the file
				file = new File(filePath + "post-pic" + (album.getPictures().size() + 1) + "." + extension);
				item.write(file);
			} else {
				this.postText = item.getString();
			}
		}
		return file.getName();
	}
}
