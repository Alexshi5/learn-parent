package com.mengfei.security;

import java.io.Serializable;

/**
 * rest响应
 *
 * @author qiaox
 */
public class RestResponse<T> implements Serializable {
    
    private static final String SUCCESS_CODE = "000";
    private static final String BUSINESS_ERROR_CODE = "999";
    private static final String TOKEN_ERROR_CODE = "401";

    private String code;
    private String msg;
    private T data;

    private  SplitPage pageableData;
    
    private RestResponse() {
        this.code = SUCCESS_CODE;
    }
    
    private RestResponse(final T data) {
        this.code = SUCCESS_CODE;
        this.data = data;
    }

    public RestResponse(final String code, final String msg) {
        this.code = code;
        this.msg = msg;
    }
    
    public RestResponse(final String code, final String msg, final T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public RestResponse(T data, SplitPage pageableData) {
        this.code = SUCCESS_CODE;
        this.data = data;
        this.pageableData = pageableData;
    }

    public boolean isSuccess() {
        return SUCCESS_CODE.equals(this.code);
    }

    
    public static <T> RestResponse<T> of(T t) {
        return new RestResponse<>(t);
    }

    public static <T> RestResponse<T> get( T data,SplitPage pageableData) {
        return  new RestResponse<>(data,pageableData);
    }
    
    public static RestResponse success() {
        return new RestResponse();
    }

    public static <T> RestResponse<T> success(T t) {
        return new RestResponse<>(t);
    }

    public static RestResponse errorOfBusiness(final String msg){
        return new RestResponse(BUSINESS_ERROR_CODE,msg);
    }

    public static RestResponse errorOfToken(){
        return new RestResponse(TOKEN_ERROR_CODE,"会员没有登录！");
    }
}
