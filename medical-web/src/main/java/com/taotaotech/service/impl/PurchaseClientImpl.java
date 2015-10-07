package com.taotaotech.service.impl;

import com.taotaotech.core.persistence.Page;
import com.taotaotech.core.service.CrudService;
import com.taotaotech.dao.PurchaseClientMapper;
import com.taotaotech.domain.PurchaseClient;
import com.taotaotech.domain.PurchaseMoneytax;
import com.taotaotech.domain.Purchasement;
import com.taotaotech.service.IPurchaseClientService;
import com.taotaotech.service.IPurchaseService;
import org.springframework.stereotype.Service;

/**
 * @author zk
 * @date 2015/10/2 14:34
 * @description
 */
@Service
public class PurchaseClientImpl extends CrudService<PurchaseClientMapper,PurchaseClient> implements IPurchaseClientService {
    @Override
    public Page<PurchaseClient> findPurchaseClientList(Page<PurchaseClient> page) {
        return null;
    }
}
