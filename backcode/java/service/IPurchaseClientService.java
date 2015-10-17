package com.taotaotech.backcode.java.service;

import com.taotaotech.backcode.java.domain.PurchaseClient;
import com.taotaotech.core.persistence.Page;
import com.taotaotech.core.service.IBaseService;

/**
 * @author zk
 * @date 2015/10/2 14:31
 * @description
 */
public interface IPurchaseClientService  extends IBaseService<PurchaseClient> {
    public Page<PurchaseClient> findPurchaseClientList(Page<PurchaseClient> page);
}
