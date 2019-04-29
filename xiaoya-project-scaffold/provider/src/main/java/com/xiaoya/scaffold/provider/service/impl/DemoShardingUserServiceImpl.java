package com.xiaoya.scaffold.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xiaoya.scaffold.api.bean.request.DemoShardingUserRequest;
import com.xiaoya.scaffold.api.service.DemoShardingUserService;
import com.xiaoya.scaffold.provider.bean.DemoShardingUser;
import com.xiaoya.scaffold.provider.mapper.DemoShardingUserMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 
 * @Author: zhuzhongji
 * @Date: 2019/4/29 10:10
 * @Param: 
 * @return: 
 */
//@Service
@Service(version = "1.0.0")
public class DemoShardingUserServiceImpl implements DemoShardingUserService {

	@Autowired
	private DemoShardingUserMapper demoShardingUserMapper;
	
	public List<DemoShardingUserRequest> list() {
		List<DemoShardingUser> demoShardingUserList = demoShardingUserMapper.list();

		List<DemoShardingUserRequest> demoShardingUserRequestList = new ArrayList<>();
		for (DemoShardingUser user : demoShardingUserList) {
			DemoShardingUserRequest userRequest = new DemoShardingUserRequest();
			userRequest.setId(user.getId());
			userRequest.setName(user.getName());
			userRequest.setCity(user.getCity());
            demoShardingUserRequestList.add(userRequest);
		}

		return demoShardingUserRequestList;
	}

	public Long add(DemoShardingUserRequest demoShardingUserRequest) {
		DemoShardingUser demoShardingUser = new DemoShardingUser();
        demoShardingUser.setCity(demoShardingUserRequest.getCity());
//		demoShardingUser.setId(demoShardingUserRequest.getId());
        demoShardingUser.setName(demoShardingUserRequest.getName());

		return demoShardingUserMapper.addUser(demoShardingUser);
	}

	@Override
	public DemoShardingUserRequest findById(Long id) {
		DemoShardingUser demoShardingUser = demoShardingUserMapper.findById(id);
		DemoShardingUserRequest demoShardingUserRequest = new DemoShardingUserRequest();
        demoShardingUserRequest.setCity(demoShardingUser.getCity());
        demoShardingUserRequest.setName(demoShardingUser.getName());
        demoShardingUserRequest.setId(demoShardingUser.getId());

		return demoShardingUserRequest;
	}

	@Override
	public DemoShardingUserRequest findByName(String name) {
		DemoShardingUser demoShardingUser = demoShardingUserMapper.findByName(name);
		DemoShardingUserRequest demoShardingUserRequest = new DemoShardingUserRequest();
        demoShardingUserRequest.setCity(demoShardingUser.getCity());
        demoShardingUserRequest.setName(demoShardingUser.getName());
        demoShardingUserRequest.setId(demoShardingUser.getId());

		return demoShardingUserRequest;
	}

}
