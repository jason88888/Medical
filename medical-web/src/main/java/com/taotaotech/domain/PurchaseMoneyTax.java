package com.taotaotech.domain;

/**
 * @author zk
 * @date 2015/10/2 10:04
 * @description 采购钱税管理
 */
public class PurchaseMoneyTax {
    //id
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
    private String purchaseUnitPrice;
    //进项金额
    private String purchaseMoney;
    //应付税
    private String tax;
    //付税方式
    private String taxPayMode;
    //付税日期
    private String taxPayDate;
    //发票号码
    private String invoiceNumber;
    //开票日期
    private String invoiceDate;

    public String getPaymentCategory() {
        return paymentCategory;
    }

    public void setPaymentCategory(String paymentCategory) {
        this.paymentCategory = paymentCategory;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public String getPaymentMoney() {
        return paymentMoney;
    }

    public void setPaymentMoney(String paymentMoney) {
        this.paymentMoney = paymentMoney;
    }

    public String getWorkFlow() {
        return workFlow;
    }

    public void setWorkFlow(String workFlow) {
        this.workFlow = workFlow;
    }

    public String getPurchaseUnitPrice() {
        return purchaseUnitPrice;
    }

    public void setPurchaseUnitPrice(String purchaseUnitPrice) {
        this.purchaseUnitPrice = purchaseUnitPrice;
    }

    public String getPurchaseMoney() {
        return purchaseMoney;
    }

    public void setPurchaseMoney(String purchaseMoney) {
        this.purchaseMoney = purchaseMoney;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public String getTaxPayMode() {
        return taxPayMode;
    }

    public void setTaxPayMode(String taxPayMode) {
        this.taxPayMode = taxPayMode;
    }

    public String getTaxPayDate() {
        return taxPayDate;
    }

    public void setTaxPayDate(String taxPayDate) {
        this.taxPayDate = taxPayDate;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }
}
