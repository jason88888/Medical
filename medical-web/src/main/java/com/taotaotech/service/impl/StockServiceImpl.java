package com.taotaotech.service.impl;

import com.taotaotech.core.service.CrudService;
import com.taotaotech.dao.StockMapper;
import com.taotaotech.domain.Stock;
import com.taotaotech.service.IStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Cailin.Chen
 * @Date 15/10/16
 * @eMail cailin618@sina.com
 */
@Service
public class StockServiceImpl extends CrudService<StockMapper,Stock> implements IStockService{
    @Autowired
    private StockMapper stockMapper;
    @Override
    public Stock getStockByMedicineIdAndWarehouseId(Integer medicineId, Integer warehouseId) {
        return stockMapper.getStockByMedicineIdAndWarehouseId(medicineId,warehouseId);
    }
}
