package com.mengfei.test.fbsep.pojo;

import org.springframework.http.HttpStatus;

public class ApiResponse<T> {

    private Boolean isSuccess;

    private Integer code;

    private String msg;

    private T data;

    //正常返回无数据
    public ApiResponse(){
        this.isSuccess = Boolean.TRUE;
        this.code = HttpStatus.OK.value();
        this.msg = HttpStatus.OK.getReasonPhrase();
        this.data = null;
    }

    //正常返回有数据
    public ApiResponse(T data){
        this.isSuccess = Boolean.TRUE;
        this.code = HttpStatus.OK.value();
        this.msg = HttpStatus.OK.getReasonPhrase();
        this.data = data;
    }

    //异常返回无数据
    public ApiResponse(Integer code, String msg) {
        this.isSuccess = Boolean.FALSE;
        this.code = code;
        this.msg = msg;
        this.data = null;
    }

    //通用类型
    public ApiResponse(Boolean isSuccess, Integer code, String msg, T data) {
        this.isSuccess = isSuccess;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Boolean getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(Boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
