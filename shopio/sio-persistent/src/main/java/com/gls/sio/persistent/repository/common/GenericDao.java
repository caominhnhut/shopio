package com.gls.sio.persistent.repository.common;

import java.util.List;

public interface GenericDao<T>
{
	T findOne(long id);

	List<T> findAll();

	T create(T entity);

	T update(T entity);

	void delete(T entity);

	void deleteById(long entityId);
}
