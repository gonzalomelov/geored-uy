package org.gonzalomelov.georeduy.bll.service;

import java.util.List;

import javax.ejb.Stateless;

import org.gonzalomelov.georeduy.bll.interfaces.OfferServices;
import org.gonzalomelov.georeduy.dal.model.Offer;

@Stateless(name="offerServices")
public class OfferManagement implements OfferServices {

	@Override
	public Offer addOfferToLocation(Long companyId, Long locationId, Offer offer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeOfferFromLocation(Long companyId, Long locationId,
			Long offerId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Offer updateOfferFromLocation(Long companyId, Long locationId,
			Offer offer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Offer findOfferById(Long companyId, Long locationId, Long offerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Offer> listOffersFromLocation(Long companyId, Long locationId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addThematicCategoryToOffer(Long companyId, Long locationId,
			Long offerId, Long thematicCategoryId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeThematicCategoryFromOffer(Long companyId,
			Long locationId, Long offerId, Long thematicCategoryId) {
		// TODO Auto-generated method stub
		
	}

}
