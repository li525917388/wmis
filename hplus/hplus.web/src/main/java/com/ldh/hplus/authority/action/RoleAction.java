package com.ldh.hplus.authority.action;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ldh.hplus.authority.pojo.Role;
import com.ldh.hplus.authority.service.RoleService;
import com.ldh.hplus.common.action.BaseAction;
import com.ldh.hplus.common.service.BaseService;
import com.ldh.hplus.sys.pojo.Dictionary;
import com.ldh.hplus.sys.service.DictionaryService;

/**
 * 角色controller
 * @author Li Dehuan
 * @date 2018年10月12日
 *
 */
@Controller
@RequestMapping("authority/role")
public class RoleAction extends BaseAction<Role> {
	
	@Resource
	RoleService roleService;
	
	@Resource
	DictionaryService dictionaryService;

	@Override
	public BaseService<Role> getService() {
		// TODO Auto-generated method stub
		return this.roleService;
	}

	
	/**
	 * 列表页面
	 * @return
	 */
	@RequestMapping("/list")
	public String toList(){
		
		return "authority/role/roleList";
	}
	
	
	/**
	 * 编辑页面
	 * @return
	 */
	@RequestMapping(value="/edit/{id}",method=RequestMethod.GET)
	public String toEditPage(@PathVariable("id")Long id,String oper){
		System.out.println("角色编辑页面。" + id);
		
		Role role = roleService.getBeanById(id);		//获取菜单
		
		List<Dictionary> typeList = dictionaryService.getDicListByType("roleType");
		
		getRequest().setAttribute("roleEntity", role);
		getRequest().setAttribute("oper", oper);
		getRequest().setAttribute("roleTypeList", typeList);
		
		return "authority/role/roleForm";
	}
	
	
	/**
	 * 编辑页面
	 * @return
	 */
	@RequestMapping(value="/authority/{id}",method=RequestMethod.GET)
	public String toAuthorityPage(@PathVariable("id")Long id,String oper){
		System.out.println("角色编辑页面。" + id);
		
		Role role = roleService.getBeanById(id);		//获取菜单
		
		List<Dictionary> typeList = dictionaryService.getDicListByType("roleType");
		
		getRequest().setAttribute("roleEntity", role);
		getRequest().setAttribute("oper", oper);
		getRequest().setAttribute("roleTypeList", typeList);
		
		return "authority/role/authorityForm";
	}
}
