package com.xiaoya.scaffold.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xiaoya.scaffold.api.service.DemoService;

/**
 * @Description: 服务提供类
 * @Author: zhuzhongji
 * @Date: 2019/4/24 18:45
 * @Param: 
 * @return: 
 */
@Service(version = "${demo.service.version}")
public class DemoServiceImpl implements DemoService {

    @Override
    public String sayHello(String name) {
        return "Hello, " + name + " (from Spring Boot)";
    }
}
