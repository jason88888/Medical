package com.taotaotech.core.domain;

import com.taotaotech.core.persistence.Page;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.codehaus.jackson.annotate.JsonIgnore;

import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;

/**
 * Entity支持类
 */
public abstract class BaseEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * 当前实体分页对象
     */
    protected Page<T> page;

    public BaseEntity() {

    }
    public BaseEntity(Integer id) {
        this();
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @JsonIgnore
    @XmlTransient
    public Page<T> getPage() {
        if (page == null){
            page = new Page<T>();
        }
        return page;
    }

    public Page<T> setPage(Page<T> page) {
        this.page = page;
        return page;
    }

    /**
     * 插入之前执行方法，子类实现
     */
    public abstract void preInsert();

    /**
     * 更新之前执行方法，子类实现
     */
    public abstract void preUpdate();

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }


    /**
     * 删除标记（0：正常；1：删除；）
     */
    public static final boolean DEL_FLAG_NORMAL = false;
    public static final boolean DEL_FLAG_DELETE = true;
}
