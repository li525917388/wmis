package com.ldh.hplus.common.service;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * 
 * @author Li Dehuan
 * @date 2018年9月28日
 *
 */
@Service
public class RedisServiceImpl implements RedisService{
	
	@Autowired
	StringRedisTemplate stringRedisTemplate;

	@Override
	public void set(String key, String value) {
		// TODO Auto-generated method stub
		stringRedisTemplate.opsForValue().set(key, value);
	}

	@Override
	public String get(String key) {
		return stringRedisTemplate.opsForValue().get(key);
	}

	@Override
	public void set(String key, List<String> list) {
		for(int i = 0; i < list.size(); i++){
			
			stringRedisTemplate.opsForList().set(key, i, list.get(i));
		}
		
	}

	@Override
	public List<String> getList(String key) {
		return stringRedisTemplate.opsForList().range(key, 0, Integer.MAX_VALUE);
	}

	@Override
	public void put(String key, String hashKey, String value) {
		stringRedisTemplate.opsForHash().put(key, hashKey, value);
	}

	@Override
	public void expireSeconds(String key, long timeout) {
		stringRedisTemplate.expire(key, timeout, TimeUnit.SECONDS);
	}

	/*
	 * 移除String值
	 * @see com.ldh.hplus.common.service.RedisService#remove(java.lang.String)
	 * 2018年12月7日
	 */
	@Override
	public void remove(String key) {
		
		stringRedisTemplate.delete(key);;
	}

}
