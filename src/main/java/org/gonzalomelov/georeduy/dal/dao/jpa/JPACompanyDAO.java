package org.gonzalomelov.georeduy.dal.dao.jpa;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.gonzalomelov.georeduy.dal.dao.interfaces.CompanyDAO;
import org.gonzalomelov.georeduy.dal.model.Company;
import org.gonzalomelov.georeduy.dal.model.Company_;

public class JPACompanyDAO extends JPAAbstractDAO<Company> implements CompanyDAO{
	public Company findByName(String name){
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Company> query = builder.createQuery(Company.class);
		Root<Company> root = query.from(Company.class);
		query.select(root);
		query.where(builder.equal(root.get(Company_.name), name));
		
		Company company = null;
		List<Company> companies = em.createQuery(query).getResultList();
		if (companies.size() == 1){
			company = companies.get(0);
		}
		
		return company;
	}	
}