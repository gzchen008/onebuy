package com.vanroid.onebuy.service;

import java.util.Collection;
import java.util.List;

import com.vanroid.onebuy.common.Pager;

@SuppressWarnings("rawtypes")
public interface BaseService<T> {

	void add(T entity);

	void update(T entity);

	void delete(T entity);
	
	void deleteAll(Collection<T> entities);
	
	void saveOrUpdateAll(Collection<T> entities);
	
	void deleteByKey(Long id);
	
	T get(long id);
	
	T load(long id);

	List<T> findAll();

	List<T> findPageList(String queryString ,int pageIndex, int pageSizes);
	
	Pager findByPager(Pager pager);
}
