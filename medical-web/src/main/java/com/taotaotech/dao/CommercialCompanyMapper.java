package com.taotaotech.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.taotaotech.core.persistence.CrudMapper;
import com.taotaotech.domain.CommercialCompany;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommercialCompanyMapper extends CrudMapper<CommercialCompany> {
    int deleteByPrimaryKey(Integer id);

    int insert(CommercialCompany record);

    int insertSelective(CommercialCompany record);

    CommercialCompany selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CommercialCompany record);

    List<CommercialCompany> findAgentClientList(PageBounds pageBounds);

    int updateByPrimaryKey(CommercialCompany record);

    Boolean existByAgentClientCode(@Param("code")String code);
}