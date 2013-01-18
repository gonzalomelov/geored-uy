package org.gonzalomelov.georeduy.controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.gonzalomelov.georeduy.model.User;
import org.gonzalomelov.georeduy.service.UserBean;

@ManagedBean
@RequestScoped
public class LoginController {
	
	private User user = new User();
	
	@ManagedProperty(value="#{userManagementController}")
	private UserManagementController userManagementController;
	
	@EJB
	private UserBean userBean;
		
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
	public String loginUser(){
		if (userBean.validateUser(user)){
			userManagementController.loginUser(user);
		} else {
			//throw Exception
		}
		return "/index";
	}
	
	public String logoutUser(){
		userManagementController.logoutUser();
		return "/index";
	}
	
	public boolean isUserLogged(){
		return userManagementController.isUserLogged();
	}
	
	public String getUserLoggedEmail(){
		return this.userManagementController.getUser().getEmail();
	}
	
}