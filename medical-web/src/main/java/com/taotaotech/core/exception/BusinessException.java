package com.taotaotech.core.exception;

import java.io.Serializable;

/**
 * @author Cailin.Chen
 * @Date 15/8/23
 * @eMail cailin618@sina.com
 */

public class BusinessException extends RuntimeException implements Serializable {
    private int code;
    private String message;

    public BusinessException(ErrorCode errorCode){
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }

    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

}