package com.taotaotech.backcode.java.service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.taotaotech.core.persistence.Page;
import com.taotaotech.core.service.CrudService;
import com.taotaotech.backcode.java.dao.PurchaseClientMapper;
import com.taotaotech.backcode.java.domain.PurchaseClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zk
 * @date 2015/10/2 14:34
 * @description
 */
@Service
public class PurchaseClientImpl extends CrudService<PurchaseClientMapper,PurchaseClient> implements IPurchaseClientService {
    @Autowired
    private PurchaseClientMapper clientMapper;
    @Override
    public Page<PurchaseClient> findPurchaseClientList(Page<PurchaseClient> page) {
        PageList<PurchaseClient> list = (PageList)clientMapper.findPurchaseClientList(page.createPageBounds());
        page.setList(list);
        return page;
    }
}
