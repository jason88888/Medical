package com.taotaotech.service.impl;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.taotaotech.core.service.CrudService;
import com.taotaotech.dao.ClientMapper;
import com.taotaotech.domain.Agent;
import com.taotaotech.domain.Client;
import com.taotaotech.service.IClientService;
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
public class ClientServiceImpl extends CrudService<ClientMapper,Client> implements IClientService{
    @Autowired
    private ClientMapper clientMapper;

    @Override
    public List<Client> findClientList() {
       return clientMapper.findClientList(new PageBounds());
    }

    @Override
    public Boolean existByClientCode(String code) {
        return clientMapper.existByClientCode(code);
    }
}
