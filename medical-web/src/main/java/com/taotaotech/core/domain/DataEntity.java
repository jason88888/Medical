package com.taotaotech.core.domain;

import org.codehaus.jackson.annotate.JsonIgnore;

import java.util.Date;

/**
 * 数据Entity类
 */
public abstract class DataEntity<T> extends BaseEntity {

    private static final long serialVersionUID = 1L;

    protected Date createDate;	// 创建日期
    protected Date updateDate;	// 更新日期
    protected boolean delFlag; 	// 删除标记（0：正常；1：删除；）


    public DataEntity() {
        super();
        this.delFlag = DEL_FLAG_NORMAL;
    }

    public DataEntity(Integer id) {
        super(id);
    }

    /**
     * 插入之前执行方法，需要手动调用
     */
    @Override
    public void preInsert(){
        this.updateDate = new Date();
        this.createDate = this.updateDate;
    }

    /**
     * 更新之前执行方法，需要手动调用
     */
    @Override
    public void preUpdate(){
        this.updateDate = new Date();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @JsonIgnore
    public boolean isDelFlag() {
        return delFlag;
    }

    public void setDelFlag(boolean delFlag) {
        this.delFlag = delFlag;
    }
}
