package com.taotaotech.domain;

import com.taotaotech.service.Page;
import org.codehaus.jackson.annotate.JsonIgnore;

import javax.xml.bind.annotation.XmlTransient;

public class MedicinePolicy {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String regional;

//    private String userCode;

    private String month;

    private String medicineCode;

    private String clientCode;

    private Float salesmanPolicy;

    private Float clinicalPolicy;

    private Float manufacturerPolicy;

//    private String twoLevelCode;

    private Float twoLevelPolicy;

//    private String threeLevelCode;

    private Float threeLevelPolicy;

    private Float addPolicy1;

    private Float addPolicy2;

    private Float addPolicy3;

    private Float price;

    protected Page<MedicinePolicy> page;

    @JsonIgnore
    @XmlTransient
    public Page<MedicinePolicy> getPage() {
        if (page == null){
            page = new Page<MedicinePolicy>();
        }
        return page;
    }

    public Page<MedicinePolicy> setPage(Page<MedicinePolicy> page) {
        this.page = page;
        return page;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRegional() {
        return regional;
    }

    public void setRegional(String regional) {
        this.regional = regional == null ? null : regional.trim();
    }

//    public String getUserCode() {
//        return userCode;
//    }
//
//    public void setUserCode(String userCode) {
//        this.userCode = userCode == null ? null : userCode.trim();
//    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month == null ? null : month.trim();
    }

    public String getMedicineCode() {
        return medicineCode;
    }

    public void setMedicineCode(String medicineCode) {
        this.medicineCode = medicineCode == null ? null : medicineCode.trim();
    }

    public String getClientCode() {
        return clientCode;
    }

    public void setClientCode(String clientCode) {
        this.clientCode = clientCode == null ? null : clientCode.trim();
    }

    public Float getSalesmanPolicy() {
        return salesmanPolicy;
    }

    public void setSalesmanPolicy(Float salesmanPolicy) {
        this.salesmanPolicy = salesmanPolicy;
    }

    public Float getClinicalPolicy() {
        return clinicalPolicy;
    }

    public void setClinicalPolicy(Float clinicalPolicy) {
        this.clinicalPolicy = clinicalPolicy;
    }

    public Float getManufacturerPolicy() {
        return manufacturerPolicy;
    }

    public void setManufacturerPolicy(Float manufacturerPolicy) {
        this.manufacturerPolicy = manufacturerPolicy;
    }

//    public String getTwoLevelCode() {
//        return twoLevelCode;
//    }
//
//    public void setTwoLevelCode(String twoLevelCode) {
//        this.twoLevelCode = twoLevelCode == null ? null : twoLevelCode.trim();
//    }

    public Float getTwoLevelPolicy() {
        return twoLevelPolicy;
    }

    public void setTwoLevelPolicy(Float twoLevelPolicy) {
        this.twoLevelPolicy = twoLevelPolicy;
    }

//    public String getThreeLevelCode() {
//        return threeLevelCode;
//    }
//
//    public void setThreeLevelCode(String threeLevelCode) {
//        this.threeLevelCode = threeLevelCode == null ? null : threeLevelCode.trim();
//    }

    public Float getThreeLevelPolicy() {
        return threeLevelPolicy;
    }

    public void setThreeLevelPolicy(Float threeLevelPolicy) {
        this.threeLevelPolicy = threeLevelPolicy;
    }

    public Float getAddPolicy1() {
        return addPolicy1;
    }

    public void setAddPolicy1(Float addPolicy1) {
        this.addPolicy1 = addPolicy1;
    }

    public Float getAddPolicy2() {
        return addPolicy2;
    }

    public void setAddPolicy2(Float addPolicy2) {
        this.addPolicy2 = addPolicy2;
    }

    public Float getAddPolicy3() {
        return addPolicy3;
    }

    public void setAddPolicy3(Float addPolicy3) {
        this.addPolicy3 = addPolicy3;
    }
}