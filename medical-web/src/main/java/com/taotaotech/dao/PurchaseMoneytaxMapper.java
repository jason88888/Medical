package com.taotaotech.dao;

import com.taotaotech.core.persistence.CrudMapper;
import com.taotaotech.domain.PurchaseMoneytax;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseMoneytaxMapper extends CrudMapper<PurchaseMoneytax> {
    int deleteByPrimaryKey(Integer id);

    int insert(PurchaseMoneytax record);

    int insertSelective(PurchaseMoneytax record);

    PurchaseMoneytax selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PurchaseMoneytax record);

    int updateByPrimaryKey(PurchaseMoneytax record);
}