package com.ldh.hplus.sys.dao;

import com.ldh.hplus.common.dao.BaseDao;
import com.ldh.hplus.sys.pojo.User;

/**
 * 用户dao层
 * @author 8
 *
 */
public interface UserDao extends BaseDao<User> {

	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	public long addUser(User user);
}
