package com.ldh.hplus.common.annotation;

/**
 * 按钮权限注解
 * @author Li Dehuan
 * @date 2018年10月16日
 *
 */
public @interface LDHPermission {

	/** 
     * 按钮编码，对应数据库中的按钮编码
     * @return 
     * @version V1.0.0 
     * @date Jan 13, 2014 4:59:35 PM 
     */  
    String value();  
}
