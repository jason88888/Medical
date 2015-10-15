package com.taotaotech.dao;

import com.taotaotech.core.persistence.CrudMapper;
import com.taotaotech.domain.RkOrder;
import com.taotaotech.domain.Stock;

public interface StockMapper extends CrudMapper<Stock> {
    int deleteByPrimaryKey(Integer id);

    int insert(Stock record);

    int insertSelective(Stock record);

    Stock selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Stock record);

    int updateByPrimaryKey(Stock record);
}