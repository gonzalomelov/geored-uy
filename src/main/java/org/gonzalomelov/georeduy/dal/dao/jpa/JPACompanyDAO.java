package org.gonzalomelov.georeduy.dal.dao.jpa;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import org.gonzalomelov.georeduy.dal.dao.interfaces.CompanyDAO;
import org.gonzalomelov.georeduy.dal.model.AdminCompany;
import org.gonzalomelov.georeduy.dal.model.AdminCompany_;
import org.gonzalomelov.georeduy.dal.model.Company;
import org.gonzalomelov.georeduy.dal.model.Company_;

public class JPACompanyDAO extends JPAAbstractDAO<Company> implements CompanyDAO{
	public Company findByName(String name) throws Exception {
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
	
	public List<Company> findByAdminCompanyId(Long adminCompanyId) throws Exception {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Company> companyCriteria = builder.createQuery(Company.class);
		Root<Company> companyRoot = companyCriteria.from(Company.class);
		Join<Company, AdminCompany> join = companyRoot.join(Company_.adminCompany);
		companyCriteria.select(companyRoot);
		companyCriteria.where(builder.equal(join.get(AdminCompany_.id), adminCompanyId));
		
		return em.createQuery(companyCriteria).getResultList();
		
	}
}