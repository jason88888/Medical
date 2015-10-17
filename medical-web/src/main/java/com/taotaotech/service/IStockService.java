package com.taotaotech.service;

import com.taotaotech.core.service.IBaseService;
import com.taotaotech.domain.Stock;

/**
 * @author Cailin.Chen
 * @Date 15/10/16
 * @eMail cailin618@sina.com
 */

public interface IStockService extends IBaseService<Stock> {
    Stock getStockByMedicineIdAndWarehouseId(Integer medicineId,Integer warehouseId);
}
