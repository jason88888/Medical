package com.taotaotech.dao;

import com.taotaotech.core.persistence.CrudMapper;
import com.taotaotech.domain.XsckOrder;
import com.taotaotech.domain.XsthOrder;

public interface XsthOrderMapper  extends CrudMapper<XsthOrder> {
    int deleteByPrimaryKey(Integer id);

    int insert(XsthOrder record);

    int insertSelective(XsthOrder record);

    XsthOrder selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(XsthOrder record);

    int updateByPrimaryKey(XsthOrder record);
}