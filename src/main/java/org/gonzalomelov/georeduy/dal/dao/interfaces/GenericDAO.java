package org.gonzalomelov.georeduy.dal.dao.interfaces;

import java.util.List;

public interface GenericDAO<T> {
	public T insert(T obj) throws Exception;
	public T update(T obj) throws Exception ;
	public void delete(Object id) throws Exception ;
	public T findByPrimaryKey(Object id) throws Exception ;
	public List<T> findAll() throws Exception ;
}
