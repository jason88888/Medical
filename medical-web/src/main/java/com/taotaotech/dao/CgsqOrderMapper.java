package com.taotaotech.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.taotaotech.core.persistence.CrudMapper;
import com.taotaotech.domain.CgsqOrder;

import java.util.List;

public interface CgsqOrderMapper extends CrudMapper<CgsqOrder> {
    int deleteByPrimaryKey(Integer id);

    int insert(CgsqOrder record);

    int insertSelective(CgsqOrder record);

    CgsqOrder selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CgsqOrder record);

    List<CgsqOrder> findCgsqOrderList(PageBounds pageBounds);

    int updateByPrimaryKey(CgsqOrder record);
}