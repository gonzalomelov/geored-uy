package org.gonzalomelov.georeduy.dal.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Offer extends Notice {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -7367581800674098962L;
	
	@NotNull
	private Double cost;
	
	@NotNull
	@ManyToOne
	private Location location;

	@OneToMany(mappedBy="offer")
	private List<OfferEvaluation> evaluations = new ArrayList<OfferEvaluation>();
	
	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public List<OfferEvaluation> getEvaluations() {
		return evaluations;
	}

	public void setEvaluations(List<OfferEvaluation> evaluations) {
		this.evaluations = evaluations;
	}
	
}
