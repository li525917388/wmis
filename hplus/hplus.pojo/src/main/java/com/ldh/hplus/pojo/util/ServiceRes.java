package com.ldh.hplus.pojo.util;

/**
 * service返回对象
 * @author Li Dehuan
 * @date 2018年12月1日
 *
 */
public class ServiceRes {

	private int code;
	
	private String msg;
	
	private Object data;

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

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	
}
