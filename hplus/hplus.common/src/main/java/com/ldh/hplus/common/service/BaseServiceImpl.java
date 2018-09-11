package com.ldh.hplus.common.service;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ldh.hplus.common.dao.BaseDao;
import com.ldh.hplus.common.util.BaseParameterType;

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
		
		String oldName = ar.length == 0 ? null : ar[ar.length - 1];
		
		StringBuffer sb = new StringBuffer((oldName.charAt(0) + "").toLowerCase());
		
		for(int i = 1; i < oldName.length(); i++){
			
			char c = oldName.charAt(i);
			
			if(c >= 'A' && c <= 'Z'){
				
				sb.append(("_" + c).toLowerCase());
			}else{
				
				sb.append(c);
			}
		}

		return sb.toString();
	}
	
	/**
	 * 获得参数对象
	 * @return
	 */
	public BaseParameterType getPara(){
		BaseParameterType bpt = new BaseParameterType();

		String table = getTableName();
		bpt.setTable(table);
		
		return bpt;
	}

	@Override
	public T getBeanById(long id) {

		System.out.println("baseService" + id);

		BaseParameterType bpt = getPara();
		bpt.setId(id);
		
		List<Map<String, Object>> list = dao.getBean(bpt);
		
		System.out.println(list);
		
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> queryAllList() {
		List<T> list = new ArrayList<T>();
		
		String className = getBeanType();
		
		List<Map<String, Object>> res = dao.getAllList(getTableName());
		
		Class<?> clazz = null;
		
		try {
			clazz = Class.forName(className);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		for(Map<String, Object> map : res){
			
			Set<Entry<String, Object>> entrys = map.entrySet();
			
			Object o = null;
			
			try {
				o = clazz.newInstance();
				
				for(Entry<String, Object> entry : entrys){
					String key = entry.getKey();		//字段名
					Object value = entry.getValue();	//字段值
					
					Field f;
					
					String name = toProperty(key);
					
					try {
						f = clazz.getDeclaredField(name);	//找属性
						
						f.setAccessible(true);
						
						f.set(o, value);
						
					} catch (NoSuchFieldException e1) {
						
						System.err.println("在" + clazz.getName() + "中没有找到属性:" + name);
						
						this.getSurperClass(clazz,name,value,o);
						
					} catch (SecurityException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
			}  catch (InstantiationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 

			list.add((T) o);
		}
		
		return list;
	}

	
	
	/**
	 * 转驼峰
	 * @param field
	 * @return
	 */
	private String toProperty(String field){
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0; i < field.length(); i++){
			char c = field.charAt(i);
			
			if(c == '_'){
				
				i++;
				sb.append((field.charAt(i) + "").toUpperCase() );
			}else{
				
				sb.append(c);
			}
		}
		return sb.toString();
	}
	
	
	public void getSurperClass(Class<?> clazz,String name, Object value, Object o){
		
		Class<?> pclazz = clazz.getSuperclass();
		
		System.out.println(pclazz.getSimpleName());
		
		if("Object".equals(pclazz.getSimpleName())){
			
			return;
		}
		
		try {
			
			Field f = pclazz.getDeclaredField(name);
			
			f.setAccessible(true);
			
			f.set(o, value);
			
		} catch (NoSuchFieldException e) {
			
			System.err.println("在" + pclazz.getName() + "中没有找到属性:" + name);
			
			this.getSurperClass(pclazz,name,value,o);
			
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
