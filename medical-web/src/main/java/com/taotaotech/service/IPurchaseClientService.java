package com.taotaotech.service;

import com.taotaotech.core.persistence.Page;
import com.taotaotech.core.service.IBaseService;
import com.taotaotech.domain.PurchaseClient;
import com.taotaotech.domain.PurchaseMoneytax;
import com.taotaotech.domain.Purchasement;

/**
 * @author zk
 * @date 2015/10/2 14:31
 * @description
 */
public interface IPurchaseClientService  extends IBaseService<PurchaseClient> {
    public Page<PurchaseClient> findPurchaseClientList(Page<PurchaseClient> page);
}
