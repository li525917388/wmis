package com.ldh.hplus.common.service;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ldh.hplus.common.dao.BaseDao;
import com.ldh.hplus.common.model.BaseDaoPara;

@Service("BaseService")
public class BaseServiceImpl<T> implements BaseService<T> {

	@Resource
	private BaseDao<T> dao;
	
	
	public String getBeanType(){
		
		Type type = this.getClass().getGenericSuperclass();	
		//通过这个方法获取了一个Type对象，里面实际上包含了类的各种基本信息，如成员变量、方法、类名和泛型的信息...
		ParameterizedType pt = (ParameterizedType)type;
		
		Type[] args = pt.getActualTypeArguments();	//这是一包含了所有的泛型类型 信息的个数组
		
		return args[0].getTypeName();
	}
	
	public String getTableName(){
		
		String name = getBeanType();
		
		String[] ar = name.split("\\.");

		return ar.length == 0 ? null : ar[ar.length - 1].toLowerCase();
	}
	
	/**
	 * 获得参数对象
	 * @return
	 */
	public BaseDaoPara getPara(){
		BaseDaoPara bdp = new BaseDaoPara();

		String table = getTableName();
		bdp.setTable(table);
		
		return bdp;
	}

	@Override
	public T getBeanById(long id) {

		System.out.println("baseService" + id);

		List<Map<String, Object>> list = dao.getBean(getPara());
		
		System.out.println(list);
		
		return null;
	}

	@Override
	public List<T> queryAllList() {
		// TODO Auto-generated method stub
		
		return null;
	}

}
