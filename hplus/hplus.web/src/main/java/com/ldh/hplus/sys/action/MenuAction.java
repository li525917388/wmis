package com.ldh.hplus.sys.action;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ldh.hplus.common.action.BaseAction;
import com.ldh.hplus.sys.pojo.Menu;

@Controller
@RequestMapping("sys/menu")
public class MenuAction extends BaseAction<Menu>{

	@Override
	public List<Menu> getList() {
		
		return null;
		
	}

	
}
