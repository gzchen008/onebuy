
package com.vanroid.onebuy.dao;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.hibernate.LockMode;

import com.vanroid.onebuy.common.Pager;

@SuppressWarnings("rawtypes")
public interface BaseDao<T> {

	// 根据主键获取实体，如果没有相应的实体返回null
	T get(Long id);

	// 加锁获取实体
	T getWithLock(Long id, LockMode lock);

	// 如果没有抛出异常
	T load(Long id);

	// 加锁加载实体
	T load(Long id, LockMode lock);

	// 列出所有
	List<T> findAll();

	void updateWithLock(T entity, LockMode lock);

	void save(T entity);

	void saveOrUpdate(T entity);

	void saveOrUpdateAll(Collection<T> entities);

	void delete(T entity);

	void deleteWithLock(T entity, LockMode lock);

	void deleteByKey(Long id);

	void deleteByKeyWithLock(Long id, LockMode lock);

	void deleteAll(Collection<T> entities);

	// ----------------------HQL-----------------------------

	int bulkUpdate(String queryString);

	int bulkUpdate(String queryString, Object... values);

	List<T> find(String queryString);

	List<T> find(String queryString, int firstResult, int maxResult);

	List<T> find(String queryString, Object... values);
	
	List<T> find(String queryString,String paramName,Object value);
	
	List<T> find(String queryString, String[] paramNames, Object[] values);
	
	/**
	 * 提供带参数分页 查询
	 * @param queryString
	 * @param values
	 * @param firstResult
	 * @param maxResult
	 * @return
	 */
	List<T> find(String queryString,Object[] values,int firstResult,int maxResult);
	
	List<T> findByExampleEntity(T exampleEntity);
	
	/**
	 * 查找唯一值
	 * 
	 * @param queryString
	 * @param values
	 * @return
	 */
	<E> E  uniqueResult(String queryString, Object... values);

	/**
	 * 查找列表中的第一个
	 * 
	 * @param queryString
	 * @param goodId
	 */
	<E> E  findFirst(String queryString, Object...values);
	

	Iterator iterator(String queryString, Object... values);

	void closeIterator(Iterator it);

	// _---------------------Criteria----------------

	// ------------------------Other----------------------
	// 加锁指定的实体
	public void lock(T entity, LockMode lockMode);

	// 强制初始化指定的实体
	public void initialize(Object proxy);

	// 强制立即更新缓冲数据到数据库（否则仅在事务提交时才更新）
	public void flush();

	// 查询总个数
	public Long totalCount(String queryString);

	public Long totalCount();

	public Pager findByPager(Pager pager);

}
