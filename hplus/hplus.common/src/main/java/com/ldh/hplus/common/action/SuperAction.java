package com.ldh.hplus.common.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.google.gson.Gson;
import com.ldh.hplus.common.util.LdhResponse;

/**
 * 父类action
 * @author Li Dehaun
 *
 */
public class SuperAction {

	/**
	 * 返回成功
	 * @throws IOException 
	 */
	public void resSuccess() throws IOException{
		
		LdhResponse res = new LdhResponse();
		
		res.setIsSuccess(1);
		res.setResCode("200");
		
		returnJson(res);
	}
	
	
	/**
	 * 返回成功
	 * @throws IOException 
	 */
	public void resSuccess(Object o) throws IOException{
		
		LdhResponse res = new LdhResponse();
		
		res.setIsSuccess(1);
		res.setResCode("200");
		res.setData(o);
		
		returnJson(res);
	}
	
	
	/**
	 * 返回失败
	 * @param errorCode
	 * @param msg
	 * @throws IOException 
	 */
	public void resError(String errorCode, String msg) throws IOException{
		
		LdhResponse res = new LdhResponse();
		
		res.setIsSuccess(0);
		res.setResCode(errorCode);
		res.setMsg(msg);
		
		returnJson(res);
	}
	
	/**
	 * 获取request
	 * @return
	 */
	public HttpServletRequest getRequest(){
		
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	}
	
	
	/**
	 * 获取response
	 * @return
	 */
	public HttpServletResponse getResponse(){
		
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
	}

	
	/**
	 * 自定义返回数据
	 * @param o
	 * @throws IOException
	 */
	public void returnJson(Object o) throws IOException{
		
		Gson gson = new Gson();
		
		String json = gson.toJson(o);
		
		returnJson(json);
	}
	
	
	/**
	 * 返回自定义json字符串
	 * @param str
	 * @throws IOException
	 */
	public void returnJson(String str) throws IOException{
		
		getResponse().getWriter().print(str);
	}
}
