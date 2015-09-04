package com.taotaotech.service;

import com.taotaotech.domain.Agent;
import com.taotaotech.domain.Client;

import java.util.List;

/**
 * @author zk
 * @date 2015/9/4 10:04
 * @description
 */
public interface IAgentService {
    public List<Agent> findAgentList();

    public int save(Agent agent);
}
