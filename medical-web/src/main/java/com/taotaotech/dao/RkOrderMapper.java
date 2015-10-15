package com.taotaotech.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.taotaotech.core.persistence.CrudMapper;
import com.taotaotech.domain.Provider;
import com.taotaotech.domain.RkOrder;
import com.taotaotech.domain.Warehouse;

import java.util.List;

public interface RkOrderMapper extends CrudMapper<RkOrder> {
    int deleteByPrimaryKey(Integer id);

    int insert(RkOrder record);

    int insertSelective(RkOrder record);

    RkOrder selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RkOrder record);

    List<RkOrder> findRkOrderList(PageBounds pageBounds);

    int updateByPrimaryKey(RkOrder record);
}