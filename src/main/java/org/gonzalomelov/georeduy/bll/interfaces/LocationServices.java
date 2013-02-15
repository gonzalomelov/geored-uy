package org.gonzalomelov.georeduy.bll.interfaces;

import java.util.List;

import org.gonzalomelov.georeduy.dal.model.Location;
import org.gonzalomelov.georeduy.dal.model.Offer;
import org.gonzalomelov.georeduy.dal.model.OfferEvaluation;

public interface LocationServices {
	//AdminCompany
	
	/**
	 * 
	 * @param companyId Company Id to add a Location
	 * @param location Location to be added
	 * @return Location added
	 * @throws Exception Company doesn't exists. 
	 */
	public Location addLocation(Long companyId, String name, Double coordX, Double coordY) throws Exception;
	
	/**
	 * 
	 * @param companyId Company Id to remove the Location
	 * @param locationId Location Id which will be removed
	 */
	public void removeLocation(Long companyId, Long locationId) throws Exception;
	
	/**
	 * 
	 * @param companyId Company Id for the Company Location to be updated
	 * @param location Updated Location
	 * @return Updated Location
	 */
	public Location updateLocation(Long companyId, Location location) throws Exception;
	
	/**
	 * 
	 * @param companyId Company Id of the Location retrieved
	 * @param locationId Location Id of the Location retrieved
	 * @return Location with the id locationId of the Company companyId 
	 */
	public Location findLocationById(Long companyId, Long locationId) throws Exception;
	
	/**
	 * 
	 * @param companyId Company Id of the returned Locations
	 * @return Locations of the Company companyId
	 */
	public List<Location> findAllLocationsFromCompany(Long companyId) throws Exception;
	
	//User
	public List<Location> findAllClosestLocationsFromUser(Long userId);
	public List<Offer> findAllClosestOffersFromUser(Long userId);
	public void buyOffer(Long companyId, Long locationId, Long offerId, Long userId);
	public void evaluateOffer(Long companyId, Long locationId, Long offerId, Long userId, OfferEvaluation evaluation);
}
