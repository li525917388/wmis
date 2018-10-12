package com.ldh.hplus.authority.pojo;

import com.ldh.hplus.common.model.BaseBean;

/**
 * 角色
 * @author Li Dehuan
 * @date 2018年10月12日
 *
 */
public class Role extends BaseBean {

	private String roleName;		//角色名称
	
	private String roleCode;		//角色编码
	
	private String roleType;		//角色类型

	private String describe;		//描述

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}
	
	
}
