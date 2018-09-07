package com.ldh.hplus.sys.service;

import com.ldh.hplus.common.service.BaseService;
import com.ldh.hplus.sys.pojo.User;


/**
 * 用户service
 * @author 8
 *
 */
public interface UserService extends BaseService<User> {

	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	public long addUser(User user);
}
