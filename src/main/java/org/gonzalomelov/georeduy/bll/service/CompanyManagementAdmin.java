package org.gonzalomelov.georeduy.bll.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.gonzalomelov.georeduy.bll.interfaces.company.CompanyManagementAdminServices;
import org.gonzalomelov.georeduy.dal.dao.interfaces.LocationDAO;

@Stateless(name="CompanyManagementAdminServices")
public class CompanyManagementAdmin implements CompanyManagementAdminServices {
	@Inject
	private LocationDAO locationDAO;
}
