package com.ldh.hplus.sys.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ldh.hplus.common.service.BaseServiceImpl;
import com.ldh.hplus.sys.dao.MenuDao;
import com.ldh.hplus.sys.pojo.Menu;
import com.ldh.hplus.sys.service.MenuServcice;

@Service("MenuServcice")
public class MenuServiceImpl extends BaseServiceImpl<Menu> implements MenuServcice {

	@Resource
	private MenuDao menuDao;
}
