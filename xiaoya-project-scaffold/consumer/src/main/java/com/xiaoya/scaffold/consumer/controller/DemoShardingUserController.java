package com.xiaoya.scaffold.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xiaoya.scaffold.api.bean.request.DemoShardingUserRequest;
import com.xiaoya.scaffold.api.service.DemoShardingUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: zhuzhongji
 * @Date: 2019/4/29 10:12
 * @Param:
 * @return:
 */
@RestController
public class DemoShardingUserController {
	
	//@Autowired
	@Reference(version = "${demo.service.version}")
	private DemoShardingUserService demoShardingUserService;
	
	@GetMapping("/shardingUsers")
	public Object list() {
		return demoShardingUserService.list();
	}
	
	@GetMapping("/addShardingUsers")
	public Object add() {
		for (long i = 1; i <= 10; i++) {
			DemoShardingUserRequest demoShardingUserRequest = new DemoShardingUserRequest();
			demoShardingUserRequest.setCity("深圳" + i);
			demoShardingUserRequest.setName("李四" + i);
			demoShardingUserService.add(demoShardingUserRequest);
		}
		return "success";
	}
	
	@GetMapping("/shardingUsers/{id}")
	public Object get(@PathVariable Long id) {
		return demoShardingUserService.findById(id);
	}
	
	@GetMapping("/shardingUsers/query")
	public Object get(String name) {
		return demoShardingUserService.findByName(name);
	}
	
}
