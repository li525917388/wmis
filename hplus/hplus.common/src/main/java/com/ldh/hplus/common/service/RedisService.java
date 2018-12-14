package com.ldh.hplus.common.service;

import java.util.List;

/**
 * redis service
 * @author Li Dehuan
 * @date 2018年9月28日
 *
 */
public interface RedisService {

	/**
	 * 新增String类型值
	 * @param key
	 * @param value
	 */
	public void set(String key, String value);
	
	
	/**
	 * 获取String类型值
	 * @param key
	 * @return value
	 */
	public String get(String key);
	
	
	
	/**
	 * 移除String值
	 * @param key
	 * @return
	 */
	public void remove(String key);
	
	
	
	/**
	 * 新增List类型值
	 * @param key
	 * @param list
	 */
	public void set(String key, List<String> list);
	
	
	/**
	 * 获取List类型值
	 * @param key
	 * @return value
	 */
	public List<String> getList(String key);
	
	
	
	/**
	 * 新增Hash类型值
	 * @param key
	 * @param hashKey
	 * @param value
	 */
	public void put(String key, String hashKey,String value);
	
	
	/**
	 * 设置有效值时间(单位：秒)
	 * @param key
	 * @param timeout
	 */
	public void expireSeconds(String key,long timeout);
}
