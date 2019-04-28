package com.xiaoya.scaffold.provider;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description: 服务提供启动类
 * @Author: zhuzhongji
 * @Date: 2019/4/24 18:46
 * @Param: 
 * @return: 
 */
@EnableDubbo
@SpringBootApplication
@MapperScan("com.xiaoya.scaffold.provider.mapper")
public class ProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class, args);
    }
}
