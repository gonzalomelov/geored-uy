package org.gonzalomelov.georeduy.pl.controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.gonzalomelov.georeduy.bll.service.PersonBean;
import org.gonzalomelov.georeduy.dal.model.AdminCompany;
import org.gonzalomelov.georeduy.dal.model.Person;
import org.gonzalomelov.georeduy.dal.model.SuperAdmin;
import org.gonzalomelov.georeduy.dal.model.User;
import org.gonzalomelov.georeduy.pl.model.PersonRegister;

@ManagedBean
@RequestScoped
public class PersonRegisterController {
	
	private PersonRegister personRegister = new PersonRegister();
	
	@ManagedProperty(value="#{personSessionManagementController}")
	private PersonSessionManagementController personSessionManagementController;
	
	@EJB
	private PersonBean personBean;

	//Getters and Setters
	public PersonRegister getPersonRegister() {
		return personRegister;
	}

	public void setPersonRegister(PersonRegister personRegister) {
		this.personRegister = personRegister;
	}

	public PersonSessionManagementController getPersonSessionManagementController() {
		return personSessionManagementController;
	}

	public void setPersonSessionManagementController(
			PersonSessionManagementController personSessionManagementController) {
		this.personSessionManagementController = personSessionManagementController;
	}

	//Functions
	public String registerPerson(){
		Person person = null;
		
		//Registered depend of person type
		switch (personRegister.getPersonType()) {
		case ADMINCOMPANY:
			person = new AdminCompany(personRegister.getPerson().getEmail(),personRegister.getPerson().getPassword(),
					personRegister.getPerson().getName(),personRegister.getPerson().getLastname());
			break;
			
		case USER:
			person = new User(personRegister.getPerson().getEmail(),personRegister.getPerson().getPassword(),
					personRegister.getPerson().getName(),personRegister.getPerson().getLastname());
			break;
			
		case SUPERADMIN:
			person = new SuperAdmin(personRegister.getPerson().getEmail(),personRegister.getPerson().getPassword(),
					personRegister.getPerson().getName(),personRegister.getPerson().getLastname());
			break;
			
		default:
			return "/index";
		}
		
		//Registry
		personBean.registerPerson(person);
		//Loggin
		personSessionManagementController.loginPerson(person);
		return "/index";
	}
}