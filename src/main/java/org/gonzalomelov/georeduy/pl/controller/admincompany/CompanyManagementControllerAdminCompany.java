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
	private Long companyId;
	
	private Company company = new Company();
	
	@ManagedProperty(value="#{personSessionManagementController}")
	private PersonSessionManagementController personSessionManagementController;  
	
	private CompanyManagementModelAdminCompany companyManagementModelAdminCompany; 
	
	@EJB(name="companyServices")
	private CompanyServices companyServices;

	//Getters and Setters
	
	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
	
	public PersonSessionManagementController getPersonSessionManagementController() {
		return personSessionManagementController;
	}

	public void setPersonSessionManagementController(
			PersonSessionManagementController personSessionManagementController) {
		this.personSessionManagementController = personSessionManagementController;
	}

	public CompanyManagementModelAdminCompany getCompanyManagementModelAdminCompany() {
		return companyManagementModelAdminCompany;
	}

	public void setCompanyManagementModelAdminCompany(
			CompanyManagementModelAdminCompany companyManagementModelAdminCompany) {
		this.companyManagementModelAdminCompany = companyManagementModelAdminCompany;
	}
	
	public CompanyServices getCompanyServices() {
		return companyServices;
	}

	public void setCompanyServices(CompanyServices companyServices) {
		this.companyServices = companyServices;
	}
	
	//Functions
	
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
	
	public String editCompany(){
		try {
			System.out.println("#############################" + companyId);
			company = companyServices.findCompanyById(companyId);
			return null;
		}
		catch (Exception e){
			//Message: Company doesnt exit
			return "/admincompany/listCompanies";
		}
	}
}
