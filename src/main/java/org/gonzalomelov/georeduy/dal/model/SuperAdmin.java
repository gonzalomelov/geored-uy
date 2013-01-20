package org.gonzalomelov.georeduy.dal.model;

import javax.persistence.Entity;

@Entity
public class SuperAdmin extends Admin {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 7238397782248429744L;
	
	public SuperAdmin(){
		super();
	}
	
	public SuperAdmin(String email, String password, String name, String lastname){
		super(email, password, name, lastname);
	}

}
