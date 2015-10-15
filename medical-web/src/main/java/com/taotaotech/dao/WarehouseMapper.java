package com.taotaotech.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.taotaotech.core.persistence.CrudMapper;
import com.taotaotech.domain.Stock;
import com.taotaotech.domain.Warehouse;

import java.util.List;

public interface WarehouseMapper extends CrudMapper<Warehouse> {
    int deleteByPrimaryKey(Integer id);

    int insert(Warehouse record);

    int insertSelective(Warehouse record);

    Warehouse selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Warehouse record);

    List<Warehouse> findWarehouseList(PageBounds pageBounds);

    int updateByPrimaryKey(Warehouse record);
}