package com.ldh.hplus.sys.pojo;

import com.ldh.hplus.common.model.BaseBean;


/**
 * 用户
 * @author ldh
 *
 */
public class User extends BaseBean {

	private String name;
	
	private String pwd;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	
}
