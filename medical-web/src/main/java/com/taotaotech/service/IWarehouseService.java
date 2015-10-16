package com.taotaotech.service;

import com.taotaotech.core.service.IBaseService;
import com.taotaotech.domain.Warehouse;

import java.util.List;

/**
 * @author zk
 * @date 2015/9/4 10:04
 * @description
 */
public interface IWarehouseService extends IBaseService<Warehouse> {
    public List<Warehouse> findWarehouseList();

}
