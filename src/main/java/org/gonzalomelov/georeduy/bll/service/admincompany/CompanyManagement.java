package org.gonzalomelov.georeduy.bll.service.admincompany;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.gonzalomelov.georeduy.bll.interfaces.admincompany.CompanyManagementServices;
import org.gonzalomelov.georeduy.dal.dao.interfaces.LocationDAO;
import org.gonzalomelov.georeduy.dal.model.Company;

@Stateless(name="CompanyManagementServices")
public class CompanyManagement implements CompanyManagementServices {
	@Inject
	private LocationDAO locationDAO;

	@Override
	public Company updateCompany(Company company) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
