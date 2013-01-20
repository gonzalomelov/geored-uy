package org.gonzalomelov.georeduy.dal.model;

import javax.persistence.Entity;

@Entity
public class User extends Person {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 7713381454732902430L;

	public User(){
		super();
	}
	
	public User(String email, String password, String name, String lastname){
		super(email, password, name, lastname);
	}
}