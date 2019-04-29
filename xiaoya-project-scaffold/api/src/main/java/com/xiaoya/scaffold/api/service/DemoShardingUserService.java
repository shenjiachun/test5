package com.xiaoya.scaffold.api.service;


import com.xiaoya.scaffold.api.bean.request.DemoShardingUserRequest;

import java.util.List;

/**
 * @Description:
 * @Author: zhuzhongji
 * @Date: 2019/4/29 10:14
 * @Param:
 * @return:
 */
public interface DemoShardingUserService {

	List<DemoShardingUserRequest> list();
	
	Long add(DemoShardingUserRequest demoShardingUserRequest);
	
	DemoShardingUserRequest findById(Long id);
	
	DemoShardingUserRequest findByName(String name);
	
}
