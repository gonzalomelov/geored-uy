package org.gonzalomelov.georeduy.dal.model;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlTransient;

@XmlTransient
@Entity
public class Admin extends Person {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 3884212903390410358L;

	public Admin(){
		super();
	}
	
	public Admin(String email, String password, String name, String lastname){
		super(email, password, name, lastname);
	}
}
