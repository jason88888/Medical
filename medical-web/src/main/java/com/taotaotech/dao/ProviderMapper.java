package com.taotaotech.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.taotaotech.core.persistence.CrudMapper;
import com.taotaotech.domain.Agent;
import com.taotaotech.domain.AgentClient;
import com.taotaotech.domain.Provider;

import java.util.List;

public interface ProviderMapper extends CrudMapper<Provider> {
    int deleteByPrimaryKey(Integer id);

    int insert(Provider record);

    int insertSelective(Provider record);

    Provider selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Provider record);

    List<Provider> findProviderList(PageBounds pageBounds);

    int updateByPrimaryKey(Provider record);
}