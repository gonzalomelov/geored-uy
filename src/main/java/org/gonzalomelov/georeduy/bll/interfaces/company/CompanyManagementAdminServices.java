package org.gonzalomelov.georeduy.bll.interfaces.company;

import javax.inject.Inject;

import org.gonzalomelov.georeduy.dal.dao.interfaces.LocationDAO;
import org.gonzalomelov.georeduy.dal.model.Company;
import org.gonzalomelov.georeduy.dal.model.Location;

public interface CompanyManagementAdminServices {
	
	/**
	 * Update the company name, description and logo
	 * 
	 * @param company
	 * @return updated company  
	 */
	public Company updateCompany(Company company);
	
	/**
	 * Return the company and its information
	 * 
	 * @param name Company name
	 * @return company with its offers and locations
	 */
	//public Company findCompanyByName(String name);
	
	
	public Location addLocation(Location location);

}
