//package com.facebook.controllers;
//
//import java.io.File; 
//import java.io.IOException;
//import java.util.Iterator;
//import java.util.List;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.*;
//
//import org.apache.commons.fileupload.FileItem;
//import org.apache.commons.fileupload.disk.DiskFileItemFactory;
//import org.apache.commons.fileupload.servlet.ServletFileUpload;
//import org.apache.commons.io.FilenameUtils;
//
//import com.facebook.DAO.IUserDAO;
//import com.facebook.POJO.User;
//
//
///**
// * Servlet implementation class UploadImageServlet
// */
//@WebServlet("/ImageUpload")
//public class ImageUpload extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	private static final int BUFFER_SIZE = 1024 * 1024;
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		HttpSession session = request.getSession();
//
//		if (session != null && session.getAttribute("user") != null) {
//
//			User user = (User) session.getAttribute("user");
//
//			String filePath = User.STORAGE_PATH + File.separator + user.getEmail() + File.separator;
//
//			// Check that we have a file upload request
//			boolean isMultipart = ServletFileUpload.isMultipartContent(request);
//			if (isMultipart) {
//				DiskFileItemFactory factory = new DiskFileItemFactory();
//
//				// maximum size that will be stored in memory
//				factory.setSizeThreshold(BUFFER_SIZE);
//				// Location to save data that is larger than maxMemSize.
//				factory.setRepository(new File(filePath));
//
//				// Create a new file upload handler
//				ServletFileUpload upload = new ServletFileUpload(factory);
//				// maximum file size to be uploaded.
//				upload.setSizeMax(BUFFER_SIZE);
//				
//				String fileName;
//				try {
//					fileName = createFile(upload, filePath, request, response);
//					IUserDAO.getUserDAO().addProfileImage(user.getId(), filePath + fileName);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		}
//	}
//
//	public String createFile(ServletFileUpload upload, String filePath, HttpServletRequest request,
//			HttpServletResponse response) throws Exception {
//		// Parse the request to get file items.
//		List fileItems = upload.parseRequest(request);
//		// Process the uploaded file items
//		Iterator i = fileItems.iterator();
//		File file = null;
//
//		while (i.hasNext()) {
//			FileItem fi = (FileItem) i.next();
//
//			if (!fi.isFormField()) {
//				// Get the uploaded file parameters
//				String fileName = fi.getName();
//				String extension = FilenameUtils.getExtension(fileName);
//
//				boolean isImage = extension.equals("gif") ||  extension.equals("jpg")||
//						 extension.equals("png");
//				if (!isImage || fi.getSize() > BUFFER_SIZE) {
//					request.setAttribute("imageError", "File must be an image with size less than " 
//							+ BUFFER_SIZE + "bytes.");
//					request.getRequestDispatcher("./successfulRegistration.jsp").forward(request, response);
//				}
//				// Write the file
//
//				file = new File(filePath + "profile_pic." + extension);
//				fi.write(file);
//			}
//		}
//		return file.getName();
//	}
//}