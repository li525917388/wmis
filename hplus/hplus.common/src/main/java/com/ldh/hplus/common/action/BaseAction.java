package com.ldh.hplus.common.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.google.gson.Gson;
import com.ldh.hplus.common.service.BaseService;



/**
 * 基础Action
 * @author ldh
 *
 */
public abstract class BaseAction<T> {
	
	
	/**
	 *获取service
	 * @return
	 */
	public abstract BaseService<T> getService();
	
	
	
	/**
	 * 列表
	 * @param base
	 * @throws IOException 
	 */
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	public void list(T base) throws IOException{
		System.out.println("查找实体列表");
		
		List<T> list = getService().queryAllList();
		
		for(T t : list){
			
			System.out.println(t.getClass().getName());
		}
		
		System.out.println("list");
		
		Gson gson = new Gson();
		
		String json = gson.toJson(list);
		
		System.out.println(json);
		
		getResponse().getWriter().print(json);
	}
	
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	@ResponseBody
	public void getBean(@PathVariable("id")Long id) throws IOException{
		System.out.println("查找实体");
		System.out.println("id:" + id);
		
		
		T t = getService().getBeanById(id);
		
		Gson gson = new Gson();
		
		String json = gson.toJson(t);
		
		System.out.println(json);
		
		getResponse().getWriter().print(json);
	}
	
	
	@RequestMapping(value="/edit/{id}",method=RequestMethod.GET)
	public String toEditPage(){
		
		
		
		return "/WEB-INF/page/user.jsp";
	}
	
	
	/**
	 * 插入action方法
	 * @param t
	 */
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public void add(T t){
		System.out.println("新增");
		
		getService().insert(t);

	}
	
	
	/**
	 * 删除
	 * @param id
	 */
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	@ResponseBody
	public void remove(@PathVariable("id")Long id){
		System.out.println("删除");
		System.out.println("id:" + id );
		getService().delete(id);
	}
	
	
	/**
	 * 更新
	 * @param t
	 */
	@RequestMapping(method=RequestMethod.PUT)
	@ResponseBody
	public void update(T t){
		System.out.println("更新 ");
		
		getService().update(t);
	}
	
	
	
	@ModelAttribute
	public void myModel(){
		System.out.println("myModel-----");
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

}
