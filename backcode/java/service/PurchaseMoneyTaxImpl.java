package com.taotaotech.backcode.java.service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.taotaotech.backcode.java.domain.PurchaseMoneytax;
import com.taotaotech.core.persistence.Page;
import com.taotaotech.core.service.CrudService;
import com.taotaotech.backcode.java.dao.PurchaseMoneytaxMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zk
 * @date 2015/10/2 14:34
 * @description
 */
@Service
public class PurchaseMoneyTaxImpl extends CrudService<PurchaseMoneytaxMapper,PurchaseMoneytax> implements IPurchaseMoneyTaxService {
    @Autowired
    private PurchaseMoneytaxMapper moneytaxMapper;
    @Override
    public Page<PurchaseMoneytax> findPurchaseMoneytaxList(Page<PurchaseMoneytax> page) {
        PageList<PurchaseMoneytax> list = (PageList)moneytaxMapper.findPurchaseMoneytaxList(page.createPageBounds());
        page.setList(list);
        return page;
    }

}
