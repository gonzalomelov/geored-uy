package org.gonzalomelov.georeduy.pl.controller.admincompany;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.gonzalomelov.georeduy.bll.interfaces.CompanyServices;
import org.gonzalomelov.georeduy.dal.model.Company;
import org.gonzalomelov.georeduy.pl.controller.person.PersonSessionManagementController;
import org.gonzalomelov.georeduy.pl.model.admincompany.CompanyManagementModelAdminCompany;

@ManagedBean
@RequestScoped
public class CompanyManagementControllerAdminCompany {
	//private List<File> files ;
	
	@ManagedProperty(value="#{personSessionManagementController}")
	private PersonSessionManagementController personSessionManagementController;  
	
	private CompanyManagementModelAdminCompany companyManagementModelAdminCompany; 
	
	@EJB(name="companyServices")
	private CompanyServices companyServices;

	public CompanyServices getCompanyServices() {
		return companyServices;
	}

	public void setCompanyServices(CompanyServices companyServices) {
		this.companyServices = companyServices;
	}

	public CompanyManagementModelAdminCompany getCompanyManagementModelAdminCompany() {
		return companyManagementModelAdminCompany;
	}

	public void setCompanyManagementModelAdminCompany(
			CompanyManagementModelAdminCompany companyManagementModelAdminCompany) {
		this.companyManagementModelAdminCompany = companyManagementModelAdminCompany;
	}
	
	public void fileUploaded() throws Exception {
		
	}
	
	public List<Company> findAllCompaniesFromAdminCompany(){
		try {
			Long adminCompanyId = personSessionManagementController.getPerson().getId();
			return companyServices.findAllCompaniesByAdminCompanyId(adminCompanyId);
		}
		catch(Exception e){
			return null;
		}
	}
}
