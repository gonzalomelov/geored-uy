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

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotBlank;

import com.vividsolutions.jts.geom.Point;

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
	
	@Column(columnDefinition="Geometry")
	@Type(type="org.hibernate.spatial.GeometryType")
	private Point geom;
	
	@ManyToOne
	@NotNull
	private Company company;
	
	@OneToMany(mappedBy="location")
	private List<Offer> offers = new ArrayList<Offer>();

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

	public Point getGeom() {
		return geom;
	}

	public void setGeom(Point geom) {
		this.geom = geom;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
}
