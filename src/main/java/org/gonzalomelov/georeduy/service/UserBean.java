package org.gonzalomelov.georeduy.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.gonzalomelov.georeduy.model.User;
import org.gonzalomelov.georeduy.model.User_;

@Stateless
public class UserBean {
	@PersistenceContext
	public EntityManager em;
	
	public void registerUser(User user){
        em.persist(user);	    
	}
	
	public boolean validateUser(User user){
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<User> query = builder.createQuery(User.class);
		Root<User> userRoot = query.from(User.class);
		query.select(userRoot);
		query.where(builder.equal(userRoot.get(User_.email), user.getEmail()));
		//builder.and(builder.equal(userRoot.get(User_.password), user.getPassword()));
		return em.createQuery(query).getResultList().size() == 1;
	}
}