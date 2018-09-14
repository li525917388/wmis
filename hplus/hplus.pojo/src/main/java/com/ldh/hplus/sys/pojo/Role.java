package com.ldh.hplus.sys.pojo;

import com.ldh.hplus.common.model.BaseBean;

/**
 * 角色
 * @author ldh
 *
 */
public class Role extends BaseBean{
	
	private String roleName;		//角色名称
	
	private String roleCode;		//角色编码

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

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}
	
	
}
