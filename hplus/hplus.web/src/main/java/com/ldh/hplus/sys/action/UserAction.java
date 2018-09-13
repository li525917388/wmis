package com.ldh.hplus.sys.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ldh.hplus.common.action.BaseAction;
import com.ldh.hplus.common.service.BaseService;
import com.ldh.hplus.sys.pojo.User;
import com.ldh.hplus.sys.service.UserService;

/**
 * 用户Action
 * @author 8
 *
 */
@Controller
@RequestMapping("/sys/user")
public class UserAction extends BaseAction<User> {

	@Resource
	private UserService userService;
	
	@Override
	public BaseService<User> getService() {
		// TODO Auto-generated method stub
		return userService;
	}
	

}
