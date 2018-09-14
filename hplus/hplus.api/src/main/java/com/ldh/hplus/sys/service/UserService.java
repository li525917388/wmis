package com.ldh.hplus.sys.service;

import com.ldh.hplus.common.service.BaseService;
import com.ldh.hplus.sys.pojo.User;


/**
 * 用户service
 * @author ldh
 *
 */
public interface UserService extends BaseService<User> {

	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	public User login(User user);
}
