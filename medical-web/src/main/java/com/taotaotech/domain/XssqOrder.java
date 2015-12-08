package com.taotaotech.domain;

import com.taotaotech.core.domain.DataEntity;

import java.util.Date;

public class XssqOrder extends DataEntity<XssqOrder> {
    // id
    private Integer id;
    //销售申请单编号
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
    private Integer agentId;
    //购进商业公司id（开票公司）
    private Integer commercialCompanyId;
    //采购申请单号
    private String orderCode;
    //采购单价
    private String salePrice;
    //付款金额
    private String saleMoney;
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
}