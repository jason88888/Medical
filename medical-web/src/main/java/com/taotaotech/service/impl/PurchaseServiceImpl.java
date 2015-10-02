package com.taotaotech.service.impl;

import com.taotaotech.domain.Purchasement;
import com.taotaotech.service.IBillService;
import com.taotaotech.service.IPurchaseService;
import com.taotaotech.service.Page;
import org.springframework.stereotype.Service;

/**
 * @author zk
 * @date 2015/10/2 14:34
 * @description
 */
@Service
public class PurchaseServiceImpl implements IPurchaseService {
    @Override
    public Page<Purchasement> findPurchasementList(Page<Purchasement> page) {
        return null;
    }

    @Override
    public int save(Purchasement purchasement) {
        return 0;
    }

    @Override
    public Purchasement get(Integer id) {
        return null;
    }

    @Override
    public int delete(Integer[] ids) {
        return 0;
    }
}
