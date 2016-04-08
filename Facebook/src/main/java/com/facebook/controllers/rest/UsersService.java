package com.facebook.controllers.rest;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.facebook.DAO.IUserDAO;
import com.facebook.POJO.User;

@RestController
public class UsersService {
	@RequestMapping(value = "/allUsers", method = RequestMethod.GET)
	List<User> getUsers() {
		return IUserDAO.getUserDAO().getAllUsers();
	}

	@RequestMapping(value ="/allUsers/{id}", method = RequestMethod.GET)
	User getUser(@PathVariable("id") Integer userId){
		return IUserDAO.getUserDAO().getUserById(userId);
	}

}
