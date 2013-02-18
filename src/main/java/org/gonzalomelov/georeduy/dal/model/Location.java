package org.gonzalomelov.georeduy.dal.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotBlank;

import com.vividsolutions.jts.geom.Point;

@XmlRootElement(name = "location")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class Location implements Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 2984706492450727628L;

	private Long id;
	private String name;
	private Point geom;
	private Company company;
	private List<Offer> offers = new ArrayList<Offer>();

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
	
	@XmlElement(name = "geom")
	@Type(type="org.hibernate.spatial.GeometryType")
	public Point getGeom() {
		return geom;
	}

	public void setGeom(Point geom) {
		this.geom = geom;
	}

	@XmlElement(name = "company")
	@ManyToOne
	@NotNull
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
	
	@XmlElementWrapper(name = "offers")
	@XmlElement(name = "offer")
	@OneToMany(mappedBy="location")
	public List<Offer> getOffers() {
		return offers;
	}

	public void setOffers(List<Offer> offers) {
		this.offers = offers;
	}
}
