package com.taotaotech.service;

import com.taotaotech.core.persistence.Page;
import com.taotaotech.core.service.IBaseService;
import com.taotaotech.domain.CommercialCompany;

/**
 * @author zk
 * @date 2015/9/4 10:04
 * @description
 */
public interface ICommercialCompanyService extends IBaseService<CommercialCompany> {
    public Page<CommercialCompany> findAgentClientList(Page<CommercialCompany> page);

    public Boolean existByAgentClientCode(String code);
}
