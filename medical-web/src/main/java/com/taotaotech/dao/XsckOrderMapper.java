package com.taotaotech.dao;

import com.taotaotech.core.persistence.CrudMapper;
import com.taotaotech.domain.XsckOrder;

public interface XsckOrderMapper extends CrudMapper<XsckOrder> {
    int deleteByPrimaryKey(Integer id);

    int insert(XsckOrder record);

    int insertSelective(XsckOrder record);

    XsckOrder selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(XsckOrder record);

    int updateByPrimaryKey(XsckOrder record);
}