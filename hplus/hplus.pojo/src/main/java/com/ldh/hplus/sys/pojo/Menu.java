package com.ldh.hplus.sys.pojo;

import java.util.List;

import com.ldh.hplus.common.model.BaseBean;
import com.ldh.hplus.common.util.LDH_Temp;

/**
 * 菜单类
 * @author ldh	
 *
 */
public class Menu extends BaseBean{

	private String menuName;		//菜单名称
	
	private String menuCode;		//菜单编码
	
	private String url;				//菜单地址
	
	private String menuType;			//菜单类型
	
	private String icon;			//菜单样式
	
	private String pcode;			//上级菜单编码
	
	private String describe;		//菜单描述
	
	private String openType;		//菜单打开方式
	
	private int menuOrder;			//菜单顺序
	
	@LDH_Temp
	private List<Menu> childList;	//子菜单

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuCode() {
		return menuCode;
	}

	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMenuType() {
		return menuType;
	}

	public void setMenuType(String menuType) {
		this.menuType = menuType;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getPcode() {
		return pcode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public String getOpenType() {
		return openType;
	}

	public void setOpenType(String openType) {
		this.openType = openType;
	}

	public int getMenuOrder() {
		return menuOrder;
	}

	public void setMenuOrder(int menuOrder) {
		this.menuOrder = menuOrder;
	}

	public List<Menu> getChildList() {
		return childList;
	}

	public void setChildList(List<Menu> childList) {
		this.childList = childList;
	}
	
}
