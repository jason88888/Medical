package com.taotaotech.service.impl;

import com.taotaotech.core.persistence.Page;
import com.taotaotech.domain.PurchaseClient;
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
public class PurchaseClientImpl implements IPurchaseClientService {
    @Override
    public Page<Purchasement> findPurchaseClientList(Page<PurchaseClient> page) {
        return null;
    }

    @Override
    public int save(PurchaseClient purchaseClient) {
        return 0;
    }

    @Override
    public PurchaseClient get(Integer id) {
        return null;
    }

    @Override
    public int delete(Integer[] ids) {
        return 0;
    }
}
