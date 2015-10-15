package com.taotaotech.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.taotaotech.core.persistence.CrudMapper;
import com.taotaotech.domain.Agent;
import com.taotaotech.domain.AgentClient;
import com.taotaotech.domain.RkOrder;

import java.util.List;

public interface AgentClientMapper extends CrudMapper<AgentClient> {
    int deleteByPrimaryKey(Integer id);

    int insert(AgentClient record);

    int insertSelective(AgentClient record);

    AgentClient selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AgentClient record);

    List<AgentClient> findAgentClientList(PageBounds pageBounds);

    int updateByPrimaryKey(AgentClient record);
}