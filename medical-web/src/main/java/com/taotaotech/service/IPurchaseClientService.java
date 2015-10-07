package com.taotaotech.service;

import com.taotaotech.core.persistence.Page;
import com.taotaotech.domain.PurchaseClient;
import com.taotaotech.domain.Purchasement;

/**
 * @author zk
 * @date 2015/10/2 14:31
 * @description
 */
public interface IPurchaseClientService {
    public Page<Purchasement> findPurchaseClientList(Page<PurchaseClient> page);

    public int save(PurchaseClient purchaseClient);

    public PurchaseClient get(Integer id);

    public int delete(Integer[] ids);
}
