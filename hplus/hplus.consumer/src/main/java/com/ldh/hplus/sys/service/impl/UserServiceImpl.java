package com.ldh.hplus.sys.service.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ldh.hplus.common.service.BaseServiceImpl;
import com.ldh.hplus.sys.dao.UserDao;
import com.ldh.hplus.sys.pojo.User;
import com.ldh.hplus.sys.service.UserService;

@Service("UserService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

	@Resource
	private UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}



	@Override
	public long addUser(User user) {
		// TODO Auto-generated method stub
		return userDao.addUser(user);
	}

}
