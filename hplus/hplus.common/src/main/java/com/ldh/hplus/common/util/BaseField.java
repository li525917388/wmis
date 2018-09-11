package com.ldh.hplus.common.util;

public class BaseField {

	private String type = "and";			//类型
	
	private String property; 				//属性
	
	private FieldOpEnum option;				//操作
	
	/**
	 * field操作类型枚举
	 * @author ldh
	 *
	 */
	public enum FieldOpEnum{
		
		/**
		 * 等于
		 */
		Equal("Equal","="),
		
		/**
		 * 大于
		 */
		GT("GT",">"),
		
		/**
		 * 小于
		 */
		LT("LT","<"),
		
		/**
		 * 大于等于
		 */
		GTEq("GTEq",">"),
		
		/**
		 * 小于等于
		 */
		LTEq("LTEq","<"),
		
		/**
		 * 不等于
		 */
		NotEq("NotEq","<>"),
		
		/**
		 * like
		 */
		Like("Like"," like ");
		
		private String name;
		private String code;
		
		private FieldOpEnum(String name, String code){
			this.code = code;
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}
		
		
	}
	
	private Object value;				//值

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public FieldOpEnum getOption() {
		return option;
	}

	public void setOption(FieldOpEnum option) {
		this.option = option;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
