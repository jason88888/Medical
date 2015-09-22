package com.taotaotech.service.impl;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.taotaotech.dao.ClientMapper;
import com.taotaotech.dao.MedicineMapper;
import com.taotaotech.domain.Client;
import com.taotaotech.domain.Medicine;
import com.taotaotech.service.IClientService;
import com.taotaotech.service.IMedicineService;
import com.taotaotech.service.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public int save(Client client) {
        return clientMapper.insert(client);
    }
}
