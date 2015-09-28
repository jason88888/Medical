package com.taotaotech.service.impl;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.taotaotech.dao.AgentMapper;
import com.taotaotech.dao.ClientMapper;
import com.taotaotech.domain.Agent;
import com.taotaotech.domain.Client;
import com.taotaotech.service.IAgentService;
import com.taotaotech.service.IClientService;
import com.taotaotech.service.Page;
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
public class AgentServiceImpl implements IAgentService{
    @Autowired
    private AgentMapper agentMapper;


    @Override
    public Page<Agent> findAgentList(Page<Agent> page) {
        PageList<Agent> list = (PageList)agentMapper.findAgentList(page.createPageBounds());
        page.setList(list);
        return page;
    }

    @Override
    public int save(Agent agent) {
        int result = 0;
        if (agent.getId() != null && agent.getId() != 0) {
            result = agentMapper.updateByPrimaryKey(agent);
        } else {
            agentMapper.insert(agent);
        }
        return result;
    }

    @Override
    public Agent get(Integer id) {
        return agentMapper.selectByPrimaryKey(id);
    }

    @Override
    public int delete(Integer[] ids) {
        List<Integer> list = new ArrayList<Integer>();
        for (Integer id : ids) {
            list.add(id);
        }
        return agentMapper.delete(list);
    }
}
