package com.xianchumo.shop.service;

import java.util.Collection;
import java.util.List;

@SuppressWarnings("rawtypes")
public interface BaseService<T> {

	void add(T entity);

	void update(T entity);

	void delete(T entity);
	
	void deleteAll(Collection<T> entities);
	
	void deleteByKey(Long id);
	
	T get(long id);
	
	T load(long id);

	List findAll();

	List findPageList(String queryString ,int pageIndex, int pageSizes);
}
