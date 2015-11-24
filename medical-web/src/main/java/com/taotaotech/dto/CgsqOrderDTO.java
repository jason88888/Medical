package com.taotaotech.dto;

import com.taotaotech.domain.CgsqOrder;

/**
 * Created by delll on 2015/11/23.
 */
public class CgsqOrderDTO extends CgsqOrder {
    //药品名称
    private String medicineName;
    //操作人名称
    private String operatorName;
    //供应商名称
    private String providerName;

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }
}
