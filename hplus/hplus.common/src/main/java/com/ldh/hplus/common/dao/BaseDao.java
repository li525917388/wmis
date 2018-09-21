package com.ldh.hplus.common.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ldh.hplus.common.util.BaseInsert;
import com.ldh.hplus.common.util.BaseParameterType;
import com.ldh.hplus.common.util.BaseUpdate;


/**
 * 基础dao
 * @author ldh
 *
 */
public interface BaseDao<T> {
	
	/**
	 * 
	 * @param bpt
	 * @return
	 */
	public Map<String, Object> getBean(BaseParameterType bpt);
	
	/**
	 * 获得全部数据
	 * @return
	 */
	public List<Map<String, Object>> getAllList(@Param(value="table")String table);
	
	
	
	/**
	 * 插入数据
	 * @param t
	 * @return
	 */
	public long insert(BaseInsert bt);
	
	
	
	/**
	 * 删除
	 * @return
	 */
	public int delete(BaseParameterType bpt);
	
	
	/**
	 * 更新
	 * @param bt
	 * @return
	 */
	public int update(BaseUpdate bu);
	
	
	/**
	 * 获得l列表数据
	 * @return
	 */
	public List<Map<String, Object>> getListByFilter(BaseParameterType parameterType);
	
	
	
	/**
	 * 获得列表总记录
	 * @return
	 */
	public long getCountByFilter(BaseParameterType parameterType);
}
