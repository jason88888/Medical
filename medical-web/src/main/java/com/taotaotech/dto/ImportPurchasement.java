package com.taotaotech.dto;

/**
 * @author zk
 * @date 2015/10/1 14:44
 * @description 从excel采购表导入的表
 */
public class ImportPurchasement {
    //采购销售类别
    private String purchaseSaleType;
    //采购付款日期
    private String purchasePayDate;
    //采购付款年月
    private String purchasePayYearAndMonth;
    //采购入库日期
    private String purchaseStoreDate;
    //采购入库年月
    private String purchaseStoreYearAndMonth;
    //实际入库地点
    private String actualStorePlace;
    //采购申请单号
    private String purchaseSaleCode;
    //药品名称
    private String medicineName;
    //药品唯一代码
    private String medicineUniqueCode;
    //药品代码
    private String medicineCode;
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
    //批号
    private String lotNumber;
    //有效期
    private String validityPeriod;
    //采购单价
    private String purchasePrice;
    //付款金额
    private String paymentMoney;
    //业务流程及价
    private String workFlow;
    //为所属客户
    private String clientName;
    //采购销售区域
    private String saleArea;
    //进项单价
    private String purchaseUnitPrice;
    //进项金额
    private String purchaseMoney;
    //应付税
    private String tax;
    //付税方式
    private String taxPayMode;
    //付税日期（年月日）
    private String taxPayDate;
    //付税年月
    private String taxPayYearAndMonth;
    //发票号码
    private String invoiceNumber;
    //开票日期（年月日）
    private String invoiceDate;
    //开票年月
    private String invoiceYearAndMonth;
    //采购条目生成是否已核对
    private String check;

    public String getPurchaseSaleType() {
        return purchaseSaleType;
    }

    public void setPurchaseSaleType(String purchaseSaleType) {
        this.purchaseSaleType = purchaseSaleType;
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
        this.actualStorePlace = actualStorePlace;
    }

    public String getPurchaseSaleCode() {
        return purchaseSaleCode;
    }

    public void setPurchaseSaleCode(String purchaseSaleCode) {
        this.purchaseSaleCode = purchaseSaleCode;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
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
        this.saleCompany = saleCompany;
    }

    public String getBuyCompany() {
        return buyCompany;
    }

    public void setBuyCompany(String buyCompany) {
        this.buyCompany = buyCompany;
    }

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

    public Integer getPurchaseNumber() {
        return purchaseNumber;
    }

    public void setPurchaseNumber(Integer purchaseNumber) {
        this.purchaseNumber = purchaseNumber;
    }

    public String getLotNumber() {
        return lotNumber;
    }

    public void setLotNumber(String lotNumber) {
        this.lotNumber = lotNumber;
    }

    public String getValidityPeriod() {
        return validityPeriod;
    }

    public void setValidityPeriod(String validityPeriod) {
        this.validityPeriod = validityPeriod;
    }

    public String getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(String purchasePrice) {
        this.purchasePrice = purchasePrice;
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

    public String getCheck() {
        return check;
    }

    public void setCheck(String ifCheck) {
        this.check = ifCheck;
    }

    public String getPurchasePayYearAndMonth() {
        return purchasePayYearAndMonth;
    }

    public void setPurchasePayYearAndMonth(String purchasePayYearAndMonth) {
        this.purchasePayYearAndMonth = purchasePayYearAndMonth;
    }

    public String getPurchaseStoreYearAndMonth() {
        return purchaseStoreYearAndMonth;
    }

    public void setPurchaseStoreYearAndMonth(String purchaseStoreYearAndMonth) {
        this.purchaseStoreYearAndMonth = purchaseStoreYearAndMonth;
    }

    public String getMedicineUniqueCode() {
        return medicineUniqueCode;
    }

    public void setMedicineUniqueCode(String medicineUniqueCode) {
        this.medicineUniqueCode = medicineUniqueCode;
    }

    public String getMedicineCode() {
        return medicineCode;
    }

    public void setMedicineCode(String medicineCode) {
        this.medicineCode = medicineCode;
    }

    public String getTaxPayYearAndMonth() {
        return taxPayYearAndMonth;
    }

    public void setTaxPayYearAndMonth(String taxPayYearAndMonth) {
        this.taxPayYearAndMonth = taxPayYearAndMonth;
    }

    public String getInvoiceYearAndMonth() {
        return invoiceYearAndMonth;
    }

    public void setInvoiceYearAndMonth(String invoiceYearAndMonth) {
        this.invoiceYearAndMonth = invoiceYearAndMonth;
    }
}
