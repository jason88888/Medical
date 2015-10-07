package com.taotaotech.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.taotaotech.core.persistence.CrudMapper;
import com.taotaotech.domain.Client;
import com.taotaotech.domain.PurchaseMoneytax;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseMoneytaxMapper extends CrudMapper<PurchaseMoneytax> {
    int deleteByPrimaryKey(Integer id);

    int insert(PurchaseMoneytax record);

    int insertSelective(PurchaseMoneytax record);

    PurchaseMoneytax selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PurchaseMoneytax record);

    List<PurchaseMoneytax> findPurchaseMoneytaxList(PageBounds pageBounds);

    int updateByPrimaryKey(PurchaseMoneytax record);
}