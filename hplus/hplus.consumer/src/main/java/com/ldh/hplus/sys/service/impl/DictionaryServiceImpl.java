package com.ldh.hplus.sys.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ldh.hplus.common.service.BaseServiceImpl;
import com.ldh.hplus.sys.dao.DictionaryDao;
import com.ldh.hplus.sys.pojo.Dictionary;
import com.ldh.hplus.sys.service.DictionaryService;

@Service
public class DictionaryServiceImpl extends BaseServiceImpl<Dictionary> implements DictionaryService {

	@Resource
	private DictionaryDao dictionaryDao;
	
	@Override
	public List<Dictionary> getDicListByType(String type) {
		// TODO Auto-generated method stub
		return dictionaryDao.getDicListByType(type);
	}

	@Override
	public Dictionary getDicByCode(String code,String type) {
		
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("code", code);
		map.put("type", type);
		
		return dictionaryDao.getDicByCode(map);
	}

}
