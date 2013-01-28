package org.gonzalomelov.georeduy.bll.interfaces.user;

import java.util.List;

import org.gonzalomelov.georeduy.dal.model.Location;
import org.gonzalomelov.georeduy.dal.model.Offer;
import org.gonzalomelov.georeduy.dal.model.OfferEvaluation;

public interface LocationServices {
	
	public List<Location> findAllClosestLocationsFromUser(Long userId);
	public List<Offer> findAllClosestOffersFromUser(Long userId);
	public void buyOffer(Long companyId, Long locationId, Long offerId, Long userId);
	public void evaluateOffer(Long companyId, Long locationId, Long offerId, Long userId, OfferEvaluation evaluation);
	
}
