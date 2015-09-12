package com.taotaotech.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.taotaotech.dto.BillRich;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BillRichMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BillRich record);

    int insertSelective(BillRich record);

    BillRich selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BillRich record);

    int updateByPrimaryKey(BillRich record);

    List<BillRich> findBillList(Map map,PageBounds pageBounds);

    Boolean existByBillCode(@Param("code") String code);
}