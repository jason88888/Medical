package com.taotaotech.dao;

import com.taotaotech.core.persistence.CrudMapper;
import com.taotaotech.domain.CgthOrder;

public interface CgthOrderMapper extends CrudMapper<CgthOrder> {
    int deleteByPrimaryKey(Integer id);

    int insert(CgthOrder record);

    int insertSelective(CgthOrder record);

    CgthOrder selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CgthOrder record);

    int updateByPrimaryKey(CgthOrder record);
}