package com.ldh.hplus.common.util;

import java.util.List;

/**
 * 数据表格视图模型
 * @author Li Dehuan
 *
 */
public class BaseGrid<T> {

	private int code;
	
	private String msg;
	
	private long count;
	
	private List<T> data;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}
	
	
}
