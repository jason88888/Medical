package com.taotaotech.exception.user;

import com.taotaotech.core.exception.ErrorCode;

/**
 * @author Cailin.Chen
 * @Date 15/8/23
 * @eMail cailin618@sina.com
 */

public enum  UserErrorCode implements ErrorCode {
    USERNAME_NOT_EXIST(110001,"用户不存在"),
    PASSWORD_ERROR(110002,"密码错误");

    private int code;
    private String massage;
    private UserErrorCode(int code,String message){
        this.code = code;
        this.massage = message;
    }
    public int getCode() {
        return code;
    }

    public String getMessage() {
        return massage;
    }
}
