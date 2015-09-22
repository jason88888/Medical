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
    public Page<Agent> findAgentList(Page<Agent> page);

    public int save(Agent agent);
}
