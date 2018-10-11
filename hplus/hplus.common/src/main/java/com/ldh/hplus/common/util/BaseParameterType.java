package com.ldh.hplus.common.util;

import java.util.List;


/**
 * 
 * @author ldh
 *
 */
public class BaseParameterType {

	private String table;				//表名
	
	private long id;					//主键
	
	private List<Long> ids;
	
	private Filter fielter;			//
	
	private long statr;
	
	private long end;

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

	public long getStatr() {
		return statr;
	}

	public void setStatr(long statr) {
		this.statr = statr;
	}

	public long getEnd() {
		return end;
	}

	public void setEnd(long end) {
		this.end = end;
	}

	public List<Long> getIds() {
		return ids;
	}

	public void setIds(List<Long> ids) {
		this.ids = ids;
	}

	
}
