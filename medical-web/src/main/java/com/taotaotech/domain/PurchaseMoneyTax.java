package com.taotaotech.domain;

import java.util.Date;

public class PurchaseMoneytax {
    private Integer id;
    //������
    private String paymentCategory;
    //���ʽ
    private String paymentMode;
    //������
    private String paymentMoney;
    //ҵ�����̼���
    private String workFlow;
    //�����
    private Long purchaseUnitPrice;
    //������
    private String purchaseMoney;
    //Ӧ��˰
    private String tax;
    //��˰��ʽ
    private String taxPayMode;
    //��˰����
    private Date taxPayDate;
    //��Ʊ����
    private Integer invoiceNumber;
    //��Ʊ����
    private Date invoiceDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPaymentCategory() {
        return paymentCategory;
    }

    public void setPaymentCategory(String paymentCategory) {
        this.paymentCategory = paymentCategory == null ? null : paymentCategory.trim();
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode == null ? null : paymentMode.trim();
    }

    public String getPaymentMoney() {
        return paymentMoney;
    }

    public void setPaymentMoney(String paymentMoney) {
        this.paymentMoney = paymentMoney == null ? null : paymentMoney.trim();
    }

    public String getWorkFlow() {
        return workFlow;
    }

    public void setWorkFlow(String workFlow) {
        this.workFlow = workFlow == null ? null : workFlow.trim();
    }

    public Long getPurchaseUnitPrice() {
        return purchaseUnitPrice;
    }

    public void setPurchaseUnitPrice(Long purchaseUnitPrice) {
        this.purchaseUnitPrice = purchaseUnitPrice;
    }

    public String getPurchaseMoney() {
        return purchaseMoney;
    }

    public void setPurchaseMoney(String purchaseMoney) {
        this.purchaseMoney = purchaseMoney == null ? null : purchaseMoney.trim();
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax == null ? null : tax.trim();
    }

    public String getTaxPayMode() {
        return taxPayMode;
    }

    public void setTaxPayMode(String taxPayMode) {
        this.taxPayMode = taxPayMode == null ? null : taxPayMode.trim();
    }

    public Date getTaxPayDate() {
        return taxPayDate;
    }

    public void setTaxPayDate(Date taxPayDate) {
        this.taxPayDate = taxPayDate;
    }

    public Integer getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(Integer invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }
}