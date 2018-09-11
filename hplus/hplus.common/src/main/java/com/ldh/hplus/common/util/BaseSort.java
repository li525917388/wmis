package com.ldh.hplus.common.util;

/**
 * 排序工具类
 * @author 8
 *
 */
public class BaseSort {

	private String property; 			//属性
	
	private String type = "asc";		//排序方式

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
