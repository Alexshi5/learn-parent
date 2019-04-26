package com.mengfei.learn.dto;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.web.multipart.MultipartFile;

/**
 * 用于传输用户基本信息参数的DTO对象
 */
public class UserInfoRequestDTO {

    //用户信息描述
    @ApiModelProperty(value = "用户信息描述00",name = "userInfoDesc",required = true,dataType = "string")
    private String userInfoDesc;

    //数据状态（0删除，1正常）
    @ApiModelProperty(value = "数据状态00",name = "state",notes = "0删除，1正常",required = true,dataType = "int")
    private Integer state;

    //用户头像
    private MultipartFile userLogo;

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

    public MultipartFile getUserLogo() {
        return userLogo;
    }

    public void setUserLogo(MultipartFile userLogo) {
        this.userLogo = userLogo;
    }
}
