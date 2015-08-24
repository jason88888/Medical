package com.taotaotech.core.exception;

/**
 * @author Cailin.Chen
 * @Date 15/8/23
 * @eMail cailin618@sina.com
 */

public enum  SystemErrorCode implements ErrorCode {
    SYSTME_ERROR(10001,"系统错误"),
    DATABASE_ERROE(10002,"数据库出错"),
    NULLPOINTER_ERROR(10003,"空指针异常"),
    ARRAY_INDEXOUTOF_ERROR(10004,"数组越界错误"),
    RUNTIME_ERROR(10005,"系统运行异常"),
    INVALID_SIGN(10006,"无效的参数签名"),
    INVALID_APPKEY(10007,"无效APPKEY"),
    PARAMETER_NOT_PRESENT(10009,"参数不存在"),
    BEAN_VALIDATION_ERROR(10010,"类校验出错"),
    SESSION_TIMEOUT_ERROR(10011,"SESSION过期"),
    VALIDATE_CODEMISMATCH_ERROR(10012,"验证码校验错误"),
    USER_NOTPRIVILEGE_ERROR(10013,"用户没有权限"),
    USER_NOTLOGIN_ERROR(10014,"用户没有登录");

    private int code;
    private String message;

    SystemErrorCode(int code,String message){
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
