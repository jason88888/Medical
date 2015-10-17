package com.taotaotech.service.impl;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.taotaotech.core.persistence.Page;
import com.taotaotech.core.service.CrudService;
import com.taotaotech.dao.AgentClientMapper;
import com.taotaotech.domain.AgentClient;
import com.taotaotech.service.IAgentClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zk
 * @date 2015/9/4 10:06
 * @description
 */
@Service
public class AgentClientServiceImpl extends CrudService<AgentClientMapper, AgentClient> implements IAgentClientService {
    @Autowired
    private AgentClientMapper agentClientMapper;

    @Override
    public Page<AgentClient> findAgentClientList(Page<AgentClient> page) {
        PageList<AgentClient> list = (PageList)agentClientMapper.findAgentClientList(page.createPageBounds());
        page.setList(list);
        return page;
    }

    public Boolean existByAgentClientCode(String code){
        return agentClientMapper.existByAgentClientCode(code);
    }

}
