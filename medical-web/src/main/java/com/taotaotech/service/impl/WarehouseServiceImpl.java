package com.taotaotech.service.impl;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.taotaotech.core.service.CrudService;
import com.taotaotech.dao.WarehouseMapper;
import com.taotaotech.domain.Warehouse;
import com.taotaotech.service.IWarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zk
 * @date 2015/9/4 10:06
 * @description
 */
@Service
public class WarehouseServiceImpl extends CrudService<WarehouseMapper,Warehouse> implements IWarehouseService{
    @Autowired
    private WarehouseMapper providerMapper;


    @Override
    public List<Warehouse> findWarehouseList() {
        return providerMapper.findWarehouseList(new PageBounds());
    }
}
