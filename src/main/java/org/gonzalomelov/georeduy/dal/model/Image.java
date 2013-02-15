package org.gonzalomelov.georeduy.dal.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Image implements Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -6129917358769786439L;

	@Id
	@GeneratedValue
	private Long id;
	
	@Lob 
	@NotEmpty
	private byte[] image;
	
	private String name; 
	
	private String description;

	//Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
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
}
