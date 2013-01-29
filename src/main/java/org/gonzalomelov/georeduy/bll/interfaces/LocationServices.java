package org.gonzalomelov.georeduy.bll.interfaces;

import java.util.List;

import org.gonzalomelov.georeduy.dal.model.Location;
import org.gonzalomelov.georeduy.dal.model.Offer;
import org.gonzalomelov.georeduy.dal.model.OfferEvaluation;

public interface LocationServices {
	//AdminCompany
	public Location addLocation(Long companyId, Location location);
	public void removeLocation(Long companyId, Long idLocation);
	public Location updateLocation(Long companyId, Location location);
	public Location findLocationById(Long companyId, Long idLocation);
	public List<Location> findAllLocationsFromCompany(Long companyId);
	
	//User
	public List<Location> findAllClosestLocationsFromUser(Long userId);
	public List<Offer> findAllClosestOffersFromUser(Long userId);
	public void buyOffer(Long companyId, Long locationId, Long offerId, Long userId);
	public void evaluateOffer(Long companyId, Long locationId, Long offerId, Long userId, OfferEvaluation evaluation);
}
