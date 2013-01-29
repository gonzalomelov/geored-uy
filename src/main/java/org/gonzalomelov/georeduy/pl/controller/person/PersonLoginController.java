package org.gonzalomelov.georeduy.pl.controller.person;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.gonzalomelov.georeduy.bll.interfaces.PersonServices;
import org.gonzalomelov.georeduy.dal.model.Person;

@ManagedBean
@RequestScoped
public class PersonLoginController {
	
	private Person person = new Person();
	
	@ManagedProperty(value="#{personSessionManagementController}")
	private PersonSessionManagementController personSessionManagementController;
	
	@EJB(name="personServices")
	private PersonServices personServices;
		
	//Getters and Setters
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public PersonSessionManagementController getPersonSessionManagementController() {
		return personSessionManagementController;
	}

	public void setPersonSessionManagementController(PersonSessionManagementController personSessionManagementController) {
		this.personSessionManagementController = personSessionManagementController;
	}

	//Functions
	public String loginPerson(){
		if (!personServices.validatePerson(person)) {
			//Message: User Not Registered
			return "/index";
		}
		
		try {
			Person loggedPerson = personServices.login(person);
			personSessionManagementController.loginPerson(loggedPerson);
			return "/index";
		}
		catch (Exception e){
			//Message: e.getMessage();
			return "/index";
		}
	}
	
	public String logoutPerson(){
		try {
			Person loggedPerson = personSessionManagementController.getPerson();
			personServices.logout(loggedPerson);
			personSessionManagementController.logoutPerson();
			return "/index";
		}
		catch (Exception e){
			//Message: e.getMessage();
			return "/index";
		}
	}
	
}
