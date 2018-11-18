package com.mengfei.learn.pojo;

import javax.persistence.Id;

/**
 * author Alex
 * date 2018/11/12
 * description 一个测试使用的User类
 */
public class User {
    @Id
    private Integer oid;

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }
}
