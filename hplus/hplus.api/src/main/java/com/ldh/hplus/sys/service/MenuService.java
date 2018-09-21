package com.ldh.hplus.sys.service;

import java.util.List;

import com.ldh.hplus.common.service.BaseService;
import com.ldh.hplus.sys.pojo.Menu;

/**
 * 菜单service
 * @author Li Dehuan
 *
 */
public interface MenuService extends BaseService<Menu> {

	
	/**
	 * 获得左侧菜单
	 * @param uid
	 * @return
	 */
	public List<Menu> getLeftMenus(long uid);
}
