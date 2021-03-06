package com.taotaotech.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.taotaotech.core.persistence.CrudMapper;
import com.taotaotech.domain.Stock;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StockMapper extends CrudMapper<Stock> {
    int deleteByPrimaryKey(Integer id);

    int insert(Stock record);

    int insertSelective(Stock record);

    Stock selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Stock record);

    List<Stock> findStockList(PageBounds pageBounds);

    int updateByPrimaryKey(Stock record);

    Stock getStockByMedicineIdAndWarehouseId(@Param("medicineId")Integer medicineId, @Param("warehouseId")Integer warehouseId);
}