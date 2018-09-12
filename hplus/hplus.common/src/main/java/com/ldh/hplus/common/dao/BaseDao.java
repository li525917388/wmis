package com.ldh.hplus.common.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ldh.hplus.common.util.BaseParameterType;


/**
 * 基础dao
 * @author 8
 *
 */
public interface BaseDao<T> {
	
	/**
	 * 
	 * @param bpt
	 * @return
	 */
	public List<Map<String, Object>> getBean(BaseParameterType bpt);
	
	/**
	 * 
	 * @return
	 */
	public List<Map<String, Object>> getAllList(@Param(value="table")String table);

}
