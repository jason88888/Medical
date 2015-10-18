package com.taotaotech.domain;

import com.taotaotech.core.domain.DataEntity;

import java.util.Date;

/**
 * 入库单
 */
public class RkOrder extends DataEntity<RkOrder> {
    //id
    private Integer id;
    //入库单编号
    private String code;
    //单据日期
    private String billDate;
    //仓库id
    private Integer warehouseId;
    //药品id
    private Integer medicineId;
    //操作人id
    private Integer sysUserId;
    //代理商id
    private Integer agentClientId;
    //配送商id
    private Integer stockId;
    //实际单价
    private Long unitPrice;
    //高开单价
    private Long highUnitPrice;
    //采购付款日期
    private String payDate;
    //采购入库日期
    private String storeDate;
    //采购申请单号
    private String orderCode;
    //采购单价
    private String purchasePrice;
    //付款金额
    private String purchaseMoney;
    //进项单价(卖给代理商的单价)
    private String salePrice;
    //进项金额(卖给代理商的金额)
    private String saleMoney;
    //应付税
    private String tax;
    //付税方式
    private String taxpayMode;
    //付税日期
    private String taxpayDate;
    //发票号码
    private Integer invoiceNumber;
    //开票日期
    private String invoiceDate;

    private Integer quantity;//入库数量

    private String units;

    private String descript;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBillDate() {
        return billDate;
    }

    public void setBillDate(String billDate) {
        this.billDate = billDate == null ? null : billDate.trim();
    }

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Integer getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(Integer medicineId) {
        this.medicineId = medicineId;
    }

    public Integer getSysUserId() {
        return sysUserId;
    }

    public void setSysUserId(Integer sysUserId) {
        this.sysUserId = sysUserId;
    }

    public Integer getAgentClientId() {
        return agentClientId;
    }

    public void setAgentClientId(Integer agentClientId) {
        this.agentClientId = agentClientId;
    }

    public Integer getStockId() {
        return stockId;
    }

    public void setStockId(Integer stockId) {
        this.stockId = stockId;
    }

    public Long getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Long unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Long getHighUnitPrice() {
        return highUnitPrice;
    }

    public void setHighUnitPrice(Long highUnitPrice) {
        this.highUnitPrice = highUnitPrice;
    }

    public String getPayDate() {
        return payDate;
    }

    public void setPayDate(String payDate) {
        this.payDate = payDate == null ? null : payDate.trim();
    }

    public String getStoreDate() {
        return storeDate;
    }

    public void setStoreDate(String storeDate) {
        this.storeDate = storeDate == null ? null : storeDate.trim();
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode == null ? null : orderCode.trim();
    }

    public String getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(String purchasePrice) {
        this.purchasePrice = purchasePrice == null ? null : purchasePrice.trim();
    }

    public String getPurchaseMoney() {
        return purchaseMoney;
    }

    public void setPurchaseMoney(String purchaseMoney) {
        this.purchaseMoney = purchaseMoney == null ? null : purchaseMoney.trim();
    }

    public String getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(String salePrice) {
        this.salePrice = salePrice == null ? null : salePrice.trim();
    }

    public String getSaleMoney() {
        return saleMoney;
    }

    public void setSaleMoney(String saleMoney) {
        this.saleMoney = saleMoney == null ? null : saleMoney.trim();
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax == null ? null : tax.trim();
    }

    public String getTaxpayMode() {
        return taxpayMode;
    }

    public void setTaxpayMode(String taxpayMode) {
        this.taxpayMode = taxpayMode == null ? null : taxpayMode.trim();
    }

    public String getTaxpayDate() {
        return taxpayDate;
    }

    public void setTaxpayDate(String taxpayDate) {
        this.taxpayDate = taxpayDate == null ? null : taxpayDate.trim();
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
        this.invoiceDate = invoiceDate == null ? null : invoiceDate.trim();
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript == null ? null : descript.trim();
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }
}