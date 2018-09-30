package com.ldh.hplus.sys.action;

import java.io.IOException;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.ldh.hplus.common.action.BaseAction;
import com.ldh.hplus.common.service.BaseService;
import com.ldh.hplus.common.service.RedisService;
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
	
	@Resource
	RedisService redisService;
	
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
		
		//登录token
		String sessionId = BaseConstants.SESSION_USER  + "_" + UUID.randomUUID().toString();
		
		getRequest().getSession().setAttribute(BaseConstants.SESSION_USER, u);	//在session中保存user信息
		
		String domain = getRequest().getServerName();
		System.out.println(domain + "---domain");
		Cookie uasLoginer = new Cookie(BaseConstants.SESSION_USER, sessionId);

		uasLoginer.setDomain(domain); 
		uasLoginer.setMaxAge(60000);  
		uasLoginer.setPath("/"); 
		getResponse().addCookie(uasLoginer); 
		
		UserSession us = new UserSession(u);
		
		String user_json = new Gson().toJson(us);
		
		redisService.set(sessionId,user_json);
		redisService.expireSeconds(sessionId, 600);	//设置时效
		
		resSuccess();
	}
	
	
	/**
	 * 列表页面
	 * @return
	 */
	@RequestMapping("list")
	public String toList(){
		
		return "sys/user/userList";
	}
}
