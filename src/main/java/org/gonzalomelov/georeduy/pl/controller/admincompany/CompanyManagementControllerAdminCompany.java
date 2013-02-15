package org.gonzalomelov.georeduy.pl.controller.admincompany;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.gonzalomelov.georeduy.bll.interfaces.CompanyServices;
import org.gonzalomelov.georeduy.dal.model.Company;
import org.gonzalomelov.georeduy.dal.model.Image;
import org.gonzalomelov.georeduy.pl.controller.person.PersonSessionManagementController;
import org.gonzalomelov.georeduy.pl.model.admincompany.CompanyManagementModelAdminCompany;
import org.richfaces.event.FileUploadEvent;
import org.richfaces.model.UploadedFile;

@ManagedBean
@SessionScoped
public class CompanyManagementControllerAdminCompany {
	
	@ManagedProperty(value="#{personSessionManagementController}")
	private PersonSessionManagementController personSessionManagementController;  
	
	private CompanyManagementModelAdminCompany companyManagementModelAdminCompany = new CompanyManagementModelAdminCompany(); 
	
	@EJB(name="companyServices")
	private CompanyServices companyServices;

	//Getters and Setters

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
	
	public List<Company> findAllCompaniesFromAdminCompany(){
		try {
			Long adminCompanyId = personSessionManagementController.getPerson().getId();
			return companyServices.findAllCompaniesByAdminCompanyId(adminCompanyId);
		}
		catch(Exception e){
			return null;
		}
	}
	
	public String updateCompany(){
		try {
			companyManagementModelAdminCompany.getCompany().setLogo(companyManagementModelAdminCompany.getImage());
			companyServices.updateCompany(companyManagementModelAdminCompany.getCompany());
			System.out.print("companyUpdated");
			return "/admincompany/listCompanies";
		}
		catch (Exception e){
			//Message: Company doesnt exit
			System.out.println("Exception: "+e.getMessage());
			return "/admincompany/listCompanies";
		}
	}
	
	public void fileUploaded(FileUploadEvent ev) throws Exception {
		UploadedFile image = ev.getUploadedFile();
		Image logo = new Image();
		logo.setImage(image.getData());
		companyManagementModelAdminCompany.setImage(logo);
		System.out.print("fileUploaded");
	}
}
