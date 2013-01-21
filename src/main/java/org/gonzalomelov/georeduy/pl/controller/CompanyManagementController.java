package org.gonzalomelov.georeduy.pl.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.gonzalomelov.georeduy.bll.interfaces.CompanyManagementService;
import org.gonzalomelov.georeduy.dal.model.Company;
import org.gonzalomelov.georeduy.pl.model.CompanyCreate;

@ManagedBean
@RequestScoped
public class CompanyManagementController {

	private CompanyCreate companyCreate = new CompanyCreate();
	
	@EJB(name="companyManagement")
	private CompanyManagementService companyManagementService;
	
	
	//Getters and Setters
	public CompanyCreate getCompanyCreate() {
		return companyCreate;
	}

	public void setCompanyCreate(CompanyCreate companyCreate) {
		this.companyCreate = companyCreate;
	}

	public CompanyManagementService getCompanyManagementService() {
		return companyManagementService;
	}

	public void setCompanyManagementService(
			CompanyManagementService companyManagementService) {
		this.companyManagementService = companyManagementService;
	}

	//Functions
	public String createCompany(){
		companyManagementService.createCompany(companyCreate); 
		return "/companies/listCompanies";
	}
	
	public List<Company> listCompanies(){
		return companyManagementService.findAllCompanies(); 
	}
	
	public String updateCompany(){
		companyManagementService.updateCompany(companyCreate.getCompany());
		return "/companies/listCompanies";
	}
	
	public String deleteCompany(){
		companyManagementService.deleteCompany(companyCreate.getCompany().getId());
		return "/companies/listCompanies";
	}
}
