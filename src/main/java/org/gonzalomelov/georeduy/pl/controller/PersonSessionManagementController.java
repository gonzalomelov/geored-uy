package org.gonzalomelov.georeduy.pl.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.gonzalomelov.georeduy.dal.model.Person;

@ManagedBean(name="personSessionManagementController")
@SessionScoped
public class PersonSessionManagementController {
	private Person person = null;
	
	//Getters and Setters
	public Person getPerson(){
		return person;
	}
	
	public void setPerson(Person person){
		this.person = person;
	}
	
	//Functions
	public void loginPerson(Person person){
		this.person = person;
	}
	
	public void logoutPerson(){
		this.person = null;
	}
	
	public boolean isPersonLogged(){
		return person != null;
	}
	
}