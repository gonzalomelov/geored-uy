package org.gonzalomelov.georeduy.bll.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.gonzalomelov.georeduy.dal.dao.interfaces.PersonDAO;
import org.gonzalomelov.georeduy.dal.model.Person;

@Stateless
public class PersonBean {
	
	@Inject
	private PersonDAO personDAO;
	
	public void registerPerson(Person person){
        personDAO.insert(person);
	}
	
	/**
	 * 
	 * @param person: Person object with email and password setted
	 * @return Null if its an invalid person, or the person if it is valid
	 */
	public Person validatePerson(Person person){
		Person p = personDAO.findByEmailAndPassword(person.getEmail(), person.getPassword()); 
		return p;
	}
	
	
}