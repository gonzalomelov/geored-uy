package org.gonzalomelov.georeduy.controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.gonzalomelov.georeduy.model.User;
import org.gonzalomelov.georeduy.service.UserBean;

@ManagedBean
@RequestScoped
public class RegisterUserController {
	
	public User user = new User();
	
	@ManagedProperty(value="#{userManagementController}")
	public UserManagementController userManagementController;
	
	@EJB
	public UserBean userBean;

	//Getters and Setters
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserManagementController getUserManagementController() {
		return userManagementController;
	}

	public void setUserManagementController(UserManagementController userManagementController) {
		this.userManagementController = userManagementController;
	}

	//Functions
	public String registerUser(){
		userBean.registerUser(user);
		userManagementController.loginUser(user);
		return "/index"; 
	}
}