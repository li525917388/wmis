package com.ldh.hplus.authority.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ldh.hplus.authority.dao.ButtonDao;
import com.ldh.hplus.authority.pojo.Button;
import com.ldh.hplus.authority.service.ButtonService;
import com.ldh.hplus.common.service.BaseServiceImpl;

/**
 * 按钮service实现类
 * @author Li Dehuan
 * @date 2018年10月15日
 *
 */
@Service
public class ButtonServiceImpl extends BaseServiceImpl<Button> implements ButtonService {

	@Resource
	ButtonDao buttonDao;
	
	
}
