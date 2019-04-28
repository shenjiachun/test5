package com.xiaoya.scaffold.provider.service;

/**
 * @Description:
 * @Author: zhuzhongji
 * @Date: 2019/4/25 13:45
 */
public interface RedisService {

    public Object getValue(String key);

    public void setValue(String key, Object value);

    public void setValue(String key, Object value, Long expiredTime);

    public void removeKey(String key);

}
