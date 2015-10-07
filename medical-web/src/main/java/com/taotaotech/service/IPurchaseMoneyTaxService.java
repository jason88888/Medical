package com.taotaotech.service;

import com.taotaotech.core.persistence.Page;
import com.taotaotech.domain.PurchaseClient;
import com.taotaotech.domain.PurchaseMoneytax;
import com.taotaotech.domain.Purchasement;

/**
 * @author zk
 * @date 2015/10/2 14:31
 * @description
 */
public interface IPurchaseMoneyTaxService {
    public Page<PurchaseMoneytax> findPurchaseMoneytaxList(Page<PurchaseMoneytax> page);

    public int save(PurchaseMoneytax purchaseMoneytax);

    public PurchaseClient get(Integer id);

    public int delete(Integer[] ids);
}
