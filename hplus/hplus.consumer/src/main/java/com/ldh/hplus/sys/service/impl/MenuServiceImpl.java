package com.ldh.hplus.sys.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ldh.hplus.common.service.BaseServiceImpl;
import com.ldh.hplus.sys.dao.MenuDao;
import com.ldh.hplus.sys.pojo.Menu;
import com.ldh.hplus.sys.service.MenuService;

@Service("MenuServcice")
public class MenuServiceImpl extends BaseServiceImpl<Menu> implements MenuService {

	@Resource
	private MenuDao menuDao;

	@Override
	public List<Menu> getLeftMenus(long uid) {
		
		List<Menu> list = menuDao.getHostMenus(uid);
		
		for(Menu m : list){
			Map<String,Object> map = new HashMap<String,Object>();
			
			map.put("uid", uid);
			map.put("pcode", m.getMenuCode());
			
			List<Menu> cms = menuDao.getChildMenus(map);
			
			m.setChildList(cms);
		}
		
		return list;
	}
}
