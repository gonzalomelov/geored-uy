package org.gonzalomelov.georeduy.dal.dao;

import java.util.List;

public interface GenericDAO<T> {
	public T insert(T obj);
	public T update(T obj);
	public void delete(Object id);
	public T findByPrimaryKey(Object id);
	public List<T> findAll();
}
