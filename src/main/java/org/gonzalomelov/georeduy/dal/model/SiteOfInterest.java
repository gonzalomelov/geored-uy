package org.gonzalomelov.georeduy.dal.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;

import com.vividsolutions.jts.geom.Geometry;

@Entity
public class SiteOfInterest implements Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 4050094264760071245L;

	@Id
	@GeneratedValue
	private Long id;
	
	@NotEmpty
	private String name;
	
	@NotEmpty
	private String description;
	
	@NotNull
	@Type(type="org.hibernate.spatial.GeometryType")
	private Geometry geolocation;
	
	@OneToMany(mappedBy="siteOfInterest")
	private List<CheckIn> checkIns = new ArrayList<CheckIn>();
	
	@OneToMany
	private List<ThematicCategory> thematicCategories = new ArrayList<ThematicCategory>();
	
	@OneToMany
	private List<Image> images = new ArrayList<Image>();
	
	@OneToMany
	private List<Event> events = new ArrayList<Event>();

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

	public Geometry getGeolocation() {
		return geolocation;
	}

	public void setGeolocation(Geometry geolocation) {
		this.geolocation = geolocation;
	}

	public List<CheckIn> getCheckIns() {
		return checkIns;
	}

	public void setCheckIns(List<CheckIn> checkIns) {
		this.checkIns = checkIns;
	}

	public List<ThematicCategory> getThematicCategories() {
		return thematicCategories;
	}

	public void setThematicCategories(List<ThematicCategory> thematicCategories) {
		this.thematicCategories = thematicCategories;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}
	
}
