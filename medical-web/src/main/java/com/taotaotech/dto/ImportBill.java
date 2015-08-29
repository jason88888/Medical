package com.taotaotech.dto;

/**
 * @author Cailin.Chen
 * @Date 15/8/30
 * @eMail cailin618@sina.com
 */

public class ImportBill {
     /*
         部门名称 药品编号 品名 规格 生产厂商 客户码 客户名称 开票日期 单位 数量 单价 批号 有效期 单据号 商业类型
     */
    private String departmentName;
    private String departmentCode;
    private String medicineCode;
    private String medicineName;
    private String medicineSpecification;//药品规格

    private String manufacturerName;//厂家
    private String clientCode;//客户码
    private String clientName;//客户名称
    private String invoiceDate;//开票日期
    private String units;//单位

    private String number;//数量
    private String price;//单价
    private String lotNumber;//批号
    private String validityPeriod;//有效期
    private String billCode;//单据号
    private String businessType;//商业类型

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
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

    public String getMedicineSpecification() {
        return medicineSpecification;
    }

    public void setMedicineSpecification(String medicineSpecification) {
        this.medicineSpecification = medicineSpecification;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
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

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
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

    public String getBillCode() {
        return billCode;
    }

    public void setBillCode(String billCode) {
        this.billCode = billCode;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }


    @Override
    public String toString() {
        return "ImportBill{" +
                "departmentName='" + departmentName + '\'' +
                ", departmentCode='" + departmentCode + '\'' +
                ", medicineCode='" + medicineCode + '\'' +
                ", medicineName='" + medicineName + '\'' +
                ", medicineSpecification='" + medicineSpecification + '\'' +
                ", manufacturerName='" + manufacturerName + '\'' +
                ", clientCode='" + clientCode + '\'' +
                ", clientName='" + clientName + '\'' +
                ", invoiceDate='" + invoiceDate + '\'' +
                ", units='" + units + '\'' +
                ", number='" + number + '\'' +
                ", price='" + price + '\'' +
                ", lotNumber='" + lotNumber + '\'' +
                ", validityPeriod='" + validityPeriod + '\'' +
                ", billCode='" + billCode + '\'' +
                ", businessType='" + businessType + '\'' +
                '}';
    }
}
