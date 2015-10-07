package com.taotaotech.service;

import com.taotaotech.core.persistence.Page;
import com.taotaotech.core.service.IBaseService;
import com.taotaotech.domain.Medicine;
import com.taotaotech.domain.PurchaseMoneytax;
import com.taotaotech.domain.Purchasement;

/**
 * @author zk
 * @date 2015/10/2 14:31
 * @description
 */
public interface IPurchaseService extends IBaseService<Purchasement> {
    public Page<Purchasement> findPurchasementList(Page<Purchasement> page);

}
