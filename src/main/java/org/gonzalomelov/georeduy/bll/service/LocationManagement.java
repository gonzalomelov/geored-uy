package org.gonzalomelov.georeduy.bll.service;

import java.util.List;

import javax.ejb.Stateless;

import org.gonzalomelov.georeduy.bll.interfaces.LocationServices;
import org.gonzalomelov.georeduy.dal.model.Location;
import org.gonzalomelov.georeduy.dal.model.Offer;
import org.gonzalomelov.georeduy.dal.model.OfferEvaluation;

@Stateless(name="locationServices")
public class LocationManagement implements LocationServices {

	@Override
	public Location addLocation(Long companyId, Location location) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeLocation(Long companyId, Long idLocation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Location updateLocation(Long companyId, Location location) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Location findLocationById(Long companyId, Long idLocation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Location> findAllLocationsFromCompany(Long companyId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Location> findAllClosestLocationsFromUser(Long userId) {
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
