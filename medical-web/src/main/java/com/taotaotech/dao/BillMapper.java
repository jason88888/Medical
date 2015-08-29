package com.taotaotech.dao;

import com.taotaotech.domain.Bill;
import org.apache.ibatis.annotations.Param;

public interface BillMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Bill record);

    int insertSelective(Bill record);

    Bill selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Bill record);

    int updateByPrimaryKey(Bill record);

    Boolean existByBillCode(@Param("code") String code);
}