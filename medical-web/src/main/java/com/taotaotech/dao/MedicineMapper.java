package com.taotaotech.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.taotaotech.core.persistence.CrudMapper;
import com.taotaotech.domain.Medicine;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicineMapper  extends CrudMapper<Medicine> {
    int deleteByPrimaryKey(Integer id);

    int delete(List<Integer> ids);

    int insert(Medicine record);

    int insertSelective(Medicine record);

    Medicine selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Medicine record);

    int updateByPrimaryKey(Medicine record);

    List<Medicine> findMedicineList(PageBounds pageBounds);

    Boolean existByMedicineCodeAndLotNumber(@Param("code")String code,@Param("lotNumber")String lotNumber);
}