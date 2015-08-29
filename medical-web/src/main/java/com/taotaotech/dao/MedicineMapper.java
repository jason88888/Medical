package com.taotaotech.dao;

import com.taotaotech.domain.Medicine;
import org.apache.ibatis.annotations.Param;

public interface MedicineMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Medicine record);

    int insertSelective(Medicine record);

    Medicine selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Medicine record);

    int updateByPrimaryKey(Medicine record);

    Boolean existByMedicineCodeAndLotNumber(@Param("code")String code,@Param("lotNumber")String lotNumber);
}