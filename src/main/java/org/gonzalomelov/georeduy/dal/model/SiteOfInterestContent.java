package org.gonzalomelov.georeduy.dal.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class SiteOfInterestContent implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 4954471072201977658L;

	@Id
	@GeneratedValue
	private Long id;
	
	@NotEmpty
	private String title;
	
	@Enumerated
	private InfoType type;
	
	private String comment;
	
	private byte[] video;
	
	private String url;

	@OneToOne
	private Image image;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public InfoType getType() {
		return type;
	}

	public void setType(InfoType type) {
		this.type = type;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public byte[] getVideo() {
		return video;
	}

	public void setVideo(byte[] video) {
		this.video = video;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}
