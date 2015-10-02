package com.taotaotech.service;

import com.taotaotech.domain.Medicine;
import com.taotaotech.domain.Purchasement;
import com.taotaotech.service.Page;

/**
 * @author zk
 * @date 2015/10/2 14:31
 * @description
 */
public interface IPurchaseService {
    public Page<Purchasement> findPurchasementList(Page<Purchasement> page);

    public int save(Purchasement purchasement);

    public Purchasement get(Integer id);

    public int delete(Integer[] ids);
}
