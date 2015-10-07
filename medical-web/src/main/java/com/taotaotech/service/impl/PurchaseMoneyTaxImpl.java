package com.taotaotech.service.impl;

import com.taotaotech.core.persistence.Page;
import com.taotaotech.core.service.CrudService;
import com.taotaotech.dao.MedicineMapper;
import com.taotaotech.dao.PurchaseMoneytaxMapper;
import com.taotaotech.domain.Medicine;
import com.taotaotech.domain.PurchaseClient;
import com.taotaotech.domain.PurchaseMoneytax;
import com.taotaotech.domain.Purchasement;
import com.taotaotech.service.IPurchaseClientService;
import com.taotaotech.service.IPurchaseMoneyTaxService;
import org.springframework.stereotype.Service;

/**
 * @author zk
 * @date 2015/10/2 14:34
 * @description
 */
@Service
public class PurchaseMoneyTaxImpl extends CrudService<PurchaseMoneytaxMapper,PurchaseMoneytax> implements IPurchaseMoneyTaxService {
    @Override
    public Page<PurchaseMoneytax> findPurchaseMoneytaxList(Page<PurchaseMoneytax> page) {
        return null;
    }

}
