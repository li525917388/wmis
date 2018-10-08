package com.ldh.hplus.common.service;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ldh.hplus.common.dao.BaseDao;
import com.ldh.hplus.common.err.MyRunException;
import com.ldh.hplus.common.util.BaseGrid;
import com.ldh.hplus.common.util.BaseInsert;
import com.ldh.hplus.common.util.BaseParameterType;
import com.ldh.hplus.common.util.BaseUpdate;
import com.ldh.hplus.common.util.Filter;
import com.ldh.hplus.common.util.LDH_Temp;

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
	
	/**
	 * 获得表名
	 * @return
	 */
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

	@SuppressWarnings("unchecked")
	@Override
	public T getBeanById(long id) {

		System.out.println("baseService" + id);

		BaseParameterType bpt = getPara();
		bpt.setId(id);
		//bpt.setTable(getTableName());
		
		Map<String, Object> res = dao.getBean(bpt);
		
		if(res == null){
			
			return null;
		}
		
		Set<Entry<String, Object>> entrys = res.entrySet();
		
		Object o = null;
		
		Class<?> clazz = null;
		
		try {
			clazz = Class.forName(getBeanType());
		} catch (ClassNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
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
					
					Field pf = this.getSurperField(clazz,name);
					
					pf.set(o, value);
					
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
		
		return (T) o;
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
						
						Field pf = this.getSurperField(clazz,name);
						
						if(pf == null){
							
							
						}else{
							
							pf.set(o, value);
						}	
						
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
	
	
	/**
	 * 转数据库字段
	 * @param property
	 * @return
	 */
	private String toField(String property){
		
		StringBuffer sb = new StringBuffer(property.charAt(0) + "");
		
		for(int i = 1; i < property.length(); i++){
			
			char c = property.charAt(i);
			
			if(c >= 'A' && c <= 'Z'){
				
				sb.append(("_" + c).toLowerCase());
			}else{
				
				sb.append(c);
			}
		}
		
		return sb.toString();
	}
	
	
	public Field getSurperField(Class<?> clazz,String name){
		
		Class<?> pclazz = clazz.getSuperclass();
		
		System.out.println(pclazz.getSimpleName());
		
		if("Object".equals(pclazz.getSimpleName())){
			
			return null;
		}
		
		try {
			
			Field f = pclazz.getDeclaredField(name);
			
			f.setAccessible(true);
			
			return f;		
			
		} catch (NoSuchFieldException e) {
			
			System.err.println("在" + pclazz.getName() + "中没有找到属性:" + name);
			
			return this.getSurperField(pclazz,name);
			
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return null;
	}

	@Override
	public long insert(T t) {
		List<String> fieldList = new ArrayList<String>();
		List<Object> valueList = new ArrayList<Object>();
		
		BaseInsert bt = new BaseInsert();			//创建插入参数对象
		
		bt.setTable(getTableName());
		
		Class<? extends Object> clazz = t.getClass();
		
		Field[] fields = clazz.getDeclaredFields();		//获得所有属性
		
		for(int i = 0; i < fields.length; i++){

			//判断是否临时注解
			boolean  isTemp = isTemp(fields[i]);
			if(isTemp){
				continue;
			}
			
			fields[i].setAccessible(true); 			//设置私有属性公有
			
			fieldList.add(toField(fields[i].getName()));
			try {
				valueList.add(fields[i].get(t));
			} catch (IllegalArgumentException | IllegalAccessException e) {
				
				e.printStackTrace();
				throw new MyRunException();		//抛出自定义异常
			}
		}
		
		bt.setFieldList(fieldList);
		bt.setValueList(valueList);
		
		return this.dao.insert(bt);
	}

	@Override
	public int delete(long id) {
		
		BaseParameterType bpt = getPara();
		bpt.setId(id);
		
		int res = dao.delete(bpt);
		
		return res;
	}

	@Override
	public long update(T t) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		BaseUpdate bu = new BaseUpdate();
		bu.setTable(getTableName());
		
		Class<? extends Object> clazz = t.getClass();
		
		Field[] fields = clazz.getDeclaredFields();		//获得所有属性
		
		for(int i = 0; i < fields.length; i++){
			
			//判断是否临时注解
			boolean  isTemp = isTemp(fields[i]);
			if(isTemp){
				continue;
			}
			
			fields[i].setAccessible(true); 			//设置私有属性公有

			try {
				map.put(toField(fields[i].getName()),fields[i].get(t));		//添加到集合
				
			} catch (IllegalArgumentException | IllegalAccessException e) {
				
				e.printStackTrace();
				throw new MyRunException();		//抛出自定义异常
			}
		}
		
		long id = 0;
		
		///找ID
		try {
			
			Field f = clazz.getDeclaredField("id");		//搜索ID属性
			
			f.setAccessible(true);
			
			id = f.getLong(t);

		} catch (IllegalArgumentException e) {

			e.printStackTrace();
		} catch (IllegalAccessException e) {

			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			
			//找父类的方法
			Field pf = getSurperField(clazz,"id");

			try {
				
				id = pf.getLong(t);
				
			} catch (IllegalArgumentException e1) {

				e1.printStackTrace();
			} catch (IllegalAccessException e1) {

				e1.printStackTrace();
			}
			
		} catch (SecurityException e) {

			e.printStackTrace();
		}
		
		bu.setData(map);
		bu.setId(id);
		
		return dao.update(bu);
	}
	
	public void getSuperId(Class<?> clazz){
		
		Class<?> pclazz = clazz.getSuperclass();
		
		Field f = null;
		
		try {
			
			f = clazz.getDeclaredField("id");
			f.setAccessible(true);
			
			return;
		} catch (NoSuchFieldException e) {
			
			getSuperId(pclazz);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		//搜索ID属性
		
		
		
	}

	@Override
	public BaseGrid<T> getGridList(Filter filter,int page,int pageSize) {
		
		BaseParameterType bpt = getPara();
		
		bpt.setStatr((page - 1) * pageSize);
		bpt.setEnd(page * pageSize);
		bpt.setFielter(filter);
		
		return null;
	}
	
	
	/**
	 * 判断是否临时注解
	 * @param f
	 * @return
	 */
	private boolean isTemp(Field f){
		
		LDH_Temp t = f.getAnnotation(LDH_Temp.class);
		
		if(t == null){
			
			return false;
		}
		
		return true;
	}
}
