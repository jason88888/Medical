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
    public Page<Medicine> findMedicineList(Page<Medicine> page);

    public int save(Medicine medicine);

    public Medicine get(Integer id);

    public int delete(Integer[] ids);

}
