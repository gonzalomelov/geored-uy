package org.gonzalomelov.georeduy.pl.controller.person;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.gonzalomelov.georeduy.bll.service.person.PersonBean;
import org.gonzalomelov.georeduy.dal.model.AdminCompany;
import org.gonzalomelov.georeduy.dal.model.Person;
import org.gonzalomelov.georeduy.dal.model.SuperAdmin;
import org.gonzalomelov.georeduy.dal.model.User;
import org.gonzalomelov.georeduy.pl.model.person.PersonType;

@ManagedBean
@RequestScoped
public class PersonRegisterController {
	
	private Person person = new Person();

	private PersonType personType;

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

	public PersonType getPersonType() {
		return personType;
	}

	public void setPersonType(PersonType personType) {
		this.personType = personType;
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
		Person registerPerson = null;
		
		//Registered depend of personBean type
		switch (personType) {
		case ADMINCOMPANY:
			registerPerson = new AdminCompany(person.getEmail(),person.getPassword(), person.getName(),person.getLastname());
			break;
			
		case USER:
			registerPerson = new User(person.getEmail(),person.getPassword(), person.getName(),person.getLastname());
			break;
			
		case SUPERADMIN:
			registerPerson = new SuperAdmin(person.getEmail(),person.getPassword(), person.getName(),person.getLastname());
			break;
			
		default:
			return "/index";
		}
		
		//Registry
		personBean.registerPerson(registerPerson);
		//Loggin
		personSessionManagementController.loginPerson(registerPerson);
		
		return "/index";
	}
	
	public PersonType[] getPersonTypes(){
		return PersonType.values();
	}
}
