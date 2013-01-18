package org.gonzalomelov.georeduy.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.gonzalomelov.georeduy.model.User;

@ManagedBean
@SessionScoped
public class UserManagementController {
	private User user = new User();
	private boolean userLogged = false;
	
	//Getters and Setters
	public User getUser(){
		return user;
	}
	
	public void setUser(User user){
		this.user = user;
	}
	
	//Functions
	public void loginUser(User user){
		this.user = user;
		this.userLogged = true;
	}
	
	public void logoutUser(){
		this.user = new User();
		this.userLogged = false;
	}
	
	public boolean isUserLogged(){
		return userLogged;
	}
	
	
}