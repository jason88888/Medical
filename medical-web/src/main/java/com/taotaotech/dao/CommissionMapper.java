package com.taotaotech.dao;

import com.taotaotech.domain.Agent;
import com.taotaotech.dto.Commission;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 这个好像用不到
 */
@Repository
public interface CommissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Commission commission);

    int insertSelective(Commission commission);

    Agent selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Commission commission);

    int updateByPrimaryKey(Commission commission);

    List<Commission> findCommissionList();

    Boolean existByCommissionCode(@Param("code") String code);
}