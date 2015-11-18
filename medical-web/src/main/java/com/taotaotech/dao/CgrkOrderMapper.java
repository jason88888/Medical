package com.taotaotech.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.taotaotech.core.persistence.CrudMapper;
import com.taotaotech.domain.CgrkOrder;

import java.util.List;

public interface CgrkOrderMapper extends CrudMapper<CgrkOrder> {
    int deleteByPrimaryKey(Integer id);

    int insert(CgrkOrder record);

    int insertSelective(CgrkOrder record);

    CgrkOrder selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CgrkOrder record);

    List<CgrkOrder> findRkOrderList(PageBounds pageBounds);

    int updateByPrimaryKey(CgrkOrder record);
}