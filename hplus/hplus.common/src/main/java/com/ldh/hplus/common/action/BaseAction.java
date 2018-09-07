package com.ldh.hplus.common.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;



/**
 * 基础Action
 * @author ldh
 *
 */
public abstract class BaseAction<T> {
	
	public abstract List<T> getList();
	
	@RequestMapping(method=RequestMethod.GET)
	public void list(T base){
		
		List<T> list = getList();
		
		for(T t : list){
			
			System.out.println(t.getClass().getName());
		}
		
		System.out.println("list");
	}
	
	
	@RequestMapping(method=RequestMethod.POST)
	public String add(String id){
		
		System.out.println(id + "===1=" + this.getRequest().getAttribute("id"));
		
		return id + "haha";
	}
	
	/**
	 * 获取request
	 * @return
	 */
	public HttpServletRequest getRequest(){
		
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	}

}
