package org.gonzalomelov.georeduy.pl.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.validation.ConstraintViolationException;

import org.gonzalomelov.georeduy.bll.interfaces.company.CompanyManagementSuperAdminServices;
import org.gonzalomelov.georeduy.dal.model.Company;
import org.gonzalomelov.georeduy.pl.model.CompanyManagementSuperAdminModel;

@ManagedBean
@RequestScoped
public class CompanyManagementSuperAdminController {
 
	private CompanyManagementSuperAdminModel companyManagementSuperAdminModel = new CompanyManagementSuperAdminModel();
	
	@EJB(name="companyManagement")
	private CompanyManagementSuperAdminServices companyManagementSuperAdminServices;
	
	
	//Getters and Setters
	public CompanyManagementSuperAdminModel getCompanyManagementSuperAdminModel() {
		return companyManagementSuperAdminModel;
	}

	public void setCompanyManagementSuperAdminModel(CompanyManagementSuperAdminModel companyManagementSuperAdminModel) {
		this.companyManagementSuperAdminModel = companyManagementSuperAdminModel;
	}

	public CompanyManagementSuperAdminServices getCompanyManagementSuperAdminServices() {
		return companyManagementSuperAdminServices;
	}

	public void setCompanyManagementSuperAdminServices(CompanyManagementSuperAdminServices companyManagementSuperAdminServices) {
		this.companyManagementSuperAdminServices = companyManagementSuperAdminServices;
	}

	//Functions
	public String createCompany(){
		try {
			companyManagementSuperAdminServices.createCompany(companyManagementSuperAdminModel);
			return "/company/listCompanies.xhtml";
		}
		catch(Exception e){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage()));
			return null;
		}
		finally{
			System.out.println("Gonzalo");
		}
	}
	
	public List<Company> listCompanies(){
		try {
			return companyManagementSuperAdminServices.findAllCompanies();
		}
		catch(Exception e){
			return null;
		}
	}
	
	/*
	public String updateCompany(){
		companyManagementServices.updateCompany(companyManagementSuperAdminModel.getCompany());
		return "/companies/listCompanies";
	}
	*/
	
	public String deleteCompany(){
		companyManagementSuperAdminServices.deleteCompany(companyManagementSuperAdminModel.getCompany().getId());
		return "/companies/listCompanies";
	}
}
