package com.ldh.hplus.interceptor;

import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.ldh.hplus.common.annotation.LDHPermission;
import com.ldh.hplus.common.util.BaseConstants;
import com.ldh.hplus.pojo.util.UserSession;
import com.ldh.hplus.sys.pojo.User;

/**
 * 拦截器
 * 
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

	@Autowired
	StringRedisTemplate stringRedisTemplate;

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("afterCompletion");
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse arg1, Object arg2, ModelAndView view)
			throws Exception {
		// TODO Auto-generated method stub
		String contextPath = request.getContextPath();
		if (view != null) {
			request.setAttribute("base", contextPath);
		}

		System.out.println("postHandle");
	}

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		System.out.println("验证登录状态----");

		// 验证登录状态
		if(checkLogin(request)) {

			//验证按钮权限
			if(checkPermission(request, handler)){
				
				return true;
			}else{
				
				response.getWriter().print("{\"msg\":\"没有权限\"}");
				
				return false;
			}

		}
		
		response.sendRedirect(request.getContextPath() + "/login.jsp");

		return false;
	}

	/**
	 * 验证登录状态
	 * 
	 * @param request
	 * @return
	 */
	public boolean checkLogin(HttpServletRequest request) {
		System.out.println("验证登录权限");
		// 获取sessionId
		String session = request.getParameter("sessionId");

		if (session == null) {
			// 从cookie中取值
			Cookie[] cookies = request.getCookies();

			if (cookies != null) {
				for (int i = 0; i < cookies.length; i++) {

					if (BaseConstants.SESSION_USER.equals(cookies[i].getName())) {

						session = cookies[i].getValue();
						break;
					}
				}
			}
		}

		// 从session里查找当前会话用户
		User user = (User) request.getSession().getAttribute(
				BaseConstants.SESSION_USER);

		if (user == null) {

			if (session != null) {

				String user_session = stringRedisTemplate.opsForValue().get(
						session);

				if (user_session != null) {

					// 取Redis中的user值
					UserSession jedis_userSession = new Gson().fromJson(
							user_session, UserSession.class);

					long lt = jedis_userSession.getLastTime();

					// 判断登录是否超时
					if (new Date().getTime() - lt < (redis_timeout * 1000)) {

						request.getSession().setAttribute(
								BaseConstants.SESSION_USER,
								jedis_userSession.getUser());

						return true;
					}
				}
			}
		} else {

			return true;
		}

		return false;
	}

	/**
	 * 检验按钮权限
	 * 
	 * @param request
	 * @return
	 */
	public boolean checkPermission(HttpServletRequest request, Object handler) {
		System.out.println("验证按钮权限");
		
		HandlerMethod method = (HandlerMethod) handler;

		LDHPermission permission = method
				.getMethodAnnotation(LDHPermission.class);

		// 如果为空在表示该方法不需要进行权限验证
		if (permission == null) {

			return true;
		}

		
		
		return false;
	}
}
