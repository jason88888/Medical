package com.taotaotech.backcode.java.service;

import com.taotaotech.backcode.java.domain.PurchaseMoneytax;
import com.taotaotech.core.persistence.Page;
import com.taotaotech.core.service.IBaseService;

/**
 * @author zk
 * @date 2015/10/2 14:31
 * @description
 */
public interface IPurchaseMoneyTaxService  extends IBaseService<PurchaseMoneytax> {
    public Page<PurchaseMoneytax> findPurchaseMoneytaxList(Page<PurchaseMoneytax> page);

}
