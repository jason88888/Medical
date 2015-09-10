package com.taotaotech.dto;

import com.taotaotech.domain.Bill;

/**
 * 富bill，主要用于佣金结算时使用
 */

/**
 * 药品名称 业务员姓名 ,
 */

public class BillRich extends Bill {
    private String medicineName;
    private String userName;

    private String clientName;

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

}
