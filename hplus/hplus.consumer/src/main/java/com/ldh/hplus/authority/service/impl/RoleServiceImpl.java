package com.ldh.hplus.authority.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ldh.hplus.authority.dao.RoleDao;
import com.ldh.hplus.authority.pojo.Role;
import com.ldh.hplus.authority.pojo.RoleMenu;
import com.ldh.hplus.authority.service.RoleService;
import com.ldh.hplus.common.service.BaseServiceImpl;
import com.ldh.hplus.pojo.util.ServiceRes;
import com.ldh.hplus.sys.pojo.Menu;

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

	
	/*
	 * 获得权限菜单树
	 * @see com.ldh.hplus.authority.service.RoleService#getAuthorityMenuTree(java.lang.String)
	 * 2018年12月1日
	 */
	@Override
	public List<Menu> getAuthorityMenuTree(Long uid) {
		return roleDao.getAuthorityMenuTree(uid);
	}

	/*
	 * 更新角色菜单权限
	 * @see com.ldh.hplus.authority.service.RoleService#updateRoleMenus(long, java.lang.String)
	 * 2018年12月1日
	 */
	@Transactional
	@Override
	public ServiceRes updateRoleMenus(long rid, String mids) {
		
		ServiceRes serviceRes = new ServiceRes();
		
		roleDao.delRoleMenuByRid(rid);
		
		if(mids != null && !"".equals(mids)){
			String[] midss = mids.split(",");
			
			List<RoleMenu> list = new ArrayList<RoleMenu>();
			
			for(String mid : midss){
				
				RoleMenu rm = new RoleMenu();
				rm.setMid(Long.valueOf(mid));
				rm.setRid(rid);
				
				list.add(rm);
			}
			
			int res = roleDao.insertRoleMenus(list);

			serviceRes.setData(res);
		}

		serviceRes.setCode(200);
		
		return serviceRes;
	}

	
	
}
