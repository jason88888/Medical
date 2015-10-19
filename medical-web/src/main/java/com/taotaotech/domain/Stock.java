package com.taotaotech.domain;

import com.taotaotech.core.domain.DataEntity;

import java.util.Date;

/**
 * 库存信息，某个仓库，某个产品的库存
 */
public class Stock extends DataEntity<Stock> {
    //id
    private Integer id;
    //药品id
    private Integer medicineId;
    //仓库id
    private Integer warehouseId;
    //开始数量
    private String startQuantity;
    //现有数量
    private String nowQuantity;
    //备注
    private String descript;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(Integer medicineId) {
        this.medicineId = medicineId;
    }

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getStartQuantity() {
        return startQuantity;
    }

    public void setStartQuantity(String startQuantity) {
        this.startQuantity = startQuantity == null ? null : startQuantity.trim();
    }

    public String getNowQuantity() {
        return nowQuantity;
    }

    public void setNowQuantity(String nowQuantity) {
        this.nowQuantity = nowQuantity == null ? null : nowQuantity.trim();
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript == null ? null : descript.trim();
    }
}