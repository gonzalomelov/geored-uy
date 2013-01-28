package org.gonzalomelov.georeduy.bll.interfaces.superadmin;

import java.util.List;

import org.gonzalomelov.georeduy.dal.model.Company;

public interface CompanyManagementServices {
	
	/**
	 * Creates a company and assigns it to a company
	 * administrator which is sent an email to manage the company
	 *  
	 * @param company to persist
	 * @return the persisted company
	 */
	public Company createCompany(Company company, String adminCompanyEmail) throws Exception;
	
	/**
	 * Deletes a company, its locations and offers.
	 * IMPORTANT: It doesn't delete its administrator
	 *  
	 * @param companyId of the company to be deleted
	 */
	public void deleteCompany(Long companyId) throws Exception;
	
	/**
	 * Returns all the registered companies
	 * 
	 * @return List of the registered companies without locations and offers
	 */
	public List<Company> findAllCompanies() throws Exception;
	
	/**
	 * Return the company and its information
	 * 
	 * @param name Company name
	 * @return company with its offers and locations
	 */
	public Company findCompanyByName(String name) throws Exception;
}
