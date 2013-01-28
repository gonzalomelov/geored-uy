package org.gonzalomelov.georeduy.bll.interfaces.user;

import java.util.List;

import org.gonzalomelov.georeduy.dal.model.CheckIn;
import org.gonzalomelov.georeduy.dal.model.SiteOfInterest;
import org.gonzalomelov.georeduy.dal.model.SiteOfInterestContent;
import org.joda.time.DateTime;

public interface SiteOfInterestServices {
	
	public List<SiteOfInterest> findAllClosestSitesOfInterestFromUser(Long userId);
	public void checkInSiteOfInterest(Long siteOfInterestId, Long userId, DateTime dateTime);
	public List<CheckIn> findAllClosestCheckInsFromUser(Long userId);
	public void shareContentFromSiteOfInterest(Long siteOfInterestId, Long userId, SiteOfInterestContent content);
	
}
