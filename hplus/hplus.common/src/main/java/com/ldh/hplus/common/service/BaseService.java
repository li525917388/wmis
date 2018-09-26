package com.ldh.hplus.common.service;

import java.util.List;

import com.ldh.hplus.common.util.BaseGrid;
import com.ldh.hplus.common.util.Filter;

/**
 * 基础service
 * @author 8
 *
 * @param <BaseBean>
 */
public interface BaseService<T> {

	/**
	 * 根据id获得实体
	 * @param id
	 * @return
	 */
	public T getBeanById(long id);
	
	/**
	 * 获得全部实体
	 * @return
	 */
	public List<T> queryAllList();
	
	
	/**
	 * 插入数据
	 * @param t
	 * @return
	 */
	public long insert(T t);
	
	
	
	/**
	 * 删除
	 * @return
	 */
	public int delete(long id);
	
	
	
	/**
	 * 更新
	 * @param t
	 * @return
	 */
	public long update(T t);
	
	
	
	/**
	 * 获得数据列表
	 * @param filter
	 * @return
	 */
	public BaseGrid<T> getGridList(Filter filter,int page,int pageSize);
}
