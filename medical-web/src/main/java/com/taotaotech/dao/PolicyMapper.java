package com.taotaotech.dao;

import com.taotaotech.core.persistence.CrudMapper;
import com.taotaotech.domain.Policy;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PolicyMapper extends CrudMapper<Policy> {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(Policy record);

    Policy selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Policy record);

    int updateByPrimaryKey(Policy record);

    Boolean existByMonthAndClientAndMedicine(@Param("clientCode")String clientCode,
                                             @Param("medicineCode")String medicineCode,
                                             @Param("month")String month);

    Policy getPolicyByMonthAndClientAndMedicine(@Param("clientCode")String clientCode,
                                         @Param("medicineCode")String medicineCode,
                                         @Param("month")String month);
}