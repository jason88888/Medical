package com.taotaotech.service.impl;

import com.taotaotech.core.persistence.Page;
import com.taotaotech.domain.PurchaseClient;
import com.taotaotech.domain.PurchaseMoneytax;
import com.taotaotech.domain.Purchasement;
import com.taotaotech.service.IPurchaseClientService;
import com.taotaotech.service.IPurchaseMoneyTaxService;
import org.springframework.stereotype.Service;

/**
 * @author zk
 * @date 2015/10/2 14:34
 * @description
 */
@Service
public class PurchaseMoneyTaxImpl implements IPurchaseMoneyTaxService {
    @Override
    public Page<PurchaseMoneytax> findPurchaseMoneytaxList(Page<PurchaseMoneytax> page) {
        return null;
    }

    @Override
    public int save(PurchaseMoneytax purchaseMoneytax) {
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
