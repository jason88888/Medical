package com.taotaotech.domain;

import com.taotaotech.core.domain.DataEntity;

/**
 * 代理商
 */
public class AgentClient extends DataEntity<AgentClient> {
    private Integer id;

    private String name;

    private String engName;

    private String attribution;

    private String areaName;

    private String chiefName;

    private String faxNo;

    private String telephone;

    private String level;

    private String whoseClient;

    private String saleArea;

    private String descript;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getEngName() {
        return engName;
    }

    public void setEngName(String engName) {
        this.engName = engName == null ? null : engName.trim();
    }

    public String getAttribution() {
        return attribution;
    }

    public void setAttribution(String attribution) {
        this.attribution = attribution == null ? null : attribution.trim();
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName == null ? null : areaName.trim();
    }

    public String getChiefName() {
        return chiefName;
    }

    public void setChiefName(String chiefName) {
        this.chiefName = chiefName == null ? null : chiefName.trim();
    }

    public String getFaxNo() {
        return faxNo;
    }

    public void setFaxNo(String faxNo) {
        this.faxNo = faxNo == null ? null : faxNo.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    public String getWhoseClient() {
        return whoseClient;
    }

    public void setWhoseClient(String whoseClient) {
        this.whoseClient = whoseClient == null ? null : whoseClient.trim();
    }

    public String getSaleArea() {
        return saleArea;
    }

    public void setSaleArea(String saleArea) {
        this.saleArea = saleArea == null ? null : saleArea.trim();
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript == null ? null : descript.trim();
    }
}