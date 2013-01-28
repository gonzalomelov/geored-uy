package org.gonzalomelov.georeduy.bll.service.admincompany;

import java.util.List;

import javax.ejb.Stateless;

import org.gonzalomelov.georeduy.bll.interfaces.admincompany.OfferManagementServices;
import org.gonzalomelov.georeduy.dal.model.Offer;

@Stateless(name="OfferManagementServices")
public class OfferManagement implements OfferManagementServices {

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
