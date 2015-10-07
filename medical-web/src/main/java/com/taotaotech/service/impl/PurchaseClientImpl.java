package com.taotaotech.service.impl;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.taotaotech.core.persistence.Page;
import com.taotaotech.core.service.CrudService;
import com.taotaotech.dao.PurchaseClientMapper;
import com.taotaotech.domain.PurchaseClient;
import com.taotaotech.service.IPurchaseClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zk
 * @date 2015/10/2 14:34
 * @description
 */
@Service
public class PurchaseClientImpl extends CrudService<PurchaseClientMapper,PurchaseClient> implements IPurchaseClientService {
    @Autowired
    private PurchaseClientMapper clientMapper;
    @Override
    public Page<PurchaseClient> findPurchaseClientList(Page<PurchaseClient> page) {
        PageList<PurchaseClient> list = (PageList)clientMapper.findPurchaseClientList(page.createPageBounds());
        page.setList(list);
        return page;
    }
}
