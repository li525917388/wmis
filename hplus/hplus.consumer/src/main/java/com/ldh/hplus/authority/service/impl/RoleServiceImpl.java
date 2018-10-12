package com.ldh.hplus.authority.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ldh.hplus.authority.dao.RoleDao;
import com.ldh.hplus.authority.pojo.Role;
import com.ldh.hplus.authority.service.RoleService;
import com.ldh.hplus.common.service.BaseServiceImpl;

@Service
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService {

	@Resource
	private RoleDao roleDao;

	public RoleDao getRoleDao() {
		return roleDao;
	}

	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}
	
	
}
