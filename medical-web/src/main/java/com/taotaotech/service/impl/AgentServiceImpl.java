package com.taotaotech.service.impl;

import com.taotaotech.dao.AgentMapper;
import com.taotaotech.dao.ClientMapper;
import com.taotaotech.domain.Agent;
import com.taotaotech.domain.Client;
import com.taotaotech.service.IAgentService;
import com.taotaotech.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zk
 * @date 2015/9/4 10:06
 * @description
 */
@Service
public class AgentServiceImpl implements IAgentService{
    @Autowired
    private AgentMapper agentMapper;


    @Override
    public List<Agent> findAgentList() {
        return agentMapper.findAgentList();
    }

    @Override
    public int save(Agent agent) {
        return agentMapper.insert(agent);
    }
}