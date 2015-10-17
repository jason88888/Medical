package com.taotaotech.service.impl;

import com.taotaotech.core.service.CrudService;
import com.taotaotech.dao.AgentClientMapper;
import com.taotaotech.domain.AgentClient;
import com.taotaotech.service.IAgentClientService;
import org.springframework.stereotype.Service;

/**
 * @author Cailin.Chen
 * @Date 15/10/16
 * @eMail cailin618@sina.com
 */
@Service
public class AgentClientService extends CrudService<AgentClientMapper,AgentClient> implements IAgentClientService {
}
