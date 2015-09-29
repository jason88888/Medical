package com.taotaotech.controller;

/**
 * 处理信息传递
 */
public class Message {
    private String code = "INFO";
    private String content = "";

    public static String INFO = "INFO";
    public static String ERROR = "ERROR";

    public Message(String content) {
        this.content = content;
    }

    public Message(String code, String content) {
        this.code = code;
        this.content = content;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
