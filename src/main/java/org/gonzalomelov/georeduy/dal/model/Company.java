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
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotBlank;

@XmlRootElement(name = "company")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class Company implements Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1937063341367098363L;

	private Long id;
	private String name; 
	private String description;
	private Image logo;
	private AdminCompany adminCompany;
	private Map<String, Location> locations = new HashMap<String, Location>();

	//Getters and Setters
	@XmlAttribute(name = "id")
	@Id
	@GeneratedValue 
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@XmlElement(name = "name")
	@NotBlank
	@Column(unique=true)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlElement(name = "description") 
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@XmlElement(name="logo")	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="image_id")
	public Image getLogo() {
		return logo;
	}

	public void setLogo(Image logo) {
		this.logo = logo;
	}

	@XmlElement(name = "company-administrator")
	@ManyToOne
	@NotNull
	public AdminCompany getAdminCompany() {
		return adminCompany;
	}

	public void setAdminCompany(AdminCompany adminCompany) {
		this.adminCompany = adminCompany;
	}
	
	@XmlElementWrapper(name = "locations")
	@XmlElement(name = "location")
	@OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
	@MapKey(name="name")
	@NotNull
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
