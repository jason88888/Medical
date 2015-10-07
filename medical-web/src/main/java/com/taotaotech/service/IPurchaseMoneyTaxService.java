package com.taotaotech.service;

import com.taotaotech.core.persistence.Page;
import com.taotaotech.core.service.IBaseService;
import com.taotaotech.domain.Policy;
import com.taotaotech.domain.PurchaseClient;
import com.taotaotech.domain.PurchaseMoneytax;
import com.taotaotech.domain.Purchasement;

/**
 * @author zk
 * @date 2015/10/2 14:31
 * @description
 */
public interface IPurchaseMoneyTaxService  extends IBaseService<PurchaseMoneytax> {
    public Page<PurchaseMoneytax> findPurchaseMoneytaxList(Page<PurchaseMoneytax> page);

}
