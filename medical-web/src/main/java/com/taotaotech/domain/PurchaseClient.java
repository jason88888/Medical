package com.taotaotech.domain;

public class PurchaseClient {
    //id
    private Integer id;
    //��˾�ϼ�������λ
    private String saleCompany;
    //��˾���¼ҹ�����λ
    private String buyCompany;
    //Ϊ�����ͻ�
    private String clientName;
    //�ɹ���������
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