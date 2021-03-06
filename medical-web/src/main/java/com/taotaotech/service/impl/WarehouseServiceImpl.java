package com.taotaotech.service.impl;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.taotaotech.core.service.CrudService;
import com.taotaotech.dao.WarehouseMapper;
import com.taotaotech.domain.Warehouse;
import com.taotaotech.service.IWarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author zk
 * @date 2015/9/4 10:06
 * @description
 */
@Service
public class WarehouseServiceImpl extends CrudService<WarehouseMapper,Warehouse> implements IWarehouseService{
    @Autowired
    private WarehouseMapper warehouseMapper;


    @Override
    public List<Warehouse> findFirstWarehouseList(Map map, PageBounds pageBounds) {
        return warehouseMapper.findFirstList(map,pageBounds);
    }

    @Override
    public List<Warehouse> findSecondWarehouseList(Map map, PageBounds pageBounds) {
        return warehouseMapper.findSecondList(map,pageBounds);
    }
}
