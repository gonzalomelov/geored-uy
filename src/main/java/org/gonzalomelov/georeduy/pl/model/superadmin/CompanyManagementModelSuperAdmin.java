package org.gonzalomelov.georeduy.pl.model.superadmin;

import org.gonzalomelov.georeduy.dal.model.Company;

public class CompanyManagementModelSuperAdmin {
	private Company company = new Company();
	
	private String adminCompanyEmail;

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getAdminCompanyEmail() {
		return adminCompanyEmail;
	}

	public void setAdminCompanyEmail(String adminCompanyEmail) {
		this.adminCompanyEmail = adminCompanyEmail;
	}
	
	
}
