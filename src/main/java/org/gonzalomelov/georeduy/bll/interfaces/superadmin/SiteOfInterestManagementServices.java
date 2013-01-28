package org.gonzalomelov.georeduy.bll.interfaces.superadmin;

import java.util.List;

import org.gonzalomelov.georeduy.dal.model.Image;
import org.gonzalomelov.georeduy.dal.model.SiteOfInterest;

public interface SiteOfInterestManagementServices {

	public SiteOfInterest createSiteOfInterest(SiteOfInterest soi) throws Exception;
	public void deleteSiteOfInterest(Long siteOfInterestId) throws Exception;
	public SiteOfInterest updateSiteOfInterest(SiteOfInterest soi) throws Exception;
	public SiteOfInterest findSiteOfInterestById(Long siteOfInterestId) throws Exception;
	public List<SiteOfInterest> findAllSitesOfInterest() throws Exception;
	public void addImageToSiteOfInterest(Long siteOfInterestId, Image image) throws Exception; 
	public void removeImageFromSiteOfInterest(Long siteOfInterestId, Image image) throws Exception;
	public void addThematicCategoryToSiteOfInterest(Long siteOfInterestId, Long thematicCategoryId) throws Exception;
	public void removeThematicCategoryFromSiteOfInterest(Long siteOfInterestId, Long thematicCategoryId) throws Exception;
	
}
