package com.taotaotech.service.impl;

import com.taotaotech.dao.MedicineMapper;
import com.taotaotech.dao.UserMapper;
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
public class MedicineServiceImpl implements IMedicineService{
    @Autowired
    private MedicineMapper medicineMapper;

    @Override
    public List<Medicine> findMedicineList() {
        return medicineMapper.findMedicineList();
    }

    @Override
    public int save(Medicine medicine) {
        return medicineMapper.insert(medicine);
    }
}