package org.gonzalomelov.georeduy.controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.gonzalomelov.georeduy.dal.model.Person;
import org.gonzalomelov.georeduy.service.PersonBean;

@ManagedBean
@RequestScoped
public class PersonRegisterController {
	
	public Person person = null;
	
	@ManagedProperty(value="#{personSessionManagementController}")
	public PersonSessionManagementController personSessionManagementController;
	
	@EJB
	public PersonBean personBean;

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
	public String registerPerson(){
		personBean.registerPerson(person);
		personSessionManagementController.loginPerson(person);
		return "/index"; 
	}
}