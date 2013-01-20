package org.gonzalomelov.georeduy.dal.dao.jpa;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.gonzalomelov.georeduy.dal.dao.AbstractDAO;
import org.gonzalomelov.georeduy.dal.dao.interfaces.PersonDAO;
import org.gonzalomelov.georeduy.dal.model.Person;
import org.gonzalomelov.georeduy.dal.model.Person_;

public class JPAPersonDAO extends AbstractDAO<Person> implements PersonDAO {
	@Override
	public Person findByEmailAndPassword(String email, String password){
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Person> query = builder.createQuery(type);
		Root<Person> root = query.from(Person.class);
		query.select(root);
		Predicate p1 = builder.equal(root.get(Person_.email), email);
		Predicate p2 = builder.equal(root.get(Person_.password), password); 
		query.where(builder.and(p1,p2));
		
		Person person = null;
		List<Person> persons = em.createQuery(query).getResultList();
		if (persons.size() == 1){
			person = persons.get(0);
		}
		
		return person;
	}
	
}
