package com.ldh.hplus.pojo.util;

import java.util.Date;

import com.ldh.hplus.sys.pojo.User;

/**
 * 用户session类
 * @author ldh
 *
 */
public class UserSession {
	
	private User user;
	
	private long lastTime;
	
	public UserSession(){
		
	}
	
	public UserSession(User u){
		
		this.user = u;
		this.lastTime = new Date().getTime();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public long getLastTime() {
		return lastTime;
	}

	public void setLastTime(long lastTime) {
		this.lastTime = lastTime;
	}

}
