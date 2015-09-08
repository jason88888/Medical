package com.taotaotech.dao;

import com.taotaotech.domain.Agent;
import com.taotaotech.domain.Bill;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BillMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Bill record);

    int insertSelective(Bill record);

    Bill selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Bill record);

    int updateByPrimaryKey(Bill record);

    List<Bill> findBillList();

    Boolean existByBillCode(@Param("code") String code);
}