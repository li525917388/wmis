package com.ldh.hplus.sys.pojo;

import com.ldh.hplus.common.model.BaseBean;

/**
 * 字典
 * @author Li Dehuan
 * @date 2018年10月11日
 *
 */
public class Dictionary extends BaseBean {
	
	private String dicName;		//字典名称
	
	private String dicCode;		//字典编码
	
	private Long dicType;		//字典类型
	
	private Integer dicOrder;	//顺序
	
	private String dicDescribe;	//描述

	public String getDicName() {
		return dicName;
	}

	public void setDicName(String dicName) {
		this.dicName = dicName;
	}

	public String getDicCode() {
		return dicCode;
	}

	public void setDicCode(String dicCode) {
		this.dicCode = dicCode;
	}

	public Long getDicType() {
		return dicType;
	}

	public void setDicType(Long dicType) {
		this.dicType = dicType;
	}

	public Integer getDicOrder() {
		return dicOrder;
	}

	public void setDicOrder(Integer dicOrder) {
		this.dicOrder = dicOrder;
	}

	public String getDicDescribe() {
		return dicDescribe;
	}

	public void setDicDescribe(String dicDescribe) {
		this.dicDescribe = dicDescribe;
	}
	

}
