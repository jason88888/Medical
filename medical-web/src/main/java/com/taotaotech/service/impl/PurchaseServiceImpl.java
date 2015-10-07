package com.taotaotech.service.impl;

import com.taotaotech.core.persistence.Page;
import com.taotaotech.core.service.CrudService;
import com.taotaotech.dao.PurchaseClientMapper;
import com.taotaotech.dao.PurchaseMoneytaxMapper;
import com.taotaotech.dao.PurchasementMapper;
import com.taotaotech.domain.PurchaseMoneytax;
import com.taotaotech.domain.Purchasement;
import com.taotaotech.service.IBillService;
import com.taotaotech.service.IPurchaseService;
import org.springframework.stereotype.Service;

/**
 * @author zk
 * @date 2015/10/2 14:34
 * @description
 */
@Service
public class PurchaseServiceImpl extends CrudService<PurchasementMapper,Purchasement> implements IPurchaseService {
    @Override
    public Page<Purchasement> findPurchasementList(Page<Purchasement> page) {
        return null;
    }

}
