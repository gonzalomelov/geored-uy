package org.gonzalomelov.georeduy.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.gonzalomelov.georeduy.model.User;

@ManagedBean(name="loginController")
@SessionScoped
public class LoginController {
	private User user = null;
	
	public void setUser(User user){
		this.user = user;
	}
	
	public void unsetUser(){
		this.user = null;
	}
	
	public boolean isUser(){
		return user != null;
	}
	
}