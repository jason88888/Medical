package com.taotaotech.service.impl;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.taotaotech.core.service.CrudService;
import com.taotaotech.dao.ClientMapper;
import com.taotaotech.dao.ProviderMapper;
import com.taotaotech.domain.Client;
import com.taotaotech.domain.Provider;
import com.taotaotech.service.IClientService;
import com.taotaotech.service.IProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zk
 * @date 2015/9/4 10:06
 * @description
 */
@Service
public class ProviderServiceImpl extends CrudService<ProviderMapper,Provider> implements IProviderService{
    @Autowired
    private ProviderMapper providerMapper;


    @Override
    public List<Provider> findProviderList() {
        return providerMapper.findProviderList(new PageBounds());
    }
}
