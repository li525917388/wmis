package com.ldh.hplus.common.dao;

import java.util.List;
import java.util.Map;

import com.ldh.hplus.common.model.BaseDaoPara;


/**
 * 基础dao
 * @author 8
 *
 */
public interface BaseDao<T> {
	
	public List<Map<String, Object>> getBean(BaseDaoPara bdp);

}
