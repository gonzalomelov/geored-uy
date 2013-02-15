package org.gonzalomelov.georeduy.pl.controller.admincompany;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.gonzalomelov.georeduy.bll.interfaces.LocationServices;
import org.gonzalomelov.georeduy.dal.model.Location;
import org.gonzalomelov.georeduy.pl.model.admincompany.LocationManagementModelAdminCompany;


@ManagedBean
@ViewScoped
public class LocationManagementControllerAdminCompany {
	
	private LocationManagementModelAdminCompany locationManagementModelAdminCompany = new LocationManagementModelAdminCompany();
	
	@EJB(name="locationServices")
	private LocationServices locationServices;
	
	//Getters and Setters
	public LocationManagementModelAdminCompany getLocationManagementModelAdminCompany() {
		return locationManagementModelAdminCompany;
	}

	public void setLocationManagementModelAdminCompany(
			LocationManagementModelAdminCompany locationManagementModelAdminCompany) {
		this.locationManagementModelAdminCompany = locationManagementModelAdminCompany;
	}

	public LocationServices getLocationServices() {
		return locationServices;
	}

	public void setLocationServices(LocationServices locationServices) {
		this.locationServices = locationServices;
	}

	//Functions
	public List<Location> findAllLocationsFromCompany(Long companyId){
		try {
			return locationServices.findAllLocationsFromCompany(companyId);
		}
		catch (Exception e){
			//Error Message
			return null;
		}
	}
	
	public String addLocation(){
		try {
			System.out.println(locationManagementModelAdminCompany.getCompanyId());
			System.out.println(locationManagementModelAdminCompany.getName());
			System.out.println(locationManagementModelAdminCompany.getCoordX());
			System.out.println(locationManagementModelAdminCompany.getCoordY());
			locationServices.addLocation(
				locationManagementModelAdminCompany.getCompanyId(),
				locationManagementModelAdminCompany.getName(),
				locationManagementModelAdminCompany.getCoordX(),
				locationManagementModelAdminCompany.getCoordY()
			);
			
			return "/admincompany/locations";
		}
		catch(Exception e){
			return "/index";
		}
	}
}
