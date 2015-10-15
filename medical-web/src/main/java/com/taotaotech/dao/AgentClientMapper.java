package com.taotaotech.dao;

import com.taotaotech.core.persistence.CrudMapper;
import com.taotaotech.domain.Agent;
import com.taotaotech.domain.AgentClient;

public interface AgentClientMapper extends CrudMapper<AgentClient> {
    int deleteByPrimaryKey(Integer id);

    int insert(AgentClient record);

    int insertSelective(AgentClient record);

    AgentClient selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AgentClient record);

    int updateByPrimaryKey(AgentClient record);
}