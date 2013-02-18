package org.gonzalomelov.georeduy.dal.model;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "company-administrator")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class AdminCompany extends Admin {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -9154075823425265218L;
	
	private Map<String, Company> companies = new HashMap<String,Company>();

	public AdminCompany(){
		super();
	}
	
	public AdminCompany(String email, String password, String name, String lastname){
		super(email, password, name, lastname);
	}
	
	//Getters and Setters
	@XmlElementWrapper(name = "companies")
	@XmlElement(name = "company")
	@OneToMany(mappedBy = "adminCompany", cascade = CascadeType.ALL)
	@MapKey(name = "name")
	@NotNull
	public Map<String, Company> getCompanies() {
		return companies;
	}

	public void setCompanies(Map<String, Company> companies) {
		this.companies = companies;
	}
}
