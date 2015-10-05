package com.taotaotech.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.taotaotech.core.persistence.CrudMapper;
import com.taotaotech.domain.Agent;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgentMapper extends CrudMapper<Agent>{
    int deleteByPrimaryKey(Integer id);

    int delete(List<Integer> ids);

    int insert(Agent record);

    int insertSelective(Agent record);

    Agent selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Agent record);

    int updateByPrimaryKey(Agent record);

    List<Agent> findAgentList(PageBounds pageBounds);

    Boolean existByAgentCode(@Param("code")String code);
}