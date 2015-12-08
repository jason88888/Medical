package com.taotaotech.domain;

import com.taotaotech.core.domain.DataEntity;

import java.util.Date;

/**
 * 采购退货单
 */
public class CgthOrder extends DataEntity<CgthOrder> {
    //id
    private Integer id;
    //采购退货单编号
    private String code;
    //单据日期
    private String billDate;
    //仓库id
    private Integer warehouseId;
    //药品id
    private Integer medicineId;
    //操作人id
    private Integer sysUserId;
    //购进商业公司id（开票公司）
    private Integer commercialCompanyId;
    //代理商id
    private Integer agentId;
    //供应商id
    private Integer providerId;
    //实际单价
    private Long unitPrice;
    //高开单价
    private Long highUnitPrice;
    //退货付款日期
    private String returnDate;
    //退货出库日期
    private String outStoreDate;
    //退货单价D
    private String purchasePrice;
    //退款金额
    private String purchaseMoney;
    //入库数量
    private Integer quantity;
    //单位
    private String units;
    //备注
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
        this.code = code == null ? null : code.trim();
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

    public Integer getCommercialCompanyId() {
        return commercialCompanyId;
    }

    public void setCommercialCompanyId(Integer commercialCompanyId) {
        this.commercialCompanyId = commercialCompanyId;
    }

    public Integer getAgentId() {
        return agentId;
    }

    public void setAgentId(Integer agentId) {
        this.agentId = agentId;
    }

    public Integer getProviderId() {
        return providerId;
    }

    public void setProviderId(Integer providerId) {
        this.providerId = providerId;
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

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getOutStoreDate() {
        return outStoreDate;
    }

    public void setOutStoreDate(String outStoreDate) {
        this.outStoreDate = outStoreDate;
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
        this.units = units == null ? null : units.trim();
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript == null ? null : descript.trim();
    }
}