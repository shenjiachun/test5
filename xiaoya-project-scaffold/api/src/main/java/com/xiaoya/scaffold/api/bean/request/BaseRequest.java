package com.xiaoya.scaffold.api.bean.request;

import java.io.Serializable;

/**
 * @Description:
 * @Author: zhuzhongji
 * @Date: 2019/4/15 10:43
 */
public class BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer pageNum;
    private Integer pageSize;


    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "BaseRequest{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                '}';
    }
}
