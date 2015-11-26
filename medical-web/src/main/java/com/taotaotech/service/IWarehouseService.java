package com.taotaotech.service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.taotaotech.core.service.IBaseService;
import com.taotaotech.domain.Warehouse;

import java.util.List;
import java.util.Map;

/**
 * @author zk
 * @date 2015/9/4 10:04
 * @description
 */
public interface IWarehouseService extends IBaseService<Warehouse> {
    public List<Warehouse> findFirstWarehouseList(Map map, PageBounds pageBounds);
    public List<Warehouse> findSecondWarehouseList(Map map, PageBounds pageBounds);
}
