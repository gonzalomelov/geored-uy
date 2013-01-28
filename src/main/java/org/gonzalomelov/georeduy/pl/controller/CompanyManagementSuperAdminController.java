package org.gonzalomelov.georeduy.pl.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.gonzalomelov.georeduy.bll.interfaces.superadmin.CompanyManagementServices;
import org.gonzalomelov.georeduy.dal.model.Company;
import org.gonzalomelov.georeduy.pl.model.CompanyManagementSuperAdminModel;

@ManagedBean
@RequestScoped
public class CompanyManagementSuperAdminController {
 
	private CompanyManagementSuperAdminModel companyManagementSuperAdminModel = new CompanyManagementSuperAdminModel();
	
	@EJB(name="companyManagementServices")
	private CompanyManagementServices companyManagementServices;
	
	
	//Getters and Setters
	public CompanyManagementSuperAdminModel getCompanyManagementSuperAdminModel() {
		return companyManagementSuperAdminModel;
	}

	public void setCompanyManagementSuperAdminModel(CompanyManagementSuperAdminModel companyManagementSuperAdminModel) {
		this.companyManagementSuperAdminModel = companyManagementSuperAdminModel;
	}

	public CompanyManagementServices getCompanyManagementSuperAdminServices() {
		return companyManagementServices;
	}

	public void setCompanyManagementSuperAdminServices(CompanyManagementServices companyManagementServices) {
		this.companyManagementServices = companyManagementServices;
	}

	//Functions
	public String createCompany(){
		try {
			companyManagementServices.createCompany(companyManagementSuperAdminModel);
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
			return companyManagementServices.findAllCompanies();
		}
		catch(Exception e){
			return null;
		}
	}
	
	public String deleteCompany(){
		companyManagementServices.deleteCompany(companyManagementSuperAdminModel.getCompany().getId());
		return "/companies/listCompanies";
	}
	
	public Company showCompany(String name){
		return companyManagementServices.findCompanyByName(name);
	}
}
