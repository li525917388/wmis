package com.ldh.hplus.authority.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ldh.hplus.authority.pojo.Button;
import com.ldh.hplus.authority.service.ButtonService;
import com.ldh.hplus.common.action.BaseAction;
import com.ldh.hplus.common.service.BaseService;

/**
 * 按钮controller
 * @author Li Dehuan
 * @date 2018年11月13日
 *
 */
@Controller
@RequestMapping("authority/button")
public class ButtonAction extends BaseAction<Button> {
	
	@Resource
	ButtonService buttonService;

	@Override
	public BaseService<Button> getService() {
		// TODO Auto-generated method stub
		return buttonService;
	}

	
	/**
	 * 列表页面
	 * @return
	 */
	@RequestMapping("/list")
	public String toList(){
		
		return "authority/button/buttonList";
	}
	
	
	/**
	 * 编辑页面
	 * @return
	 */
	@RequestMapping(value="/edit/{id}",method=RequestMethod.GET)
	public String toEditPage(@PathVariable("id")Long id,String oper){
		System.out.println("角色编辑页面。" + id);
		
		Button button = buttonService.getBeanById(id);		//获取菜单

		getRequest().setAttribute("buttonEntity", button);
		getRequest().setAttribute("oper", oper);

		return "authority/button/buttonForm";
	}
	
}
