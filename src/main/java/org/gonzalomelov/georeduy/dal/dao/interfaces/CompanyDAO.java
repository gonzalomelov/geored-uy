package org.gonzalomelov.georeduy.dal.dao.interfaces;

import org.gonzalomelov.georeduy.dal.model.Company;


public interface CompanyDAO extends GenericDAO<Company>{
	public Company findByName(String name);
}
