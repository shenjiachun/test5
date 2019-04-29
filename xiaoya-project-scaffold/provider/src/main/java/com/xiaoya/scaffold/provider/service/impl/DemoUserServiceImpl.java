package com.xiaoya.scaffold.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.xiaoya.scaffold.api.bean.request.BaseRequest;
import com.xiaoya.scaffold.api.bean.request.DemoUserRequest;
import com.xiaoya.scaffold.api.bean.response.DemoUserResponse;
import com.xiaoya.scaffold.api.service.DemoUserService;
import com.xiaoya.scaffold.provider.bean.DemoUser;
import com.xiaoya.scaffold.provider.mapper.DemoUserMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: zhuzhongji
 * @Date: 10:07 2019/4/14
 * @Param: 
 * @return: 
 */
@Service(version = "1.0.0")
public class DemoUserServiceImpl implements DemoUserService {

    @Autowired
    private DemoUserMapper demoUserMapper;


    public String sayHello(String name) {
        return "Hello " + name;
    }

    @Override
    public List<DemoUserResponse> findAllUsers(BaseRequest baseRequest) {
        if (baseRequest == null) {
            return null;
        }

        PageHelper.startPage(baseRequest.getPageNum(), baseRequest.getPageSize());
        List<DemoUser> demoUsers = demoUserMapper.selectAllUsers();

        List<DemoUserResponse> demoUserResponseList = new ArrayList<>();
        for (DemoUser demoUser : demoUsers) {
            DemoUserResponse demoUserResponse = new DemoUserResponse();
            demoUserResponse.setPassword(demoUser.getPassword());
            demoUserResponse.setPhone(demoUser.getPhone());
            demoUserResponse.setUserId(demoUser.getUserId());
            demoUserResponse.setUserName(demoUser.getUserName());
            demoUserResponseList.add(demoUserResponse);

        }

        return demoUserResponseList;
    }

    public int addUser(DemoUserRequest demoUserRequest) {
        DemoUser demoUser = new DemoUser();
        demoUser.setUserName(demoUserRequest.getUserName());
        demoUser.setUserId(demoUserRequest.getUserId());
        demoUser.setPassword(demoUserRequest.getPassword());
        demoUser.setPhone(demoUserRequest.getPhone());

        int insert = 0;
        try {
            insert = demoUserMapper.insert(demoUser);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return insert;
    }
}
