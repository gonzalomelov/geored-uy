package org.gonzalomelov.georeduy.dal.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

@Entity
public class OfferEvaluation implements Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -1644183284559692372L;
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotEmpty
	private String title;
	
	@NotEmpty
	private String comment;
	
	@Range(min=0,max=5)
	private int stars;
	
	@NotNull 
	@ManyToOne
	private User user;
	
	@NotNull
	@ManyToOne
	private Offer offer;
	
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
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getStars() {
		return stars;
	}
	public void setStars(int stars) {
		this.stars = stars;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Offer getOffer() {
		return offer;
	}
	public void setOffer(Offer offer) {
		this.offer = offer;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((offer == null) ? 0 : offer.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		if (!(obj instanceof OfferEvaluation)) {
			return false;
		}
		OfferEvaluation other = (OfferEvaluation) obj;
		if (offer == null) {
			if (other.offer != null) {
				return false;
			}
		} else if (!offer.equals(other.offer)) {
			return false;
		}
		if (user == null) {
			if (other.user != null) {
				return false;
			}
		} else if (!user.equals(other.user)) {
			return false;
		}
		return true;
	}
	
	
	
}
