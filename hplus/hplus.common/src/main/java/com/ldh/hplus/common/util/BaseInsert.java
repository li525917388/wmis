package com.ldh.hplus.common.util;

import java.util.List;

public class BaseInsert {

	private String table;			//表名
	
	private Long id;
	
	private List<String> fieldList;
	
	private List<Object> valueList;

	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

	public List<String> getFieldList() {
		return fieldList;
	}

	public void setFieldList(List<String> fieldList) {
		this.fieldList = fieldList;
	}

	public List<Object> getValueList() {
		return valueList;
	}

	public void setValueList(List<Object> list) {
		valueList = list;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
