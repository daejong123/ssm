package com.daejong.common;

/**
 * Created by DaeJong on 2017/4/7.
 */
public class ThisSystemException extends RuntimeException {
    public ThisSystemException() {
        super();
    }

    public ThisSystemException(String message) {
        super(message);
    }

    public ThisSystemException(String message, Throwable cause) {
        super(message, cause);
    }

    public ThisSystemException(Throwable cause) {
        super(cause);
    }

    protected ThisSystemException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
