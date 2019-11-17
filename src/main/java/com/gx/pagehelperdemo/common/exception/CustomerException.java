package com.gx.pagehelperdemo.common.exception;

/**
 * 自定义异常类
 */
public class CustomerException extends RuntimeException {

    public CustomerException() {
        super();
    }

    public CustomerException(String message) {
        super(message);
    }

    public CustomerException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomerException(Throwable cause) {
        super(cause);
    }

    protected CustomerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
