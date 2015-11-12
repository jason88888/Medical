package com.taotaotech.dto;

import com.taotaotech.domain.Client;
import com.taotaotech.domain.Medicine;
import com.taotaotech.domain.User;

/**
 * @author Cailin.Chen
 * @Date 15/11/12
 * @eMail cailin618@sina.com
 */

public class BillDTO {
    private Integer id;

    private String code; // 单据编号
    private String date; // 开票日期
    private String month; // 单据月份
    private Integer number; // 数量

    private Client client;

    private User user;

    private String twoLevelCode;
    private String twoLevelName;

    private String threeLevelCode;
    private String threeLevelName;

    private Medicine medicine;

    private String regional;

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
        this.code = code;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTwoLevelCode() {
        return twoLevelCode;
    }

    public void setTwoLevelCode(String twoLevelCode) {
        this.twoLevelCode = twoLevelCode;
    }

    public String getTwoLevelName() {
        return twoLevelName;
    }

    public void setTwoLevelName(String twoLevelName) {
        this.twoLevelName = twoLevelName;
    }

    public String getThreeLevelCode() {
        return threeLevelCode;
    }

    public void setThreeLevelCode(String threeLevelCode) {
        this.threeLevelCode = threeLevelCode;
    }

    public String getThreeLevelName() {
        return threeLevelName;
    }

    public void setThreeLevelName(String threeLevelName) {
        this.threeLevelName = threeLevelName;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public String getRegional() {
        return regional;
    }

    public void setRegional(String regional) {
        this.regional = regional;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }
}
