package com.ldh.hplus.sys.dao;

import com.ldh.hplus.sys.pojo.User;

/**
 * 用户dao层
 * @author 8
 *
 */
public interface UserDao {

	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	public User login(User user);
}
