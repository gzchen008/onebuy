package com.vanroid.onebuy.core.cache;

/**
 * 
 * @company vanroid.com
 * @author cgz
 * @date 2016年1月23日
 * @version 1.0
 * @description 緩存处理
 */
public interface CacheHandler<T> {
	/**
	 * 获取缓存中的某个实体
	 * 
	 * @param id
	 * @return
	 */
	public T get(Long id);

	/**
	 * 添加某个持久化实体到缓存
	 * 
	 * @param entity
	 */
	public void add(T entity);
}
