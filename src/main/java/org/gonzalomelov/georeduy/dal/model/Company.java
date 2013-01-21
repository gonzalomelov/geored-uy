package org.gonzalomelov.georeduy.dal.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;


@Entity
public class Company implements Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1937063341367098363L;

	@Id
	@GeneratedValue 
	private Long id;
	
	@NotBlank
	@Column(unique=true)
	private String name; 
	
	@NotNull
	private String description;
	
	//@NotNull
	//private Image logo;
	
	@ManyToOne
	@NotNull
	private AdminCompany adminCompany;
	
	@OneToMany(mappedBy="company")
	@MapKey(name="name")
	@NotNull
	private Map<String, Location> locations = new HashMap<String, Location>();

	
	//Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

//	public Image getLogo() {
//		return logo;
//	}
//
//	public void setLogo(Image logo) {
//		this.logo = logo;
//	}

	public AdminCompany getAdminCompany() {
		return adminCompany;
	}

	public void setAdminCompany(AdminCompany adminCompany) {
		this.adminCompany = adminCompany;
	}

	public Map<String, Location> getLocations() {
		return locations;
	}

	public void setLocations(Map<String, Location> locations) {
		this.locations = locations;
	}
}
