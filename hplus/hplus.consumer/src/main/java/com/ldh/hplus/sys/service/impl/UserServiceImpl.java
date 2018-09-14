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
	public User login(User user) {
		
		User u = userDao.login(user);
		
		if(u != null && u.getId() != 0){
			
			return u;
		}
		
		return null;
	}

}
