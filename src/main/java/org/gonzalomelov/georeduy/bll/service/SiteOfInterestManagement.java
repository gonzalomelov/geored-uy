package org.gonzalomelov.georeduy.bll.service;

import java.util.List;

import javax.ejb.Stateless;

import org.gonzalomelov.georeduy.bll.interfaces.SiteOfInterestServices;
import org.gonzalomelov.georeduy.dal.model.CheckIn;
import org.gonzalomelov.georeduy.dal.model.Image;
import org.gonzalomelov.georeduy.dal.model.SiteOfInterest;
import org.gonzalomelov.georeduy.dal.model.SiteOfInterestContent;
import org.joda.time.DateTime;

@Stateless(name="siteOfInterestServices")
public class SiteOfInterestManagement implements SiteOfInterestServices {

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

	@Override
	public List<SiteOfInterest> findAllClosestSitesOfInterestFromUser(
			Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void checkInSiteOfInterest(Long siteOfInterestId, Long userId,
			DateTime dateTime) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CheckIn> findAllClosestCheckInsFromUser(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void shareContentFromSiteOfInterest(Long siteOfInterestId,
			Long userId, SiteOfInterestContent content) {
		// TODO Auto-generated method stub
		
	}

}
