package com.xianchumo.shop.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.xianchumo.shop.dao.BaseDao;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {

	/**
	 * Dao操作的类的类型
	 */
	private Class clazz = null;

	@Autowired
	public void setSessionFactoryOverride(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
		
	}

	public BaseDaoImpl() {
		// 获得Dao操作的类的类型
		ParameterizedType pt = (ParameterizedType) this.getClass()
				.getGenericSuperclass();
		this.clazz = (Class) pt.getActualTypeArguments()[0];
	}

	// 根据主键获取实体。如果没有相应的实体，返回 null
	public T get(Long id) {
		getHibernateTemplate().setCacheQueries(true);
		return (T) getHibernateTemplate().get(clazz, id);
	}

	// 根据主键获取实体并加锁。如果没有相应的实体，返回 null。
	public T getWithLock(Long id, LockMode lock) {
		T t = (T) getHibernateTemplate().get(clazz, id, lock);
		if (t != null) {
			this.flush(); // 立即刷新，否则锁不会生效。
		}
		return t;
	}

	// 根据主键获取实体。如果没有相应的实体，抛出异常。
	public T load(Long id) {
		return (T) getHibernateTemplate().load(clazz, id);
	}

	// 根据主键获取实体并加锁。如果没有相应的实体，抛出异常。
	public T load(Long id, LockMode lock) {
		T t = (T) getHibernateTemplate().load(clazz, id, lock);
		if (t != null) {
			this.flush(); // 立即刷新，否则锁不会生效。
		}
		return t;
	}

	// 获取全部实体。
	public List<T> findAll() {
		return (List<T>) getHibernateTemplate().loadAll(clazz);
	}

	// 更新实体并加锁
	public void updateWithLock(T entity, LockMode lock) {
		getHibernateTemplate().update(entity, lock);
		this.flush(); // 立即刷新，否则锁不会生效。
	}

	// 存储实体到数据库
	public void save(T entity) {
		getHibernateTemplate().save(entity);
	}

	// 增加或更新实体
	public void saveOrUpdate(T entity) {
		getHibernateTemplate().saveOrUpdate(entity);
	}

	// 增加或更新集合中的全部实体
	public void saveOrUpdateAll(Collection<T> entities) {
		for (T t : entities) {
			getHibernateTemplate().saveOrUpdate(t);
		}
	}

	// 删除指定的实体
	public void delete(T entity) {
		getHibernateTemplate().delete(entity);
	}

	// 加锁并删除指定的实体
	public void deleteWithLock(T entity, LockMode lock) {
		getHibernateTemplate().delete(entity, lock);
		this.flush();
	}

	// 根据主键删除指定实体
	public void deleteByKey(Long id) {
		this.delete(this.load(id));
	}

	// 根据主键加锁并删除指定的实体
	public void deleteByKeyWithLock(Long id, LockMode lock) {
		this.deleteWithLock(this.load(id), lock);
	}

	@Override
	public void deleteAll(Collection<T> entities) {
		getHibernateTemplate().deleteAll(entities);
	}

	// -------------------------------HQL-------------------------------------//
	// 使用HSQL语句直接增加、更新、删除实体
	public int bulkUpdate(String queryString) {
		return getHibernateTemplate().bulkUpdate(queryString);
	}

	// 使用带参数的HSQL语句增加、更新、删除实体
	public int bulkUpdate(String queryString, Object[] values) {
		return getHibernateTemplate().bulkUpdate(queryString, values);
	}

	// 使用HSQL语句检索数据
	public List find(String queryString) {
		return getHibernateTemplate().find(queryString);
	}

	public List<T> find(String queryString,int firstResult,int maxResult){
		return this.getHibernateTemplate()//
				.getSessionFactory()//
				.openSession()//
				.createQuery(queryString)//
				.setFirstResult(firstResult)//
				.setMaxResults(maxResult)//
				.list();
	}

	// 使用带参数的HSQL语句检索数据
	public List find(String queryString, Object... values) {
		return getHibernateTemplate().find(queryString, values);
	}

	// 使用带命名的参数的HSQL语句检索数据
	public List find(String queryString, String[] paramNames, Object[] values) {
		return getHibernateTemplate().findByNamedParam(queryString, paramNames,
				values);
	}

	// 使用HSQL语句检索数据，返回 Iterator
	public Iterator iterator(String queryString, Object... values) {
		return getHibernateTemplate().iterate(queryString);

	}

	// 关闭检索返回的 Iterator
	public void closeIterator(Iterator it) {
		getHibernateTemplate().closeIterator(it);
	}

	// ------------------------------------------------------
	// 加锁指定的实体
	public void lock(T entity, LockMode lock) {
		getHibernateTemplate().lock(entity, lock);
	}

	// 强制初始化指定的实体
	public void initialize(Object proxy) {
		getHibernateTemplate().initialize(proxy);
	}

	// 强制立即更新缓冲数据到数据库（否则仅在事务提交时才更新）
	public void flush() {
		getHibernateTemplate().flush();
	}
}
