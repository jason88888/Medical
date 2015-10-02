package com.taotaotech.service;

import com.taotaotech.core.persistence.Page;
import com.taotaotech.domain.Bill;
import com.taotaotech.dto.Commission;

/**
 * @author zk
 * @date 2015/9/4 10:04
 * @description
 */
public interface ICommissionService {
    public Page<Commission> findCommissionList(Page page, Bill bill);

    public Commission statisticsCommission(Bill bill);
}
