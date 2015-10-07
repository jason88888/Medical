package com.taotaotech.domain;

import com.taotaotech.core.domain.DataEntity;

public class PurchaseClient extends DataEntity<PurchaseClient> {
    //id
    private Integer id;
    //我司上家销货单位
    private String saleCompany;
    //我司或下家购货单位
    private String buyCompany;
    //为所属客户
    private String clientName;
    //采购销售区域
    private String saleArea;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSaleCompany() {
        return saleCompany;
    }

    public void setSaleCompany(String saleCompany) {
        this.saleCompany = saleCompany == null ? null : saleCompany.trim();
    }

    public String getBuyCompany() {
        return buyCompany;
    }

    public void setBuyCompany(String buyCompany) {
        this.buyCompany = buyCompany == null ? null : buyCompany.trim();
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName == null ? null : clientName.trim();
    }

    public String getSaleArea() {
        return saleArea;
    }

    public void setSaleArea(String saleArea) {
        this.saleArea = saleArea == null ? null : saleArea.trim();
    }
}