package com.taotaotech.domain;

import java.util.Date;

public class PurchaseMoneytax {
    private Integer id;
    //打款分类
    private String paymentCategory;
    //付款方式
    private String paymentMode;
    //付款金额
    private String paymentMoney;
    //业务流程及价
    private String workFlow;
    //进项单价
    private Long purchaseUnitPrice;
    //进项金额
    private String purchaseMoney;
    //应付税
    private String tax;
    //付税方式
    private String taxPayMode;
    //付税日期
    private Date taxPayDate;
    //发票号码
    private Integer invoiceNumber;
    //开票日期
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