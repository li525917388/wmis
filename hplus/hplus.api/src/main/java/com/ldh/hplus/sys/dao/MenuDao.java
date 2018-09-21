package com.ldh.hplus.sys.dao;

import java.util.List;
import java.util.Map;

import com.ldh.hplus.sys.pojo.Menu;

/**
 * 菜单dao接口
 * @author Li Dehuan
 *
 */
public interface MenuDao {

	/**
	 * 获取主菜单
	 * @param uid
	 * @return
	 */
	public List<Menu> getHostMenus(long uid);
	
	
	/**
	 * 获取子菜单
	 * @param uid
	 * @pcode 上级菜单编码
	 * @return
	 */
	public List<Menu> getChildMenus(Map<String, Object> map);
}
