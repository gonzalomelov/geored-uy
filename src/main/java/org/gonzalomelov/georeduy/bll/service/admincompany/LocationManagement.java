package org.gonzalomelov.georeduy.bll.service.admincompany;

import java.util.List;

import javax.ejb.Stateless;

import org.gonzalomelov.georeduy.bll.interfaces.admincompany.LocationManagementServices;
import org.gonzalomelov.georeduy.dal.model.Location;

@Stateless(name="LocationManagementServices")
public class LocationManagement implements LocationManagementServices {

	@Override
	public Location addLocation(Long companyId, Location location) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeLocation(Long companyId, Long idLocation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Location updateLocation(Long companyId, Location location) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Location findLocationById(Long companyId, Long idLocation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Location> findAllLocationsFromCompany(Long companyId) {
		// TODO Auto-generated method stub
		return null;
	}

}
