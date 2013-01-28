package org.gonzalomelov.georeduy.bll.service.superadmin;

import java.util.List;

import javax.ejb.Stateless;

import org.gonzalomelov.georeduy.bll.interfaces.superadmin.SiteOfInterestManagementServices;
import org.gonzalomelov.georeduy.dal.model.Image;
import org.gonzalomelov.georeduy.dal.model.SiteOfInterest;

@Stateless(name="SiteOfInterestManagementServices")
public class SiteOfInterestManagement implements SiteOfInterestManagementServices {

	@Override
	public SiteOfInterest createSiteOfInterest(SiteOfInterest soi)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteSiteOfInterest(Long siteOfInterestId) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SiteOfInterest updateSiteOfInterest(SiteOfInterest soi)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SiteOfInterest findSiteOfInterestById(Long siteOfInterestId)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SiteOfInterest> findAllSitesOfInterest() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addImageToSiteOfInterest(Long siteOfInterestId, Image image)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeImageFromSiteOfInterest(Long siteOfInterestId, Image image)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addThematicCategoryToSiteOfInterest(Long siteOfInterestId,
			Long thematicCategoryId) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeThematicCategoryFromSiteOfInterest(Long siteOfInterestId,
			Long thematicCategoryId) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
