package org.gonzalomelov.georeduy.bll.interfaces.admincompany;

import java.util.List;

import org.gonzalomelov.georeduy.dal.model.Offer;

public interface OfferManagementServices {
	
	public Offer addOfferToLocation(Long companyId, Long locationId, Offer offer); 
	public void removeOfferFromLocation(Long companyId, Long locationId, Long offerId);
	public Offer updateOfferFromLocation(Long companyId, Long locationId, Offer offer);
	public Offer findOfferById(Long companyId, Long locationId, Long offerId);
	public List<Offer> listOffersFromLocation(Long companyId, Long locationId);
	public void addThematicCategoryToOffer(Long companyId, Long locationId, Long offerId, Long thematicCategoryId);
	public void removeThematicCategoryFromOffer(Long companyId, Long locationId, Long offerId, Long thematicCategoryId);
	
}
