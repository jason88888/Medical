package com.taotaotech.service.impl;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.taotaotech.core.service.CrudService;
import com.taotaotech.dao.AgentMapper;
import com.taotaotech.domain.Agent;
import com.taotaotech.service.IAgentService;
import com.taotaotech.core.persistence.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zk
 * @date 2015/9/4 10:06
 * @description
 */
@Service
public class AgentServiceImpl extends CrudService<AgentMapper, Agent> implements IAgentService {
    @Autowired
    private AgentMapper agentMapper;

    @Override
    public Page<Agent> findAgentList(Page<Agent> page) {
        PageList<Agent> list = (PageList)agentMapper.findAgentList(page.createPageBounds());
        page.setList(list);
        return page;
    }

    public Boolean existByAgentCode(String code){
        return agentMapper.existByAgentCode(code);
    }

}
