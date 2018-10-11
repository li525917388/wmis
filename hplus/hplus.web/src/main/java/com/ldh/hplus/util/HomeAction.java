package com.ldh.hplus.util;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ldh.hplus.common.action.SuperAction;
import com.ldh.hplus.common.util.BaseConstants;
import com.ldh.hplus.sys.pojo.Menu;
import com.ldh.hplus.sys.pojo.User;
import com.ldh.hplus.sys.service.MenuService;

@Controller
public class HomeAction extends SuperAction{
	
	@Resource
	private MenuService menuService;
	
	/**
	 * home页面
	 * @return
	 */
	@RequestMapping("home")
	public String home(){
		
		System.out.println("访问主页");
		
		return "home";
	}

	@RequestMapping("/main")
	public String toMain(){
		
		System.out.println("访问main");
		
		User user = (User) getRequest().getSession().getAttribute(BaseConstants.SESSION_USER);
		
		List<Menu> list = menuService.getLeftMenus(user.getId());
		
		getRequest().getSession().setAttribute(BaseConstants.USER_ROLE_MENUS, list);
		
		return "layout/main";
	}
}
