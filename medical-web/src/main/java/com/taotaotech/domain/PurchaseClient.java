package com.taotaotech.domain;

/**
 * @author zk
 * @date 2015/10/2 9:55
 * @description 采购客户管理
 */
public class PurchaseClient {
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
        this.saleCompany = saleCompany;
    }

    public String getBuyCompany() {
        return buyCompany;
    }

    public void setBuyCompany(String buyCompany) {
        this.buyCompany = buyCompany;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getSaleArea() {
        return saleArea;
    }

    public void setSaleArea(String saleArea) {
        this.saleArea = saleArea;
    }
}
