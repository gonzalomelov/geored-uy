package org.gonzalomelov.georeduy.dal.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Location implements Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 2984706492450727628L;

	@Id
	@GeneratedValue
	private Long id;
	
	@NotBlank
	@Column(unique=true)
	private String name;
	
//	@NotNull
//	@Type(type="org.hibernate.spatial.GeometryType")
//	private Geometry geom;
	
	@ManyToOne
	@NotNull
	private Company company;

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

//	public Geometry getGeom() {
//		return geom;
//	}
//
//	public void setGeom(Geometry geom) {
//		this.geom = geom;
//	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
}
