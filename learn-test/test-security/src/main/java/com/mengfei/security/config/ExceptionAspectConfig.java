package com.mengfei.security.config;

import com.mengfei.security.RestResponse;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理切面
 * Description: 利用 @ControllerAdvice + @ExceptionHandler 组合处理Controller层RuntimeException异常
 * 在运行时从上往下依次调用每个异常处理方法，匹配当前异常类型是否与@ExceptionHandler注解所定义的异常相匹配，
 * 若匹配，则执行该方法，同时忽略后续所有的异常处理方法，最终会返回经JSON序列化后的Response对象
 *
 * 请注意：如果在Controller中使用try catch进行了异常处理，则此异常处理切面不会生效
 */
@RestControllerAdvice
public class ExceptionAspectConfig {

    /**
     * 401 - Internal Server Error
     */
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(AuthorizationException.class)
    public RestResponse handleAuthorizationException(AuthorizationException e) {
        return new RestResponse<>(String.valueOf(HttpStatus.UNAUTHORIZED.value()),e.getMessage());
    }

    /**
     * 500 - Internal Server Error
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public RestResponse handleException(Exception e) {
        return new RestResponse<>(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()),e.getMessage());
    }
}