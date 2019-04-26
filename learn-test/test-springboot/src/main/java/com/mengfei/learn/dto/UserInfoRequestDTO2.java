package com.mengfei.learn.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * 用于传输用户基本信息参数的DTO对象
 */
public class UserInfoRequestDTO2 {

    //用户信息描述
    @ApiModelProperty(value = "用户信息描述00",name = "userInfoDesc",required = true,dataType = "string")
    private String userInfoDesc;

    //数据状态（0删除，1正常）
    @ApiModelProperty(value = "数据状态00",name = "state",notes = "0删除，1正常",required = true,dataType = "int")
    private Integer state;

    public String getUserInfoDesc() {
        return userInfoDesc;
    }

    public void setUserInfoDesc(String userInfoDesc) {
        this.userInfoDesc = userInfoDesc;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

}
