package com.taotaotech.service;

import com.taotaotech.domain.Medicine;
import com.taotaotech.domain.User;

import java.util.List;

/**
 * @author zk
 * @date 2015/9/4 10:04
 * @description
 */
public interface IMedicineService {
    public List<Medicine> findMedicineList();

    public int save(Medicine medicine);
}
