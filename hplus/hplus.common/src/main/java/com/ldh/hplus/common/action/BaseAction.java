package com.ldh.hplus.common.action;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.ldh.hplus.common.service.BaseService;
import com.ldh.hplus.common.util.BaseGrid;



/**
 * 基础Action
 * @author ldh
 *
 */
public abstract class BaseAction<T> extends SuperAction{
	
	
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
	public void list() throws IOException{
		System.out.println("查找实体列表");
		
		List<T> list = getService().queryAllList();
		
		for(T t : list){
			
			System.out.println(t.getClass().getName());
		}
		
		System.out.println("list");
		
		Gson gson = new Gson();
		
		BaseGrid<T> bg = new BaseGrid<T>();
		
		bg.setRows(list);
		bg.setPage(1);
		bg.setRecords(200);
		
		String json = gson.toJson(bg);
		
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
	

	
	/**
	 * 插入action方法
	 * @param t
	 * @throws IOException 
	 */
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public void add(T t) throws IOException{
		System.out.println("新增");
		
//		getService().insert(t);

		getResponse().getWriter().print("true");
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
	
}
