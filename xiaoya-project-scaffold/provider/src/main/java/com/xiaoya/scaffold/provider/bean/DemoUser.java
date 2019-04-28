package com.xiaoya.scaffold.provider.bean;

import java.io.Serializable;
import lombok.Data;

/**
* Created by Mybatis Generator on 2019-04-24 下午07:59:05
*/
@Data
public class DemoUser implements Serializable {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 手机号
     */
    private String phone;

    private static final long serialVersionUID = 1L;
}