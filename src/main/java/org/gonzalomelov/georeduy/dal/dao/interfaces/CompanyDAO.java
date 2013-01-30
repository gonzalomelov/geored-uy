package org.gonzalomelov.georeduy.dal.dao.interfaces;

import java.util.List;

import org.gonzalomelov.georeduy.dal.model.Company;


public interface CompanyDAO extends GenericDAO<Company>{
	public Company findByName(String name) throws Exception;
	public List<Company> findByAdminCompanyId(Long adminCompanyId) throws Exception;
}
