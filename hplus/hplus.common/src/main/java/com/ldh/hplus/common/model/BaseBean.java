package com.ldh.hplus.common.model;

/**
 * 基础bean
 * @author 8
 *
 */
public class BaseBean {

	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String toString(){
		
		return "" + id;
	}
}
