package org.gonzalomelov.georeduy.controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.gonzalomelov.georeduy.dal.model.Person;
import org.gonzalomelov.georeduy.service.PersonBean;

@ManagedBean
@RequestScoped
public class PersonLoginController {
	
	private Person person = null; 
	
	@ManagedProperty(value="#{personSessionManagementController}")
	private PersonSessionManagementController personSessionManagementController;
	
	@EJB
	private PersonBean personBean;
		
	//Getters and Setters
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public PersonSessionManagementController getPersonManagementController() {
		return personSessionManagementController;
	}

	public void setPersonManagementController(PersonSessionManagementController personSessionManagementController) {
		this.personSessionManagementController = personSessionManagementController;
	}

	//Functions
	public String loginPerson(){
		Person loggedPerson = personBean.validatePerson(person);
		if (loggedPerson != null){ 
			personSessionManagementController.loginPerson(loggedPerson);
		} else {
			//throw Exception
		}
		return "/index";
	}
	
	public String logoutPerson(){
		personSessionManagementController.logoutPerson();
		return "/index";
	}
	
	public boolean isPersonLogged(){
		return personSessionManagementController.isPersonLogged();
	}
	
	public String getPersonLoggedEmail(){
		return personSessionManagementController.getPerson().getEmail();
	}
	
}