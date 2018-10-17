package com.ldh.hplus.authority.pojo;

import com.ldh.hplus.common.model.BaseBean;

/**
 * 按钮实体
 * @author Li Dehuan
 * @date 2018年10月15日
 *
 */
public class Button extends BaseBean {

	private String btnName;			//按钮名称
	
	private String btnClass;		//按钮样式
	
	private String btnEvent;		//按钮事件
	
	private int btnOrder;			//按钮顺序
	
	private String menuCode;		//所属菜单编码
	
	private String btnDescribe;		//按钮描述

	public String getBtnName() {
		return btnName;
	}

	public void setBtnName(String btnName) {
		this.btnName = btnName;
	}

	public String getBtnClass() {
		return btnClass;
	}

	public void setBtnClass(String btnClass) {
		this.btnClass = btnClass;
	}

	public String getBtnEvent() {
		return btnEvent;
	}

	public void setBtnEvent(String btnEvent) {
		this.btnEvent = btnEvent;
	}

	public int getBtnOrder() {
		return btnOrder;
	}

	public void setBtnOrder(int btnOrder) {
		this.btnOrder = btnOrder;
	}

	public String getBtnDescribe() {
		return btnDescribe;
	}

	public void setBtnDescribe(String btnDescribe) {
		this.btnDescribe = btnDescribe;
	}

	public String getMenuCode() {
		return menuCode;
	}

	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}
	
	
}
