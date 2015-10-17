package com.taotaotech.backcode.java.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.taotaotech.core.persistence.CrudMapper;
import com.taotaotech.backcode.java.domain.PurchaseClient;
import com.taotaotech.backcode.java.domain.PurchaseMoneytax;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseClientMapper extends CrudMapper<PurchaseClient> {
    int deleteByPrimaryKey(Integer id);

    int insert(PurchaseClient record);

    int insertSelective(PurchaseClient record);

    PurchaseClient selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PurchaseClient record);

    List<PurchaseMoneytax> findPurchaseClientList(PageBounds pageBounds);

    int updateByPrimaryKey(PurchaseClient record);
}