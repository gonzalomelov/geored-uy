package org.gonzalomelov.georeduy.dal.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public abstract class AbstractDAO<T> implements GenericDAO<T>{

	@PersistenceContext
	public EntityManager em;
	
	public Class<T> type;
	
	@SuppressWarnings(value = { "unchecked", "rawtypes" })
	public AbstractDAO(){
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		type = (Class) pt.getActualTypeArguments()[0];
	}
	
	@Override
	public T insert(T t) {
		em.persist(t);
		return t;
	}

	@Override
	public T update(T t) {
		em.merge(t);
		return t;
	}

	@Override
	public void delete(Object id) {
		em.remove(em.getReference(type, id));
	}

	@Override
	public T findByPrimaryKey(Object id) {
		return (T) em.find(type, id);
	}

	@Override
	public List<T> findAll() {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<T> query = builder.createQuery(type);
		Root<T> root = query.from(type);
		query.select(root);
		return em.createQuery(query).getResultList();
	}

}
