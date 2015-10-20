package com.taotaotech.dto;

import com.taotaotech.domain.RkOrder;

/**
 * @author Cailin.Chen
 * @Date 15/10/20
 * @eMail cailin618@sina.com
 */

public class RkOrderDTO extends RkOrder {
    private String warehouseName;
    private String medicineName;
    private String operatorName;
    private String providerName;

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

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }
}
