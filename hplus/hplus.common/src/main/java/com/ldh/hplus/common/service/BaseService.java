package com.ldh.hplus.common.service;

import java.util.List;

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
}
