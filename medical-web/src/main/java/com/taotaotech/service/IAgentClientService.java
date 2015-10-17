package com.taotaotech.service;

import com.taotaotech.core.persistence.Page;
import com.taotaotech.core.service.IBaseService;
import com.taotaotech.domain.AgentClient;

/**
 * @author zk
 * @date 2015/9/4 10:04
 * @description
 */
public interface IAgentClientService extends IBaseService<AgentClient> {
    public Page<AgentClient> findAgentClientList(Page<AgentClient> page);

    public Boolean existByAgentClientCode(String code);
}
