package com.ldh.hplus.authority.service;

import java.util.List;

import com.ldh.hplus.authority.pojo.Role;
import com.ldh.hplus.common.service.BaseService;
import com.ldh.hplus.pojo.util.ServiceRes;
import com.ldh.hplus.sys.pojo.Menu;

/**
 * 角色service接口
 * @author Li Dehuan
 * @date 2018年10月12日
 *
 */
public interface RoleService extends BaseService<Role> {

	
	/**
	 * 获取权限菜单树
	 * @param uid
	 * @return
	 */
	List<Menu> getAuthorityMenuTree(Long uid);
	
	
	/**
	 * 更新角色菜单权限
	 * @param rid
	 * @param mids
	 * @return
	 */
	ServiceRes updateRoleMenus(long rid, String mids);
}
