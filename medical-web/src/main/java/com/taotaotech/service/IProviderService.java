package com.taotaotech.service;

import com.taotaotech.core.service.IBaseService;
import com.taotaotech.domain.Client;
import com.taotaotech.domain.Provider;

import java.util.List;

/**
 * @author zk
 * @date 2015/9/4 10:04
 * @description
 */
public interface IProviderService extends IBaseService<Provider> {
    public List<Provider> findProviderList();

}
