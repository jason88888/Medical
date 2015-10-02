package com.taotaotech.service;

import com.taotaotech.core.persistence.Page;
import com.taotaotech.domain.Client;

/**
 * @author zk
 * @date 2015/9/4 10:04
 * @description
 */
public interface IClientService {
    public Page<Client> findClientList(Page<Client> page);

    public int save(Client client);

    public Client get(Integer id);

    public int delete(Integer[] ids);
}
