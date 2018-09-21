package com.ldh.hplus.common.util;

/**
 * 返回参数模型
 * @author Li Dehuan
 *
 */
public class LdhResponse {

	private String resCode;	//返回代码
	
	private String msg;		//信息
	
	private Object data;	//数据
	
	private int isSuccess;	//是否成功

	public String getResCode() {
		return resCode;
	}

	public void setResCode(String resCode) {
		this.resCode = resCode;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public int getIsSuccess() {
		return isSuccess;
	}

	public void setIsSuccess(int isSuccess) {
		this.isSuccess = isSuccess;
	}
	
	
}
