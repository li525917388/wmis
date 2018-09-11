package com.ldh.hplus.common.util;


/**
 * 
 * @author ldh
 *
 */
public class BaseParameterType {

	private String table;				//表名
	
	private long id;					//主键
	
	private Filter fielter;			//

	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Filter getFielter() {
		return fielter;
	}

	public void setFielter(Filter fielter) {
		this.fielter = fielter;
	}

	
}
