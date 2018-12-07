package com.ldh.hplus.authority.dao;

import java.util.List;

import com.ldh.hplus.authority.pojo.RoleMenu;
import com.ldh.hplus.sys.pojo.Menu;

/**
 * 角色dao层接口
 * @author Li Dehuan
 * @date 2018年10月12日
 *
 */
public interface RoleDao {

	/**
	 * 获取权限菜单树
	 * @param uid
	 * @return
	 */
	List<Menu> getAuthorityMenuTree(Long uid);
	
	
	
	/**
	 * 删除角色菜单
	 * @param rid
	 * @return
	 */
	int delRoleMenuByRid(long rid);
	
	
	
	/**
	 * 插入角色权限菜单
	 * @param list
	 * @return
	 */
	int insertRoleMenus(List<RoleMenu> list);
}
