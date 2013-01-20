package org.gonzalomelov.georeduy.dal.model;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class AdminCompany extends Admin {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -9154075823425265218L;
	
	@OneToMany(mappedBy="adminCompany")
	@MapKey(name = "name")
	@NotNull
	private Map<String, Company> companies = new HashMap<String,Company>();

	public AdminCompany(){
		super();
	}
	
	public AdminCompany(String email, String password, String name, String lastname){
		super(email, password, name, lastname);
	}
	
	//Getters and Setters
	public Map<String, Company> getCompanies() {
		return companies;
	}

	public void setCompanies(Map<String, Company> companies) {
		this.companies = companies;
	}
}
