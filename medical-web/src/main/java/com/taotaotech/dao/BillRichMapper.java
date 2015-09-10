package com.taotaotech.dao;

import com.taotaotech.dto.BillRich;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BillRichMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BillRich record);

    int insertSelective(BillRich record);

    BillRich selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BillRich record);

    int updateByPrimaryKey(BillRich record);

    List<BillRich> findBillList();

    Boolean existByBillCode(@Param("code") String code);
}