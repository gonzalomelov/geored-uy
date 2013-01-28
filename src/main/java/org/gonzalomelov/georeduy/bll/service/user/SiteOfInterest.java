package org.gonzalomelov.georeduy.bll.service.user;

import java.util.List;

import javax.ejb.Stateless;

import org.gonzalomelov.georeduy.bll.interfaces.user.SiteOfInterestServices;
import org.gonzalomelov.georeduy.dal.model.CheckIn;
import org.gonzalomelov.georeduy.dal.model.SiteOfInterestContent;
import org.joda.time.DateTime;

@Stateless(name="SiteOfInterestServices")
public class SiteOfInterest implements SiteOfInterestServices {

	@Override
	public List<org.gonzalomelov.georeduy.dal.model.SiteOfInterest> findAllClosestSitesOfInterestFromUser(
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
