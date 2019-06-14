package com.mengfei.security;

import java.text.MessageFormat;

/**
 * 自定义异常类
 */
public class CustomException extends Exception {
    public CustomException() {
        super();
    }
    
    public CustomException(String message) {
        super(message);
    }
    
    public CustomException(String message, Object... params) {
        super(MessageFormat.format(message, params));
    }
    
    public CustomException(String message, Throwable cause) {
        super(message, cause);
    }
}
