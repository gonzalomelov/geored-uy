package org.gonzalomelov.georeduy.dal.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
	
	private String description;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="image_id")
	private Image logo;
	
	@ManyToOne
	@NotNull
	private AdminCompany adminCompany;
	
	@OneToMany(mappedBy="company", cascade=CascadeType.ALL)
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

	public Image getLogo() {
		return logo;
	}

	public void setLogo(Image logo) {
		this.logo = logo;
	}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Company)) {
			return false;
		}
		Company other = (Company) obj;
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", adminCompany="
				+ adminCompany + "]";
	}
	
	
}
