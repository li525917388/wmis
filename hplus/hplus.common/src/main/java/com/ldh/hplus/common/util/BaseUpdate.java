package com.ldh.hplus.common.util;

import java.util.Map;

/**
 * 更新参数实体
 * @author 8
 *
 */
public class BaseUpdate {

	private String table;			//表名
	
	private Long id;	
	
	private Map<String, Object> data;

	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}
	
	
}
