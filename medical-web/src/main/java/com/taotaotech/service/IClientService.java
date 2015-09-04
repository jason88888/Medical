package com.taotaotech.service;

import com.taotaotech.domain.Client;
import com.taotaotech.domain.Medicine;

import java.util.List;

/**
 * @author zk
 * @date 2015/9/4 10:04
 * @description
 */
public interface IClientService {
    public List<Client> findClientList();

    public int save(Client client);
}
