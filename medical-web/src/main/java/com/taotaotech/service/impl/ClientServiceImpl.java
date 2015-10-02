package com.taotaotech.service.impl;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.taotaotech.dao.ClientMapper;
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
public class ClientServiceImpl implements IClientService{
    @Autowired
    private ClientMapper clientMapper;

    @Override
    public Page<Client> findClientList(Page<Client> page) {
        PageList<Client> list =  (PageList)clientMapper.findClientList(page.createPageBounds());
        page.setList(list);
        return page;
    }

    @Override
    public Client get(Integer id) {
        return clientMapper.selectByPrimaryKey(id);
    }

    @Override
    public int delete(Integer[] ids) {
        List<Integer> list = new ArrayList<Integer>();
        for (Integer id : ids) {
            list.add(id);
        }
        return clientMapper.delete(list);
    }

    @Override
    public int save(Client client) {
        int result = 0;
        if (client.getId() != null && client.getId() != 0) {
            result = clientMapper.updateByPrimaryKey(client);
        } else {
            clientMapper.insert(client);
        }
        return result;
    }
}
