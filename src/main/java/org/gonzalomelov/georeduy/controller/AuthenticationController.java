package org.gonzalomelov.georeduy.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.gonzalomelov.georeduy.model.User;

@ManagedBean
@RequestScoped
public class AuthenticationController {
	
	@ManagedProperty(value = "#{loginController}")
	private LoginController loginController;
	
	@EJB
	private UserBean userBean;
	
	public void login(String username, String password){
		
	}
	
	public void logout(String username, String password){
		
	}
	
}