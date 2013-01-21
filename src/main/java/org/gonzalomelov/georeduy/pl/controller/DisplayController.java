package org.gonzalomelov.georeduy.pl.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.gonzalomelov.georeduy.dal.model.AdminCompany;
import org.gonzalomelov.georeduy.dal.model.SuperAdmin;
import org.gonzalomelov.georeduy.dal.model.User;

@ManagedBean
@RequestScoped
public class DisplayController {

	@ManagedProperty(value="#{personSessionManagementController}")
	private PersonSessionManagementController personSessionManagementController;
	
	//Getters and Setters
	public PersonSessionManagementController getPersonSessionManagementController() {
		return personSessionManagementController;
	}

	public void setPersonSessionManagementController(
			PersonSessionManagementController personSessionManagementController) {
		this.personSessionManagementController = personSessionManagementController;
	}

	//Functions
	public boolean isUserLogged(){
		return personSessionManagementController.isPersonLogged() &&
			personSessionManagementController.getPerson() instanceof User;
	}
	
	public boolean isSuperAdminLogged(){
		return personSessionManagementController.isPersonLogged() &&
			personSessionManagementController.getPerson() instanceof SuperAdmin;
	}
	
	public boolean isAdminCompanyLogged(){
		return personSessionManagementController.isPersonLogged() &&
			personSessionManagementController.getPerson() instanceof AdminCompany;
	}
}
