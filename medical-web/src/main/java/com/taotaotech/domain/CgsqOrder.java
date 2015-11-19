package com.taotaotech.domain;

import com.taotaotech.core.domain.DataEntity;

import java.util.Date;

/**
 * �ɹ����뵥
 */
public class CgsqOrder extends DataEntity<CgsqOrder> {
    //id
    private Integer id;
    //�ɹ����뵥��
    private String code;
    //��������
    private String billDate;
    //ҩƷid
    private Integer medicineId;
    //������id
    private Integer sysUserId;
    //��Ӧ��id
    private Integer providerId;
    //ʵ�ʵ���
    private Long unitPrice;
    //�߿�����
    private Long highUnitPrice;
    //�ɹ����뵥��
    private String orderCode;
    //�ɹ�����
    private String purchasePrice;
    //������
    private String purchaseMoney;
    //�ɹ�����
    private Integer quantity;
    //��λ
    private String units;
    //Ӧ��˰
    private String tax;
    //��˰��ʽ
    private String taxpayMode;
    //��˰����
    private String taxpayDate;
    //��ע
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

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode == null ? null : orderCode.trim();
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

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax == null ? null : tax.trim();
    }

    public String getTaxpayMode() {
        return taxpayMode;
    }

    public void setTaxpayMode(String taxpayMode) {
        this.taxpayMode = taxpayMode == null ? null : taxpayMode.trim();
    }

    public String getTaxpayDate() {
        return taxpayDate;
    }

    public void setTaxpayDate(String taxpayDate) {
        this.taxpayDate = taxpayDate == null ? null : taxpayDate.trim();
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript == null ? null : descript.trim();
    }
}