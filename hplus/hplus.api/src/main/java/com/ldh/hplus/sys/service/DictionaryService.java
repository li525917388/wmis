package com.ldh.hplus.sys.service;

import java.util.List;

import com.ldh.hplus.common.service.BaseService;
import com.ldh.hplus.sys.pojo.Dictionary;

/**
 * 字典service
 * @author Li Dehuan
 * @date 2018年10月11日
 *
 */
public interface DictionaryService extends BaseService<Dictionary> {

	/**
	 * 根据字典类型查找字典列表
	 * @param type
	 */
	public List<Dictionary> getDicListByType(String type);
	
	
	/**
	 * 根据字典编码获取字典
	 * @param code
	 */
	public Dictionary getDicByCode(String code,String type);
}
