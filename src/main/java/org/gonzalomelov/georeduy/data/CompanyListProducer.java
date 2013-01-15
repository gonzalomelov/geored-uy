package org.gonzalomelov.georeduy.data;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.gonzalomelov.georeduy.model.Company;

@RequestScoped
public class CompanyListProducer {
	@Inject
	private EntityManager em;
	
	private List<Company> companies;
	
	@Produces
	@Named
	public List<Company> getCompanies(){
		return companies;
	}
	
	public void onCompanyListChanged(@Observes(notifyObserver = Reception.IF_EXISTS) final Company company) {
		retrieveAllCompanies();
	}
	
	@PostConstruct
	public void retrieveAllCompanies(){
		System.out.println("PostConstructor");
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Company> criteriaQuery = criteriaBuilder.createQuery(Company.class);
		//Root<Company> from = criteriaQuery.from(Company.class);
		companies = em.createQuery(criteriaQuery).getResultList();
	}
}
