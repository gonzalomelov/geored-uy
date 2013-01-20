package org.gonzalomelov.georeduy.pl.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.gonzalomelov.georeduy.pl.model.PersonType; 

@ManagedBean
@RequestScoped
public class PersonTypeRegister {
	public PersonType[] getPersonTypes(){
		return PersonType.values();
	}
}
