package com.taotaotech.dao;

import com.taotaotech.core.persistence.CrudMapper;
import com.taotaotech.domain.Provider;
import com.taotaotech.domain.RkOrder;

public interface RkOrderMapper extends CrudMapper<RkOrder> {
    int deleteByPrimaryKey(Integer id);

    int insert(RkOrder record);

    int insertSelective(RkOrder record);

    RkOrder selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RkOrder record);

    int updateByPrimaryKey(RkOrder record);
}