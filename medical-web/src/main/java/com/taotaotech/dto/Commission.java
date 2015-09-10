package com.taotaotech.dto;

/**
 * 佣金结算单条记录
 */

public class Commission {
    /*
            药品编码 药品名称 客户码 终端名称 月份(开票日期) 业务员姓名  业务员费用 二级费用 三级费用
            厂家费用 附加费用1 附加费用2 附加费用3 营业额 总费用
        */
    private Integer id;
    private String medicineCode;//药品编码
    private String medicineName;//药品名称
    private String clientCode;//客户码
    private String clientName;//客户名称
    private String invoiceDate;//开票日期
    private String salesmanName;//业务员姓名
    private String salesmanCharge;//业务员费用
    private String twoLevelCharge;//二级费用
    private String threeLevelCharge;//三级费用
    private String manufacturerCharge;//厂家费用
    private String addCharge1;//附加费用1
    private String addCharge2;//附加费用2
    private String addCharge3;//附加费用3
    private String businessFee;//营业额
    private String totalCharge;//总费用

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMedicineCode() {
        return medicineCode;
    }

    public void setMedicineCode(String medicineCode) {
        this.medicineCode = medicineCode;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getClientCode() {
        return clientCode;
    }

    public void setClientCode(String clientCode) {
        this.clientCode = clientCode;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getSalesmanName() {
        return salesmanName;
    }

    public void setSalesmanName(String salesmanName) {
        this.salesmanName = salesmanName;
    }

    public String getSalesmanCharge() {
        return salesmanCharge;
    }

    public void setSalesmanCharge(String salesmanCharge) {
        this.salesmanCharge = salesmanCharge;
    }

    public String getTwoLevelCharge() {
        return twoLevelCharge;
    }

    public void setTwoLevelCharge(String twoLevelCharge) {
        this.twoLevelCharge = twoLevelCharge;
    }

    public String getThreeLevelCharge() {
        return threeLevelCharge;
    }

    public void setThreeLevelCharge(String threeLevelCharge) {
        this.threeLevelCharge = threeLevelCharge;
    }

    public String getManufacturerCharge() {
        return manufacturerCharge;
    }

    public void setManufacturerCharge(String manufacturerCharge) {
        this.manufacturerCharge = manufacturerCharge;
    }

    public String getAddCharge1() {
        return addCharge1;
    }

    public void setAddCharge1(String addCharge1) {
        this.addCharge1 = addCharge1;
    }

    public String getAddCharge2() {
        return addCharge2;
    }

    public void setAddCharge2(String addCharge2) {
        this.addCharge2 = addCharge2;
    }

    public String getAddCharge3() {
        return addCharge3;
    }

    public void setAddCharge3(String addCharge3) {
        this.addCharge3 = addCharge3;
    }

    public String getBusinessFee() {
        return businessFee;
    }

    public void setBusinessFee(String businessFee) {
        this.businessFee = businessFee;
    }

    public String getTotalCharge() {
        return totalCharge;
    }

    public void setTotalCharge(String totalCharge) {
        this.totalCharge = totalCharge;
    }
}
