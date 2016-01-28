package com.vanroid.onebuy.service.impl;



import java.util.Collection;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.vanroid.onebuy.common.Pager;
import com.vanroid.onebuy.dao.BaseDao;
import com.vanroid.onebuy.service.BaseService;

@SuppressWarnings("rawtype")
@Transactional(readOnly=false)
public class BaseServiceImpl<T> implements BaseService<T>{

	protected BaseDao<T> dao;

	public BaseDao<T> getDao() {
		return dao;
	}

	public void setDao(BaseDao<T> dao) {
		this.dao = dao;
	}

	@Override
	public void add(T entity) {
		dao.save(entity);
	}

	@Override
	public void update(T entity) {
		dao.saveOrUpdate(entity);
	}

	@Override
	public void delete(T entity) {
		dao.delete(entity);
	}

	@Override
	public void deleteAll(Collection<T> entities) {
		dao.deleteAll(entities);	
	}
	
	@Override
	public void deleteByKey(Long id) {
		dao.deleteByKey(id);
		
	}

	@Override
	public T get(long id) {
		return dao.get(id);
	}

	@Override
	public List findAll() {
		return dao.findAll();
	}
	
	@Override
	public List findPageList(String queryString,int pageIndex, int pageSize) {
		return dao.find(queryString, pageIndex*pageSize,pageSize);
	}

	@Override
	public T load(long id) {
		return dao.load(id);
	}

	@Override
	public void saveOrUpdateAll(Collection<T> entities) {
		dao.saveOrUpdateAll(entities);
	}
	
	
	@Override
	public List<T> findByExampleEntity(T exampleEntity) {
		return dao.findByExampleEntity(exampleEntity);
	}

	@Override
	public Pager findByPager(Pager pager) {
		return dao.findByPager(pager);
	}
	
	
}
