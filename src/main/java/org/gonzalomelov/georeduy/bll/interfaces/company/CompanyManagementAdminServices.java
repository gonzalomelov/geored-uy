package org.gonzalomelov.georeduy.bll.interfaces.company;

import org.gonzalomelov.georeduy.dal.model.Company;

public interface CompanyManagementAdminServices {
	/**
	 * Update the company name or description
	 * @param company
	 * @return updated company  
	 */
	//public Company updateCompany(Company company);
	
	/**
	 * Return the company and its information
	 * @param name Company name
	 * @return company with its offers and locations
	 */
	public Company findCompanyByName(String name);

}
