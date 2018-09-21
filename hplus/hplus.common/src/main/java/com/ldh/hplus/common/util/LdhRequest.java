package com.ldh.hplus.common.util;

/**
 * 请求参数基类
 * @author Li Dehuan
 *
 */
public class LdhRequest {
	
	private String sessionId;		//sessionId
	
	private Object parameters;		//请求参数实体
	
	private String parametersJson;	//请求参数json串

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public Object getParameters() {
		return parameters;
	}

	public void setParameters(Object parameters) {
		this.parameters = parameters;
	}

	public String getParametersJson() {
		return parametersJson;
	}

	public void setParametersJson(String parametersJson) {
		this.parametersJson = parametersJson;
	}
	
	
}
