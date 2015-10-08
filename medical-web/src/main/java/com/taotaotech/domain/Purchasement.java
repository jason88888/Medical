package com.taotaotech.domain;

import com.taotaotech.core.domain.DataEntity;

import java.util.Date;

public class Purchasement extends DataEntity<Purchasement> {
    //id
    private Integer id;
    //采购销售类别
    private String purchaseSaleType;
    //采购付款日期
    private String purchasePayDate;
    //采购入库日期
    private String purchaseStoreDate;
    //实际入库地点
    private String actualStorePlace;
    //采购申请单号
    private String purchaseSaleCode;
    //药品名称
    private String medicineName;
    //药品唯一代码
    private String medicineUniqueCode;
    //生产厂家
    private String manufacturerName;
    //规格
    private String specification;
    //单位
    private String units;
    //装箱量
    private Integer packageNumber;
    //我司上家销货单位
    private String saleCompany;
    //我司或下家购货单位
    private String buyCompany;
    //打款分类
    private String paymentCategory;
    //付款方式
    private String paymentMode;
    //购进数量
    private Integer purchaseNumber;
    //采购单价
    private Long purchasePrice;
    //付款金额
    private String paymentMoney;
    //业务流程及价
    private String workFlow;
    //为所属客户
    private String clientName;
    //采购销售区域
    private String saleArea;
    //进项单价
    private Long purchaseUnitPrice;
    //进项金额
    private String purchaseMoney;
    //应付税
    private String tax;
    //付税方式
    private String taxPayMode;
    //付税日期
    private String taxPayDate;
    //发票号码
    private Integer invoiceNumber;
    //开票日期
    private String invoiceDate;
    //采购条目生成是否已核对
    private String ifCheck;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPurchaseSaleType() {
        return purchaseSaleType;
    }

    public void setPurchaseSaleType(String purchaseSaleType) {
        this.purchaseSaleType = purchaseSaleType == null ? null : purchaseSaleType.trim();
    }

    public String getPurchasePayDate() {
        return purchasePayDate;
    }

    public void setPurchasePayDate(String purchasePayDate) {
        this.purchasePayDate = purchasePayDate;
    }

    public String getPurchaseStoreDate() {
        return purchaseStoreDate;
    }

    public void setPurchaseStoreDate(String purchaseStoreDate) {
        this.purchaseStoreDate = purchaseStoreDate;
    }

    public String getActualStorePlace() {
        return actualStorePlace;
    }

    public void setActualStorePlace(String actualStorePlace) {
        this.actualStorePlace = actualStorePlace == null ? null : actualStorePlace.trim();
    }

    public String getPurchaseSaleCode() {
        return purchaseSaleCode;
    }

    public void setPurchaseSaleCode(String purchaseSaleCode) {
        this.purchaseSaleCode = purchaseSaleCode == null ? null : purchaseSaleCode.trim();
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName == null ? null : medicineName.trim();
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName == null ? null : manufacturerName.trim();
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification == null ? null : specification.trim();
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units == null ? null : units.trim();
    }

    public Integer getPackageNumber() {
        return packageNumber;
    }

    public void setPackageNumber(Integer packageNumber) {
        this.packageNumber = packageNumber;
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

    public Integer getPurchaseNumber() {
        return purchaseNumber;
    }

    public void setPurchaseNumber(Integer purchaseNumber) {
        this.purchaseNumber = purchaseNumber;
    }

    public Long getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Long purchasePrice) {
        this.purchasePrice = purchasePrice;
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

    public String getTaxPayDate() {
        return taxPayDate;
    }

    public void setTaxPayDate(String taxPayDate) {
        this.taxPayDate = taxPayDate;
    }

    public Integer getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(Integer invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getIfCheck() {
        return ifCheck;
    }

    public void setIfCheck(String ifCheck) {
        this.ifCheck = ifCheck == null ? null : ifCheck.trim();
    }

    public String getMedicineUniqueCode() {
        return medicineUniqueCode;
    }

    public void setMedicineUniqueCode(String medicineUniqueCode) {
        this.medicineUniqueCode = medicineUniqueCode;
    }
}