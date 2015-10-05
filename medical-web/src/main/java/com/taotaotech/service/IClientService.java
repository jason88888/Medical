package com.taotaotech.service;

import com.taotaotech.core.persistence.Page;
import com.taotaotech.core.service.IBaseService;
import com.taotaotech.domain.Client;

import java.util.List;

/**
 * @author zk
 * @date 2015/9/4 10:04
 * @description
 */
public interface IClientService extends IBaseService<Client> {
    public List<Client> findClientList();

    public Boolean existByClientCode(String code);

}
