package com.ldh.hplus.common.util;

import java.util.ArrayList;
import java.util.List;

import com.ldh.hplus.common.util.BaseField.FieldOpEnum;

/**
 * 
 * @author ldh
 *
 */
public class Filter {

	@SuppressWarnings("unused")
	private String type = " and ";
	
	private List<BaseField> fieldList = new ArrayList<BaseField>();
	
	private List<Filter> fielterList = new ArrayList<Filter>();
	
	private List<BaseSort> sortList = new ArrayList<BaseSort>();
	
	/**
	 * 添加等值条件属性
	 * @param name
	 * @param value
	 * @return
	 */
	public Filter addEquels(String name, String value){
		
		return this.addField(name,value,FieldOpEnum.Equal);	
	}
	
	
	/**
	 * 添加等值条件属性
	 * @param name
	 * @param value
	 * @return
	 */
	public Filter addLike(String name, String value){
	
		return this.addField(name,"%" + value + "%",FieldOpEnum.Like);	
	}
	
	
	/**
	 * 添加field
	 * @param name
	 * @param value
	 * @param op
	 * @return
	 */
	private Filter addField(String name, String value,FieldOpEnum op){
		
		BaseField bf = new BaseField();
		
		bf.setProperty(name);
		bf.setOption(FieldOpEnum.Like);
		bf.setValue(value);
		
		this.fieldList.add(bf);
		
		return this;
	}
	
	
	/**
	 * 静态方法,
	 * 添加等值条件属性
	 * @param name
	 * @param value
	 * @return
	 */
	public static Filter equels(String name, String value){
		
		Filter f = new Filter();
		
		BaseField bf = new BaseField();
		
		bf.setProperty(name);
		bf.setOption(FieldOpEnum.Equal);
		bf.setValue(value);
		
		f.fieldList.add(bf);
		
		return f;	
	}
	
	/**
	 * 添加或条件
	 * @param fielter
	 * @return
	 */
	public Filter addOr(Filter... fielter){
		
		for(int i = 0; i < fielter.length; i++){
			
			fielter[i].type = " or ";
			
			this.fielterList.add(fielter[i]);			
		}
		
		return this;	
	}
	
	
	/**
	 * 添加排序，默认升序
	 * @param name
	 * @return
	 */
	public Filter addSort(String name){
		
		return addSort(name, "asc");
	}
	
	/**
	 * 添加排序
	 * @param name
	 * @param type asc:升序，desc:降序
	 * @return
	 */
	public Filter addSort(String name, String type){
		
		BaseSort sort = new BaseSort();
		
		sort.setProperty(name);
		sort.setProperty(type);
		
		sortList.add(sort);
		
		return this;
	}
}
