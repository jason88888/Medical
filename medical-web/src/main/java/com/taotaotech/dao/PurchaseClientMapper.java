package com.taotaotech.dao;

import com.taotaotech.domain.PurchaseClient;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseClientMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PurchaseClient record);

    int insertSelective(PurchaseClient record);

    PurchaseClient selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PurchaseClient record);

    int updateByPrimaryKey(PurchaseClient record);
}