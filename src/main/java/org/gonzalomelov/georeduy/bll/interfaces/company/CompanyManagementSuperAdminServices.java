package org.gonzalomelov.georeduy.bll.interfaces.company;

import java.util.List;

import org.gonzalomelov.georeduy.dal.model.Company;
import org.gonzalomelov.georeduy.pl.model.CompanyManagementSuperAdminModel;

public interface CompanyManagementSuperAdminServices {
	
	/**
	 * Creates a company and assigns it to a company
	 * administrator which is sent an email to manage the company 
	 * @param company to persist
	 * @return the persisted company
	 */
	public Company createCompany(CompanyManagementSuperAdminModel company) throws Exception;
	
	/**
	 * Deletes a company, its locations and offers.
	 * IMPORTANT: It doesn't delete its administrator 
	 * @param companyId of the company to be deleted
	 */
	public void deleteCompany(Long companyId);
	
	
	/**
	 * Returns all the registered companies
	 * @return List of the registered companies without locations and offers
	 */
	public List<Company> findAllCompanies() throws Exception;
	
	
	

}
