package com.taotaotech.dao;

import com.taotaotech.core.persistence.CrudMapper;
import com.taotaotech.domain.Stock;
import com.taotaotech.domain.Warehouse;

public interface WarehouseMapper extends CrudMapper<Warehouse> {
    int deleteByPrimaryKey(Integer id);

    int insert(Warehouse record);

    int insertSelective(Warehouse record);

    Warehouse selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Warehouse record);

    int updateByPrimaryKey(Warehouse record);
}