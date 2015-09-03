package com.taotaotech.core.dto;

import java.io.Serializable;

/**
 * @author Cailin.Chen
 * @Date 15/8/23
 * @eMail cailin618@sina.com
 */

public class DWZResponseResult implements Serializable {

    private String statusCode = "200"; //状态码
    private String message = "操作成功"; //消息
    private String navTabId;
    private String rel;
    private String callbackType;
    private String forwardUrl;

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getNavTabId() {
        return navTabId;
    }

    public void setNavTabId(String navTabId) {
        this.navTabId = navTabId;
    }

    public String getRel() {
        return rel;
    }

    public void setRel(String rel) {
        this.rel = rel;
    }

    public String getCallbackType() {
        return callbackType;
    }

    public void setCallbackType(String callbackType) {
        this.callbackType = callbackType;
    }

    public String getForwardUrl() {
        return forwardUrl;
    }

    public void setForwardUrl(String forwardUrl) {
        this.forwardUrl = forwardUrl;
    }
}
