package com.taotaotech.service;

import com.taotaotech.core.persistence.Page;
import com.taotaotech.core.service.IBaseService;
import com.taotaotech.domain.Agent;

/**
 * @author zk
 * @date 2015/9/4 10:04
 * @description
 */
public interface IAgentService extends IBaseService<Agent> {
    public Page<Agent> findAgentList(Page<Agent> page);

    public Boolean existByAgentCode(String code);
}
