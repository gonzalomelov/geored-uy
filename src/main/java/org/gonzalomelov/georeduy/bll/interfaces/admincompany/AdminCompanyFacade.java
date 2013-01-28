package org.gonzalomelov.georeduy.bll.interfaces.admincompany;

import java.util.List;

import org.gonzalomelov.georeduy.dal.model.AdminCompany;
import org.gonzalomelov.georeduy.dal.model.Company;
import org.gonzalomelov.georeduy.dal.model.Location;
import org.gonzalomelov.georeduy.dal.model.Offer;

public interface AdminCompanyFacade {
	
	//############
	//AdminCompany
	//############
	public void registerAdminCompany(AdminCompany adminCompany);
	public void loginAdminCompany(String email, String password);
	
	//##################
	//Company Management
	//##################
	public Company updateCompany(Company company);
	
	//####################
	//Locations Management
	//####################
	public Location addLocation(Long companyId, Location location);
	public void removeLocation(Long companyId, Long idLocation);
	public Location updateLocation(Long companyId, Location location);
	public Location findLocationById(Long companyId, Long idLocation);
	public List<Location> findAllLocationsFromCompany(Long companyId);
	
	//#################
	//Offers Management
	//#################
	public Offer addOfferToLocation(Long companyId, Long locationId, Offer offer); 
	public void removeOfferFromLocation(Long companyId, Long locationId, Long offerId);
	public Offer updateOfferFromLocation(Long companyId, Long locationId, Offer offer);
	public Offer findOfferById(Long companyId, Long locationId, Long offerId);
	public List<Offer> listOffersFromLocation(Long companyId, Long locationId);
	public void addThematicCategoryToOffer(Long companyId, Long locationId, Long offerId, Long thematicCategoryId);
	public void removeThematicCategoryFromOffer(Long companyId, Long locationId, Long offerId, Long thematicCategoryId);

}
