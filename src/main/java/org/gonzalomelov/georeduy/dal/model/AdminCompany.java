package org.gonzalomelov.georeduy.dal.model;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class AdminCompany extends Admin {
	@OneToMany(mappedBy="adminCompany")
	@MapKey(name = "name")
	@NotNull
	private Map<String, Company> companies = new HashMap<String,Company>();

	//Getters and Setters
	public Map<String, Company> getCompanies() {
		return companies;
	}

	public void setCompanies(Map<String, Company> companies) {
		this.companies = companies;
	}
}
