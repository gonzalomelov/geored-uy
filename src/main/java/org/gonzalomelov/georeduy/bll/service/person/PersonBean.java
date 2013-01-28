package org.gonzalomelov.georeduy.bll.service.person;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.gonzalomelov.georeduy.dal.dao.interfaces.PersonDAO;
import org.gonzalomelov.georeduy.dal.model.Person;

@Stateless
public class PersonBean {
	
	@Inject
	private PersonDAO personDAO;
	
	public Person registerPerson(Person person){
        try {
        	return personDAO.insert(person);
        }
        catch(Exception e){
        	return null;
        }
        finally {
        	
        }
		
	}
	
	/**
	 * 
	 * @param person: PersonBean object with email and password setted
	 * @return Null if its an invalid person, or the person if it is valid
	 */
	public Person validatePerson(Person person){
		Person p = personDAO.findByEmailAndPassword(person.getEmail(), person.getPassword()); 
		return p;
	}
	
	
}