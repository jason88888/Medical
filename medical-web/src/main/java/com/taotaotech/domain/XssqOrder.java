package com.taotaotech.domain;

import com.taotaotech.core.domain.DataEntity;

import java.util.Date;

public class XssqOrder extends DataEntity<XssqOrder> {
    private Integer id;

    private String code;

    private String billDate;

    private Integer warehouseId;

    private Integer medicineId;

    private Integer sysUserId;

    private Integer agentId;

    private Integer commercialCompanyId;

    private String orderCode;

    private String salePrice;

    private String saleMoney;

    private Integer quantity;

    private String units;

    private String descript;

    private Date createDate;

    private Date updateDate;

    private Boolean delFlag;

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

    public Integer getAgentId() {
        return agentId;
    }

    public void setAgentId(Integer agentId) {
        this.agentId = agentId;
    }

    public Integer getCommercialCompanyId() {
        return commercialCompanyId;
    }

    public void setCommercialCompanyId(Integer commercialCompanyId) {
        this.commercialCompanyId = commercialCompanyId;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode == null ? null : orderCode.trim();
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Boolean getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }
}