package com.ldh.hplus.sys.action;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ldh.hplus.common.action.BaseAction;
import com.ldh.hplus.common.service.BaseService;
import com.ldh.hplus.sys.pojo.Menu;
import com.ldh.hplus.sys.service.MenuServcice;

@RestController
@RequestMapping("sys/menu")
public class MenuAction extends BaseAction<Menu>{
	
	@Resource
	MenuServcice menuServcice;

	@Override
	public BaseService<Menu> getService() {
		// TODO Auto-generated method stub
		return menuServcice;
	}

	
	
}
