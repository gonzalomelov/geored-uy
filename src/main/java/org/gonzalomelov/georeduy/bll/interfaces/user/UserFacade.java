package org.gonzalomelov.georeduy.bll.interfaces.user;

import java.util.List;

import org.gonzalomelov.georeduy.dal.model.CheckIn;
import org.gonzalomelov.georeduy.dal.model.Location;
import org.gonzalomelov.georeduy.dal.model.NotificationType;
import org.gonzalomelov.georeduy.dal.model.Offer;
import org.gonzalomelov.georeduy.dal.model.OfferEvaluation;
import org.gonzalomelov.georeduy.dal.model.SiteOfInterest;
import org.gonzalomelov.georeduy.dal.model.SiteOfInterestContent;
import org.gonzalomelov.georeduy.dal.model.User;
import org.joda.time.DateTime;

public interface UserFacade {

	//####
	//User
	//####
	public void registerUser(User user);
	public void loginUser(String email, String password);
	
	//###################
	//Thematic Categories
	//###################
	public void addThematicCategoryToUser(Long userId, Long thematicCategoryId);
	public void removeThematicCategoryFromUser(Long userId, Long thematicCategoryId);
	
	//#############
	//Notifications
	//#############
	public void addNotificationTypeToUser(Long userId, NotificationType notificationType);
	public void removeNotificationTypeFromUser(Long userId, NotificationType notificationType);
	
	//########
	//Contacts
	//########
	public List<User> findAllRegisteredUsers(Long userId);
	public void addContact(Long userId, Long contactId);
	public void removeContact(Long userId, Long contactId);
	public List<User> findAllLoggedInUsers();
	
	//###############
	//SitesOfInterest
	//###############
	public List<SiteOfInterest> findAllClosestSitesOfInterestFromUser(Long userId);
	public void checkInSiteOfInterest(Long siteOfInterestId, Long userId, DateTime dateTime);
	public List<CheckIn> findAllClosestCheckInsFromUser(Long userId);
	public void shareContentFromSiteOfInterest(Long siteOfInterestId, Long userId, SiteOfInterestContent content);
	
	//#########
	//Locations
	//#########
	public List<Location> findAllClosestLocationsFromUser(Long userId);
	public List<Offer> findAllClosestOffersFromUser(Long userId);
	
	//######
	//Offers
	//######
	public void buyOffer(Long companyId, Long locationId, Long offerId, Long userId);
	public void evaluateOffer(Long companyId, Long locationId, Long offerId, Long userId, OfferEvaluation evaluation);
	
	//####
	//Chat
	//####
	public void initConversationWithContact(Long userId, Long contactId);
	public void sendMessageToContact(Long userId, Long contactId, String message);
	
}
