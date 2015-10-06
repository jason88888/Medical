package com.taotaotech.service.impl;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.taotaotech.core.service.CrudService;
import com.taotaotech.dao.MedicineMapper;
import com.taotaotech.domain.Medicine;
import com.taotaotech.service.IMedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zk
 * @date 2015/9/4 10:06
 * @description
 */
@Service
public class MedicineServiceImpl  extends CrudService<MedicineMapper,Medicine> implements IMedicineService {
    @Autowired
    private MedicineMapper medicineMapper;

    @Override
    public List<Medicine> findMedicineList() {
        return medicineMapper.findMedicineList(new PageBounds());
    }

    @Override
    public Boolean existByMedicineCodeAndLotNumber(String code, String lotNumber) {
        return medicineMapper.existByMedicineCodeAndLotNumber(code,lotNumber);
    }
}
