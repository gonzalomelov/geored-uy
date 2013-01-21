package org.gonzalomelov.georeduy.bll.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.apache.commons.lang3.RandomStringUtils;

import org.gonzalomelov.georeduy.bll.interfaces.CompanyManagementService;
import org.gonzalomelov.georeduy.dal.dao.interfaces.CompanyDAO;
import org.gonzalomelov.georeduy.dal.dao.interfaces.PersonDAO;
import org.gonzalomelov.georeduy.dal.model.AdminCompany;
import org.gonzalomelov.georeduy.dal.model.Company;
import org.gonzalomelov.georeduy.pl.model.CompanyCreate;


@Stateless(name="companyManagement")
public class CompanyManagement implements CompanyManagementService {
	@Inject
	private CompanyDAO companyDAO;
	
	@Inject
	private PersonDAO personDAO;
	
	@Override
	public Company createCompany(CompanyCreate companyCreate){
		
		String adminCompanyEmail = companyCreate.getAdminCompanyEmail();
		String adminCompanyPassword = "Carbonero"; //RandomStringUtils.random(10);
		AdminCompany adminCompany = new AdminCompany(adminCompanyEmail, adminCompanyPassword,"","");
		
		Company company = companyCreate.getCompany();
		
		company.setAdminCompany(adminCompany);
		adminCompany.getCompanies().put(company.getName(), company);
		
		company = companyDAO.insert(companyCreate.getCompany());
		
		return company;
	}
	
	@Override
	public void deleteCompany(Long companyId){
		companyDAO.delete(companyId);
	}
	
	@Override
	public Company updateCompany(Company company){
		Company c = companyDAO.update(company);
		return c; 
	}
	
	@Override
	public List<Company> findAllCompanies(){
		return companyDAO.findAll();
	}
	
	@Override
	public Company findCompanyByName(String name){
		return companyDAO.findByName(name);
	}
}
