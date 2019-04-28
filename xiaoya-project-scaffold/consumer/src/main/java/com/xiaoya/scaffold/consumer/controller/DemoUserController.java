package com.xiaoya.scaffold.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xiaoya.scaffold.api.bean.request.BaseRequest;
import com.xiaoya.scaffold.api.bean.response.DemoUserResponse;
import com.xiaoya.scaffold.api.service.DemoUserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description:
 * @Author: zhuzhongji
 * @Date: 2019/4/15 9:29
 * @Param:
 * @return:
 */
@RestController
@RequestMapping(value = "/demoUser")
public class DemoUserController {

    @Reference(version = "${demo.service.version}")
    private DemoUserService demoUserService;

    @GetMapping("/hello")
    public String hello(){
        return "Welcome to springboot dubbo!";
    }

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(@RequestParam(value = "name") String name) {
        return demoUserService.sayHello(name);
    }

    /**
     * @Description 分页获取用户信息
     * @Author zhuzhongji
     * @Date 11:09 2019/4/11
     * @Param [pageNum, pageSize]
     * @return java.util.List<com.xiaoya.scaffold.api.bean.DemoUser>
     */
    @PostMapping("/pageFindUsers")
    public List<DemoUserResponse> findAllUsers(Integer pageNum, Integer pageSize) {
        BaseRequest baseRequest = new BaseRequest();
        baseRequest.setPageNum(pageNum);
        baseRequest.setPageSize(pageSize);
        return demoUserService.findAllUsers(baseRequest);
    }
}
