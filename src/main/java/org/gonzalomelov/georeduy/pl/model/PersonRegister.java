package org.gonzalomelov.georeduy.pl.model;

import org.gonzalomelov.georeduy.dal.model.Person;

public class PersonRegister {
	private Person person = new Person();
	private PersonType personType;
	
	public PersonRegister(){}

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
	
	
}
