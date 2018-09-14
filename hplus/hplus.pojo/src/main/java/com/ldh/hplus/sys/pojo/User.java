package com.ldh.hplus.sys.pojo;

import com.ldh.hplus.common.model.BaseBean;


/**
 * 用户
 * @author ldh
 *
 */
public class User extends BaseBean {

	private String name;		//姓名
	
	private String pwd;			//密码
	
	private String account;		//账号
	
	private int sex;			//性别
	
	private String icon;		//头像

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

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

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	
}
