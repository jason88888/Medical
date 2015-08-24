package com.taotaotech.core.dto;

import java.io.Serializable;

/**
 * @author Cailin.Chen
 * @Date 15/8/23
 * @eMail cailin618@sina.com
 */

public class ResponseResult implements Serializable {

    private int code = 20000;  //状态码
    private String message="success";//消息
    private Object data;//服务数据

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
