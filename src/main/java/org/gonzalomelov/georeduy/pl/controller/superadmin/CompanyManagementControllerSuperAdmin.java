package org.gonzalomelov.georeduy.pl.controller.superadmin;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.gonzalomelov.georeduy.bll.interfaces.CompanyServices;
import org.gonzalomelov.georeduy.dal.model.Company;
import org.gonzalomelov.georeduy.pl.model.superadmin.CompanyManagementModelSuperAdmin;

@ManagedBean
@RequestScoped
public class CompanyManagementControllerSuperAdmin {
	
	private CompanyManagementModelSuperAdmin companyManagementModelSuperAdmin = new CompanyManagementModelSuperAdmin(); 
	
	@EJB(name="companyServices")
	private CompanyServices companyServices;
	
	//Getters and Setters
	
	public CompanyManagementModelSuperAdmin getCompanyManagementModelSuperAdmin() {
		return companyManagementModelSuperAdmin;
	}

	public void setCompanyManagementModelSuperAdmin(
			CompanyManagementModelSuperAdmin companyManagementModelSuperAdmin) {
		this.companyManagementModelSuperAdmin = companyManagementModelSuperAdmin;
	}
	
	public CompanyServices getCompanyServices() {
		return companyServices;
	}

	public void setCompanyServices(CompanyServices companyServices) {
		this.companyServices = companyServices;
	}

	//Functions
	
	public String createCompany(){
		try {
			companyServices.createCompany(companyManagementModelSuperAdmin.getCompany(), companyManagementModelSuperAdmin.getAdminCompanyEmail());
			return "/superadmin/listCompanies.xhtml";
		}
		catch(Exception e){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage()));
			return null;
		}
	}
	
	public List<Company> findAllCompanies(){
		try {
			return companyServices.findAllCompanies();
		}
		catch(Exception e){
			return null;
		}
	}
	
	public String deleteCompany(){
		try {
			companyServices.deleteCompany(companyManagementModelSuperAdmin.getCompany().getId());
			return "/companies/listCompanies";
		}catch (Exception e){
			return "/index";
		}
		
	}
	
	public Company findCompanyByName(String name){
		try {
			return companyServices.findCompanyByName(name);
		}catch (Exception e){
			return null;
		}

	}
}
