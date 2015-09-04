package com.taotaotech.dao;

import com.taotaotech.domain.Medicine;
import com.taotaotech.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MedicineMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Medicine record);

    int insertSelective(Medicine record);

    Medicine selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Medicine record);

    int updateByPrimaryKey(Medicine record);

    List<Medicine> findMedicineList();

    Boolean existByMedicineCodeAndLotNumber(@Param("code")String code,@Param("lotNumber")String lotNumber);
}