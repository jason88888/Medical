package com.taotaotech.dao;

import com.taotaotech.domain.Agent;
import com.taotaotech.domain.Client;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AgentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Agent record);

    int insertSelective(Agent record);

    Agent selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Agent record);

    int updateByPrimaryKey(Agent record);

    List<Agent> findAgentList();

    Boolean existByAgentCode(@Param("code")String code);
}