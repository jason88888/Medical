package com.taotaotech.service.impl;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.taotaotech.core.persistence.Page;
import com.taotaotech.core.service.CrudService;
import com.taotaotech.dao.CommercialCompanyMapper;
import com.taotaotech.domain.CommercialCompany;
import com.taotaotech.service.ICommercialCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zk
 * @date 2015/9/4 10:06
 * @description
 */
@Service
public class CommercialCompanyServiceImpl extends CrudService<CommercialCompanyMapper, CommercialCompany> implements ICommercialCompanyService {
    @Autowired
    private CommercialCompanyMapper commercialCompanyMapper;

    @Override
    public Page<CommercialCompany> findAgentClientList(Page<CommercialCompany> page) {
        PageList<CommercialCompany> list = (PageList) commercialCompanyMapper.findAgentClientList(page.createPageBounds());
        page.setList(list);
        return page;
    }

    public Boolean existByAgentClientCode(String code){
        return commercialCompanyMapper.existByAgentClientCode(code);
    }

}
