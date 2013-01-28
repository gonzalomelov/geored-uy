package org.gonzalomelov.georeduy.dal.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.joda.time.DateTime;

@Entity
public class CheckIn implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -2812068921938707426L;

	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	private DateTime checkInDateTime;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private SiteOfInterest siteOfInterest;
	
	@OneToMany
	private List<SiteOfInterestContent> sharedInfo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DateTime getCheckInDateTime() {
		return checkInDateTime;
	}

	public void setCheckInDateTime(DateTime checkInDateTime) {
		this.checkInDateTime = checkInDateTime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public SiteOfInterest getSiteOfInterest() {
		return siteOfInterest;
	}

	public void setSiteOfInterest(SiteOfInterest siteOfInterest) {
		this.siteOfInterest = siteOfInterest;
	}

	public List<SiteOfInterestContent> getSharedInfo() {
		return sharedInfo;
	}

	public void setSharedInfo(List<SiteOfInterestContent> sharedInfo) {
		this.sharedInfo = sharedInfo;
	}
	
	
}
