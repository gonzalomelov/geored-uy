package org.gonzalomelov.georeduy.bll.interfaces.admincompany;

import java.util.List;

import org.gonzalomelov.georeduy.dal.model.Location;

public interface LocationManagementServices {

	public Location addLocation(Long companyId, Location location);
	public void removeLocation(Long companyId, Long idLocation);
	public Location updateLocation(Long companyId, Location location);
	public Location findLocationById(Long companyId, Long idLocation);
	public List<Location> findAllLocationsFromCompany(Long companyId);
	
}
