package com.taotaotech.dao;

import com.taotaotech.domain.Agent;
import org.apache.ibatis.annotations.Param;

public interface AgentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Agent record);

    int insertSelective(Agent record);

    Agent selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Agent record);

    int updateByPrimaryKey(Agent record);

    Boolean existByAgentCode(@Param("code")String code);
}