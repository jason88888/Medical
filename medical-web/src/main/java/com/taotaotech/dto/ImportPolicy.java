package com.taotaotech.dto;

/**
 * @author Cailin.Chen
 * @Date 15/8/28
 * @eMail cailin618@sina.com
 */

public class ImportPolicy {
    private String medicineCode;
    private String medicineName;
    private String medicineSpecification;//药品规格
    private String units;//单位
    private String manufacturerName;//厂家
    private String price;//单价
    private String regionalCode;//区域代码
    private String regionalName;//区域
    private String saleMode;//销售模式
    private String month;//月份
    private String salesmanName;//业务员姓名
    private String salesmanCode;//业务员代码
    private String salesmanPolicy;//业务员政策
    private String twoLevelCode;//二级代码
    private String twoLevelPolicy;//二级政策
    private String threeLevelCode;//三级代码
    private String threeLevelPolicy;//三级政策
    private String clinicalPolicy;//临床政策
    private String manufacturerPolicy;//厂家政策
    private String addPolicy1;//附加政策1
    private String addPolicy2;//附加政策2
    private String addPolicy3;//附加政策3
    private String clientCode;//客户代码
    private String clientName;//客户名称

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

    public String getMedicineSpecification() {
        return medicineSpecification;
    }

    public void setMedicineSpecification(String medicineSpecification) {
        this.medicineSpecification = medicineSpecification;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getRegionalName() {
        return regionalName;
    }

    public void setRegionalName(String regionalName) {
        this.regionalName = regionalName;
    }

    public String getSaleMode() {
        return saleMode;
    }

    public void setSaleMode(String saleMode) {
        this.saleMode = saleMode;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getSalesmanName() {
        return salesmanName;
    }

    public void setSalesmanName(String salesmanName) {
        this.salesmanName = salesmanName;
    }

    public String getSalesmanCode() {
        return salesmanCode;
    }

    public void setSalesmanCode(String salesmanCode) {
        this.salesmanCode = salesmanCode;
    }

    public String getSalesmanPolicy() {
        return salesmanPolicy;
    }

    public void setSalesmanPolicy(String salesmanPolicy) {
        this.salesmanPolicy = salesmanPolicy;
    }

    public String getTwoLevelCode() {
        return twoLevelCode;
    }

    public void setTwoLevelCode(String twoLevelCode) {
        this.twoLevelCode = twoLevelCode;
    }

    public String getTwoLevelPolicy() {
        return twoLevelPolicy;
    }

    public void setTwoLevelPolicy(String twoLevelPolicy) {
        this.twoLevelPolicy = twoLevelPolicy;
    }

    public String getThreeLevelCode() {
        return threeLevelCode;
    }

    public void setThreeLevelCode(String threeLevelCode) {
        this.threeLevelCode = threeLevelCode;
    }

    public String getThreeLevelPolicy() {
        return threeLevelPolicy;
    }

    public void setThreeLevelPolicy(String threeLevelPolicy) {
        this.threeLevelPolicy = threeLevelPolicy;
    }

    public String getClinicalPolicy() {
        return clinicalPolicy;
    }

    public void setClinicalPolicy(String clinicalPolicy) {
        this.clinicalPolicy = clinicalPolicy;
    }

    public String getManufacturerPolicy() {
        return manufacturerPolicy;
    }

    public void setManufacturerPolicy(String manufacturerPolicy) {
        this.manufacturerPolicy = manufacturerPolicy;
    }

    public String getAddPolicy1() {
        return addPolicy1;
    }

    public void setAddPolicy1(String addPolicy1) {
        this.addPolicy1 = addPolicy1;
    }

    public String getAddPolicy2() {
        return addPolicy2;
    }

    public void setAddPolicy2(String addPolicy2) {
        this.addPolicy2 = addPolicy2;
    }

    public String getAddPolicy3() {
        return addPolicy3;
    }

    public void setAddPolicy3(String addPolicy3) {
        this.addPolicy3 = addPolicy3;
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

    public String getRegionalCode() {
        return regionalCode;
    }

    public void setRegionalCode(String regionalCode) {
        this.regionalCode = regionalCode;
    }

    @Override
    public String toString() {
        return "ImportPolicy{" +
                "medicineCode='" + medicineCode + '\'' +
                ", medicineName='" + medicineName + '\'' +
                ", medicineSpecification='" + medicineSpecification + '\'' +
                ", units='" + units + '\'' +
                ", manufacturerame='" + manufacturerName + '\'' +
                ", price='" + price + '\'' +
                ", regionalName='" + regionalName + '\'' +
                ", saleMode='" + saleMode + '\'' +
                ", month='" + month + '\'' +
                ", salesmanName='" + salesmanName + '\'' +
                ", salesmanCode='" + salesmanCode + '\'' +
                ", salesmanPolicy='" + salesmanPolicy + '\'' +
                ", twoLevelCode='" + twoLevelCode + '\'' +
                ", twoLevelPolicy='" + twoLevelPolicy + '\'' +
                ", threeLevelCode='" + threeLevelCode + '\'' +
                ", threeLevelPolicy='" + threeLevelPolicy + '\'' +
                ", clinicalPolicy='" + clinicalPolicy + '\'' +
                ", manufacturerPolicy='" + manufacturerPolicy + '\'' +
                ", addPolicy1='" + addPolicy1 + '\'' +
                ", addPolicy2='" + addPolicy2 + '\'' +
                ", addPolicy3='" + addPolicy3 + '\'' +
                ", cientCode='" + clientCode + '\'' +
                ", cientName='" + clientName + '\'' +
                '}';
    }
}

