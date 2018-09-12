package com.ldh.hplus.common.model;

import com.ldh.hplus.common.util.LDH_Field;
import com.ldh.hplus.common.util.LDH_Table;

/**
 * 基础bean
 * @author ldh
 *
 */
@LDH_Table
public class BaseBean {

	@LDH_Field("id")
	private long id;

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
