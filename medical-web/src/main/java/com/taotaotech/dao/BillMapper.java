package com.taotaotech.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.taotaotech.core.persistence.CrudMapper;
import com.taotaotech.domain.Bill;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface BillMapper extends CrudMapper<Bill> {
    int deleteByPrimaryKey(Integer id);

    int insert(Bill record);

    int insertSelective(Bill record);

    int updateByPrimaryKeySelective(Bill record);

    int updateByPrimaryKey(Bill record);

    List<Bill> findList(Map bill, PageBounds pageBounds);

    Boolean existByBillCode(@Param("code") String code);

    Boolean isNotCurrentMonthData(List<Integer> ids);
}