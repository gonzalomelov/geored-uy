package org.gonzalomelov.georeduy.dal.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;

@Entity
public class User extends Person {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 7713381454732902430L;

	@OneToMany
	private List<User> contacts = new ArrayList<User>();
	
	@OneToMany
	private List<ThematicCategory> interestedThematicCategories = new ArrayList<ThematicCategory>();
	
	@OneToMany(mappedBy="user")
	private List<CheckIn> checkIns = new ArrayList<CheckIn>();
	
	@OneToMany(mappedBy="user")
	private List<OfferEvaluation> offersBought = new ArrayList<OfferEvaluation>();
	
	@ElementCollection(targetClass = NotificationType.class)
	@Enumerated(EnumType.STRING)
	private List<NotificationType> interestedNotificationTypes = new ArrayList<NotificationType>();
	
	public User(){
		super();
	}
	
	public User(String email, String password, String name, String lastname){
		super(email, password, name, lastname);
	}

	public List<User> getContacts() {
		return contacts;
	}

	public void setContacts(List<User> contacts) {
		this.contacts = contacts;
	}

	public List<ThematicCategory> getInterestedThematicCategories() {
		return interestedThematicCategories;
	}

	public void setInterestedThematicCategories(
			List<ThematicCategory> interestedThematicCategories) {
		this.interestedThematicCategories = interestedThematicCategories;
	}

	public List<CheckIn> getCheckIns() {
		return checkIns;
	}

	public void setCheckIns(List<CheckIn> checkIns) {
		this.checkIns = checkIns;
	}

	public List<OfferEvaluation> getOffersBought() {
		return offersBought;
	}

	public void setOffersBought(List<OfferEvaluation> offersBought) {
		this.offersBought = offersBought;
	}

	public List<NotificationType> getInterestedNotificationTypes() {
		return interestedNotificationTypes;
	}

	public void setInterestedNotificationTypes(
			List<NotificationType> interestedNotificationTypes) {
		this.interestedNotificationTypes = interestedNotificationTypes;
	}
	
	
}