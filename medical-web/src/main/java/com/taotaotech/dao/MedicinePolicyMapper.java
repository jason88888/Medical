package com.taotaotech.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.taotaotech.domain.Client;
import com.taotaotech.domain.MedicinePolicy;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface MedicinePolicyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MedicinePolicy record);

    int insertSelective(MedicinePolicy record);

    MedicinePolicy selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MedicinePolicy record);

    int updateByPrimaryKey(MedicinePolicy record);

    List<MedicinePolicy> findMedicinePolicyList();

    Boolean existByMonthAndClientAndMedicine(@Param("clientCode")String clientCode,
                                             @Param("medicineCode")String medicineCode,
                                             @Param("month")String month);

    MedicinePolicy getPolicyByMonthAndClientAndMedicine(@Param("clientCode")String clientCode,
                                         @Param("medicineCode")String medicineCode,
                                         @Param("month")String month);


    List<MedicinePolicy> findList(Map map, PageBounds pageBounds);
}