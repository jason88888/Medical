package com.taotaotech.service.impl;

import com.taotaotech.dao.ClientMapper;
import com.taotaotech.dao.MedicineMapper;
import com.taotaotech.domain.Client;
import com.taotaotech.domain.Medicine;
import com.taotaotech.service.IClientService;
import com.taotaotech.service.IMedicineService;
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
    public List<Client> findClientList() {
        return clientMapper.findClientList();
    }

    @Override
    public int save(Client client) {
        return clientMapper.insert(client);
    }
}
