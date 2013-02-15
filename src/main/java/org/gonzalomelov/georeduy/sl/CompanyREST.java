package org.gonzalomelov.georeduy.sl;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.gonzalomelov.georeduy.bll.interfaces.CompanyServices;
import org.gonzalomelov.georeduy.dal.model.Company;


@Path("/company")
public class CompanyREST {
	
	@EJB(name="companyServices")
	private CompanyServices companyServices;
	
	public CompanyServices getCompanyServices() {
		return companyServices;
	}

	public void setCompanyServices(CompanyServices companyServices) {
		this.companyServices = companyServices;
	}

	//Services
	
	/**
	 * Return the company and its information
	 * 
	 * @param id Company id
	 * @return company with its offers and locations
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Company findCompanyById(Long id) throws Exception {
		return companyServices.findCompanyById(id);
	}

	/**
	 * Return the company and its information
	 * 
	 * @param name Company name
	 * @return company with its offers and locations
	 */
	public Company findCompanyByName(String name) throws Exception {
		return companyServices.findCompanyByName(name);
	}
	
	/**
	 * Returns all the registered companies
	 * 
	 * @return List of the registered companies without locations and offers
	 */
	public List<Company> findAllCompanies() throws Exception {
		return companyServices.findAllCompanies();
	}
	
	/**
	 * Returns all the registered companies of a AdminCompany
	 * 
	 * @return List of the registered companies without locations and offers of a particular AdminCompany
	 */
	public List<Company> findAllCompaniesByAdminCompanyId(Long adminCompanyId) throws Exception {
		return companyServices.findAllCompaniesByAdminCompanyId(adminCompanyId);
	}
	
	//SuperAdmin
	/**
	 * Creates a company and assigns it to a company
	 * administrator which is sent an email to manage the company
	 *  
	 * @param company to persist
	 * @return the persisted company
	 */
//	public Company createCompany(Company company, String adminCompanyEmail) throws Exception {
//		
//	}
	
	/**
	 * Deletes a company, its locations and offers.
	 * IMPORTANT: It doesn't delete its administrator
	 *  
	 * @param companyId of the company to be deleted
	 */
//	public void deleteCompany(Long companyId) throws Exception {
//		
//	}
	
	//AdminCompany
	
	/**
	 * Updates the company description and logo
	 *  
	 * @param company Company to be updated
	 */
//	public Company updateCompany(Company company) throws Exception {
//		
//	}
}
