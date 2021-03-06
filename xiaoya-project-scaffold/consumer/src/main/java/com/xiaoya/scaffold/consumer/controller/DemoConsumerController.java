package com.xiaoya.scaffold.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xiaoya.scaffold.api.service.DemoService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 消费者控制层
 * @Author: zhuzhongji
 * @Date: 2019/4/24 18:46
 * @Param: 
 * @return: 
 */
@RestController
public class DemoConsumerController {

    @Reference(version = "${demo.service.version}")
    private DemoService demoService;

    @RequestMapping("/sayHello/{name}")
    public String sayHello(@PathVariable("name") String name) {
        return demoService.sayHello(name);
    }

}
