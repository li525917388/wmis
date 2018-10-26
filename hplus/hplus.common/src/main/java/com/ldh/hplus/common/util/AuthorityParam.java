package com.ldh.hplus.common.util;

/**
 * 权限参数
 * @author Li Dehuan
 * @date 2018年10月21日
 *
 */
public class AuthorityParam {

	private long uid;				//用户id
	
	private long authorityId;		//权限id
	
	private String type;			//权限类型
	
	/**
	 * 权限类型枚举
	 * @author Li Dehuan
	 * @date 2018年10月21日
	 *
	 */
	public enum AuthorityTypeEnum{
		
		Menu("Menu","菜单"),
		Button("Button","按钮");
		
		private String name;
		
		private String code;
		
		private AuthorityTypeEnum(String code,String name){
			
			this.name = name;
			this.code = code;
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

	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

	public long getAuthorityId() {
		return authorityId;
	}

	public void setAuthorityId(long authorityId) {
		this.authorityId = authorityId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
