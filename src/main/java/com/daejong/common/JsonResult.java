package com.daejong.common;

import java.io.Serializable;

/**
 * Created by DaeJong on 2017/4/17.
 * 对json数据进行封装一下.
 */
public class JsonResult<T> implements Serializable {

    private T data;

    private String message;

    private boolean success;

    public JsonResult(T data) {
        this.data = data;
        this.success = true;
    }

    public JsonResult(T data, String message) {
        this.data = data;
        this.message = message;
        this.success = true;
    }

    public JsonResult(T data, String message, boolean success) {
        this.data = data;
        this.message = message;
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
