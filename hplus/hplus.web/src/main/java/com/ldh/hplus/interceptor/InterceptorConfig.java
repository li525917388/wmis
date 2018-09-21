package com.ldh.hplus.interceptor;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import redis.clients.jedis.Jedis;

import com.google.gson.Gson;
import com.ldh.hplus.common.util.BaseConstants;
import com.ldh.hplus.pojo.util.UserSession;
import com.ldh.hplus.sys.pojo.User;

/**
 * 拦截器
 * @author ldh
 *
 */
@Component
public class InterceptorConfig implements HandlerInterceptor {
	
	@Value("${ldh.name}")
	private String name;
	
	@Value("${ldh.redis.host}")
	private String redis_host;
	
	@Value("${ldh.redis.port}")
	private int redis_port;
	
	@Value("${ldh.redis.timeout}")
	private long redis_timeout;

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("afterCompletion");
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("postHandle");
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2) throws Exception {
		System.out.println("preHandle" + name);
		
		//获取sessionId
		String session = request.getParameter("sessionId");
		
		System.out.println(session);
		
		//从session里查找当前会话用户
		User user = (User) request.getSession().getAttribute(BaseConstants.SESSION_USER);
		
		//判断是否登录
		if(user == null){
			
			if(session == null){
				
				response.sendRedirect(request.getContextPath()+"/login.jsp");
				
				return false;
			}
			
			//打开Redis
			Jedis jedis = new Jedis(redis_host,redis_port);
			
			//获取user_session
			String user_session = jedis.get(session);

			jedis.close();//关闭连接
			
			if(user_session == null){
				
				response.sendRedirect(request.getContextPath()+"/login.jsp");	

			}else{
				
				UserSession jedis_userSession = new Gson().fromJson(user_session, UserSession.class);
				
				long lt = jedis_userSession.getLastTime();
				
				if(new Date().getTime() - lt < (redis_timeout * 1000)){
					
					request.getSession().setAttribute(BaseConstants.SESSION_USER, jedis_userSession.getUser());

					return true;
				}

			}			
			
		}else{
			
			return true;
		}
		
		response.sendRedirect(request.getContextPath()+"/login.jsp");
		return false;
	}

}
