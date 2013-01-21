package org.gonzalomelov.georeduy.bll.interfaces;

import java.util.List;

import org.gonzalomelov.georeduy.dal.model.Company;
import org.gonzalomelov.georeduy.pl.model.CompanyCreate;

public interface CompanyManagementService {
	public Company createCompany(CompanyCreate company);
	public void deleteCompany(Long companyId);
	public Company updateCompany(Company company);
	public List<Company> findAllCompanies();
	public Company findCompanyByName(String name);

}
