package com.taotaotech.service;

import com.taotaotech.core.persistence.Page;
import com.taotaotech.domain.Medicine;

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
