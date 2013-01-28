package org.gonzalomelov.georeduy.bll.service.user;

import java.util.List;

import javax.ejb.Stateless;

import org.gonzalomelov.georeduy.bll.interfaces.user.LocationServices;
import org.gonzalomelov.georeduy.dal.model.Offer;
import org.gonzalomelov.georeduy.dal.model.OfferEvaluation;

@Stateless(name="LocationServices")
public class Location implements LocationServices {

	@Override
	public List<org.gonzalomelov.georeduy.dal.model.Location> findAllClosestLocationsFromUser(
			Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Offer> findAllClosestOffersFromUser(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void buyOffer(Long companyId, Long locationId, Long offerId,
			Long userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void evaluateOffer(Long companyId, Long locationId, Long offerId,
			Long userId, OfferEvaluation evaluation) {
		// TODO Auto-generated method stub
		
	}

}
