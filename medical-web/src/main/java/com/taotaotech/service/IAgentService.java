package com.taotaotech.service;

import com.taotaotech.core.persistence.Page;
import com.taotaotech.domain.Agent;

/**
 * @author zk
 * @date 2015/9/4 10:04
 * @description
 */
public interface IAgentService {
    public Page<Agent> findAgentList(Page<Agent> page);

    public int save(Agent agent);

    public Agent get(Integer id);

    public int delete(Integer[] ids);
}
