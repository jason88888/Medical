package com.taotaotech.dto;

import com.taotaotech.domain.RkOrder;

/**
 * @author Cailin.Chen
 * @Date 15/10/20
 * @eMail cailin618@sina.com
 */

public class RkOrderDTO extends RkOrder {
    //仓库名称
    private String warehouseName;
    //药品名称
    private String medicineName;
    //操作人名称
    private String operatorName;
    //供应商名称
    private String providerName;
    //代理商名称
    private String agentName;
    //商业公司名称
    private String commercialCompanyName;

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

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

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getCommercialCompanyName() {
        return commercialCompanyName;
    }

    public void setCommercialCompanyName(String commercialCompanyName) {
        this.commercialCompanyName = commercialCompanyName;
    }
}
