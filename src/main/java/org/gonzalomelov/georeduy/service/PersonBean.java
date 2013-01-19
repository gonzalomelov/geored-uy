package org.gonzalomelov.georeduy.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.gonzalomelov.georeduy.dal.dao.JPAPersonDAO;
import org.gonzalomelov.georeduy.dal.dao.PersonDAO;
import org.gonzalomelov.georeduy.dal.model.Person;

@Stateless
public class PersonBean {
	@PersistenceContext
	public EntityManager em;
	
	private PersonDAO personDAO = new JPAPersonDAO();
	
	public void registerPerson(Person person){
        personDAO.insert(person);
	}
	
	/**
	 * 
	 * @param person: Person object with email and password setted
	 * @return Null if its an invalid person, or the person if it is valid
	 */
	public Person validatePerson(Person person){
		return personDAO.findByEmailAndPassword(person.getEmail(), person.getPassword());
	}
	
	
}