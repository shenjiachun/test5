package com.xiaoya.scaffold.provider.service.impl;

import com.xiaoya.scaffold.provider.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.concurrent.TimeUnit;

/**
 * @Description: 
 * @Author: zhuzhongji
 * @Date: 9:59 2019/4/14
 * @Param: 
 * @return: 
 */
//@Service
public class RedisServiceImpl implements RedisService {
	
	@Autowired
	private ValueOperations<String, Object> valueOperations;
	
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	
	@Override
	public Object getValue(String key) {
		
		Object value = valueOperations.get(key);
		return value;
	}

	@Override
	public void setValue(String key, Object value) {
		
		valueOperations.set(key, value);
	}

	@Override
	public void setValue(String key, Object value, Long expiredTime) {

		valueOperations.set(key, value, expiredTime, TimeUnit.SECONDS);
	}

	@Override
	public void removeKey(String key) {
		
		redisTemplate.delete(key);
	}

}
