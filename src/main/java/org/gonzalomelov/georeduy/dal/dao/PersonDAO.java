package org.gonzalomelov.georeduy.dal.dao;

import org.gonzalomelov.georeduy.dal.model.Person;

public interface PersonDAO extends GenericDAO<Person>{
	/**
	 * @return Returns the person if it was founded.
	 * If 0 or more results returns null.
	 * Important: Doesn't check if there are more results
	 */
	public Person findByEmailAndPassword(String email, String password);
}
