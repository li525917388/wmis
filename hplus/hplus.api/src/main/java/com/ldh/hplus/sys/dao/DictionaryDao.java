package com.ldh.hplus.sys.dao;

import java.util.List;
import java.util.Map;

import com.ldh.hplus.sys.pojo.Dictionary;

/**
 * 字典dao
 * @author Li Dehuan
 * @date 2018年10月11日
 *
 */
public interface DictionaryDao {

	/**
	 * 根据字典类型查找字典列表
	 * @param type
	 */
	public List<Dictionary> getDicListByType(String type);
	
	
	/**
	 * 根据字典编码获取字典
	 * @param code
	 */
	public Dictionary getDicByCode(Map<String, String> map);
}
