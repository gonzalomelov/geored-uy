package org.gonzalomelov.georeduy.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.gonzalomelov.georeduy.model.Product;

@Stateless
public class ProductBean {
	
	@PersistenceContext
	private EntityManager em;
	
	public List<Product> getProducts(){
		List<Product> products = new ArrayList<Product>();
		
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Product> query = builder.createQuery(Product.class);
		query.from(Product.class);
		
		products = em.createQuery(query).getResultList();
		
		return products;
	}
	
	public void addProduct(Product p){
		em.persist(p);
	}
}