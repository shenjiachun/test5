package com.xiaoya.scaffold.api.service;


import com.xiaoya.scaffold.api.bean.request.BaseRequest;
import com.xiaoya.scaffold.api.bean.request.DemoUserRequest;
import com.xiaoya.scaffold.api.bean.response.DemoUserResponse;

import java.util.List;

/**
 * @Description: 用户服务
 * @Author: zhuzhongji
 * @Date: 9:37 2019/4/14
 * @Param:
 * @return:
 */
public interface DemoUserService {
    String sayHello(String name);

    List<DemoUserResponse> findAllUsers(BaseRequest baseRequest);

    public int addUser(DemoUserRequest demoUserRequest);
}
