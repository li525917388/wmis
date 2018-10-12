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
	 * 获得分页列表
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public BaseGrid<T> queryListAndTotal(int page, int pageSize);
	
	
	/**
	 * 插入数据
	 * @param t
	 * @return
	 */
	public long insert(T t);
	
	
	/**
	 * 插入或修改数据，根据id是否有值
	 * @param t
	 * @return
	 */
	public long save(T t);
	
	
	
	/**
	 * 删除
	 * @return
	 */
	public int delete(long id);
	
	
	
	/**
	 * 删除
	 * @return
	 */
	public int deleteList(String ids);
	
	
	
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
