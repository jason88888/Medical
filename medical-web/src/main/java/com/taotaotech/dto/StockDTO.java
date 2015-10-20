package com.taotaotech.dto;

import com.taotaotech.domain.Stock;

/**
 * @author Cailin.Chen
 * @Date 15/10/20
 * @eMail cailin618@sina.com
 */

public class StockDTO extends Stock {
    private String medicineName;
    private String warehouseName;

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }
}
