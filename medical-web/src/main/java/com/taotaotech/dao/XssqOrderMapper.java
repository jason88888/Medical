package com.taotaotech.dao;

import com.taotaotech.core.persistence.CrudMapper;
import com.taotaotech.domain.XsckOrder;
import com.taotaotech.domain.XssqOrder;

public interface XssqOrderMapper  extends CrudMapper<XssqOrder> {
    int deleteByPrimaryKey(Integer id);

    int insert(XssqOrder record);

    int insertSelective(XssqOrder record);

    XssqOrder selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(XssqOrder record);

    int updateByPrimaryKey(XssqOrder record);
}