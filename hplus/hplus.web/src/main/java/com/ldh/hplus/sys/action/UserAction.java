package com.ldh.hplus.sys.action;

import java.io.IOException;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import redis.clients.jedis.Jedis;

import com.google.gson.Gson;
import com.ldh.hplus.common.action.BaseAction;
import com.ldh.hplus.common.service.BaseService;
import com.ldh.hplus.common.util.BaseConstants;
import com.ldh.hplus.pojo.util.UserSession;
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
	
	@Value("${ldh.name}")
	private String name;
	
	@Override
	public BaseService<User> getService() {
		// TODO Auto-generated method stub
		return userService;
	}
	

	/**
	 * 登录
	 * @param user
	 * @throws IOException
	 */
	@RequestMapping("login")
	@ResponseBody
	public void login(User user) throws IOException{
		
		System.out.println(name + "登录，账号：" + user.getAccount());
		
		User u = userService.login(user);
		
		if(u == null){
			
			resError("301", "用户或密码错误");
			
			return;
		}
		
		String sessionId = u.getAccount();
		
		getRequest().getSession().setAttribute(BaseConstants.SESSION_USER, u);
		
		//打开Redis
		Jedis jedis = new Jedis("localhost",6379);
		
		UserSession us = new UserSession(u);
		
		String user_json = new Gson().toJson(us);
		
		jedis.set(sessionId,user_json);
		
		jedis.close();
		
		resSuccess();
	}
}
