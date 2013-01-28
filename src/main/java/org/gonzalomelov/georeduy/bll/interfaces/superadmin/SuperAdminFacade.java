package org.gonzalomelov.georeduy.bll.interfaces.superadmin;

import java.util.List;

import org.gonzalomelov.georeduy.dal.model.Company;
import org.gonzalomelov.georeduy.dal.model.Image;
import org.gonzalomelov.georeduy.dal.model.Event;
import org.gonzalomelov.georeduy.dal.model.SiteOfInterest;
import org.gonzalomelov.georeduy.dal.model.SuperAdmin;

public interface SuperAdminFacade {

	//##########
	//SuperAdmin
	//##########
	public void registerSuperAdmin(SuperAdmin superAdmin);
	public void loginSuperAdmin(String email, String password);
	
	//##################
	//Company Management
	//##################
	public Company createCompany(Company company, String adminCompanyEmail) throws Exception;
	public void deleteCompany(Long companyId) throws Exception;
	public List<Company> findAllCompanies() throws Exception;
	public Company findCompanyByName(String name) throws Exception;
	
	//#########################
	//SiteOfInterest Management
	//#########################
	public SiteOfInterest createSiteOfInterest(SiteOfInterest soi) throws Exception;
	public void deleteSiteOfInterest(Long siteOfInterestId) throws Exception;
	public SiteOfInterest updateSiteOfInterest(SiteOfInterest soi) throws Exception;
	public SiteOfInterest findSiteOfInterestById(Long siteOfInterestId) throws Exception;
	public List<SiteOfInterest> findAllSitesOfInterest() throws Exception;
	public void addImageToSiteOfInterest(Long siteOfInterestId, Image image) throws Exception; 
	public void removeImageFromSiteOfInterest(Long siteOfInterestId, Image image) throws Exception;
	public void addThematicCategoryToSiteOfInterest(Long siteOfInterestId, Long thematicCategoryId) throws Exception;
	public void removeThematicCategoryFromSiteOfInterest(Long siteOfInterestId, Long thematicCategoryId) throws Exception;

	//#################
	//Events Management
	//#################
	public Event createEvent(Long siteOfInterestId, Event event) throws Exception;
	public void deleteEvent(Long siteOfInterestId, Long idEvent) throws Exception;
	public Event updateEvent(Long siteOfInterestId, Event event) throws Exception;
	public Event findEventById(Long siteOfInterestId, Long idEvent) throws Exception;
	public List<Event> findAllEventsOfASiteOfInterest(Long siteOfInterestId) throws Exception;
	public void addThematicCategoryToEvent(Long siteOfInterestId, Long idEvent, Long thematicCategoryId) throws Exception;
	public void removeThematicCategoryFromEvent(Long siteOfInterestId, Long idEvent, Long thematicCategoryId) throws Exception;

}
