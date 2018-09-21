package com.ldh.hplus.sys.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ldh.hplus.common.action.BaseAction;
import com.ldh.hplus.common.service.BaseService;
import com.ldh.hplus.sys.pojo.Menu;
import com.ldh.hplus.sys.service.MenuService;

@Controller
@RequestMapping("sys/menu")
public class MenuAction extends BaseAction<Menu>{
	
	@Resource
	MenuService menuServcice;

	@Override
	public BaseService<Menu> getService() {
		// TODO Auto-generated method stub
		return menuServcice;
	}

	
	/**
	 * 列表页面
	 * @return
	 */
	@RequestMapping("list")
	public String toList(){
		
		return "sys/menu/menuList";
	}
	
}
