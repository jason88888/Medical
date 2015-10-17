package com.taotaotech.service;

import com.taotaotech.core.persistence.Page;
import com.taotaotech.core.service.IBaseService;
import com.taotaotech.domain.Medicine;

import java.util.List;

/**
 * @author zk
 * @date 2015/9/4 10:04
 * @description
 */
public interface IMedicineService extends IBaseService<Medicine> {
    public List<Medicine> findMedicineList();

    public Boolean existByMedicineCodeAndLotNumber(String code, String lotNumber);

    public Medicine getMedicineByMedicineCodeAndLotNumber(String code, String lotNumber);

}
