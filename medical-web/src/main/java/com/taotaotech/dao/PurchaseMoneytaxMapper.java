package com.taotaotech.dao;

import com.taotaotech.domain.PurchaseMoneytax2;

public interface PurchaseMoneytaxMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PurchaseMoneytax2 record);

    int insertSelective(PurchaseMoneytax2 record);

    PurchaseMoneytax2 selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PurchaseMoneytax2 record);

    int updateByPrimaryKey(PurchaseMoneytax2 record);
}