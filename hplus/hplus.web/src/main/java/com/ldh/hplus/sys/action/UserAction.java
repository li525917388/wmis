package com.ldh.hplus.sys.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ldh.hplus.common.action.BaseAction;
import com.ldh.hplus.sys.pojo.User;
import com.ldh.hplus.sys.service.UserService;

/**
 * 用户Action
 * @author 8
 *
 */
@Controller
@RequestMapping("sys/user")
public class UserAction extends BaseAction<User> {

	@Resource
	private UserService userService;
	
	@RequestMapping("addUser")
	public void addUser(){
		
		User user = new User();
		user.setName("aaa");
		user.setPwd("1314");
		userService.addUser(user);
	}

	@Override
	public List<User> getList() {
		// TODO Auto-generated method stub
		List<User> list = userService.queryAllList();
		
		return list;
	}

}
