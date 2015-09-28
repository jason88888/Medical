package com.taotaotech.service.impl;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.taotaotech.dao.MedicineMapper;
import com.taotaotech.dao.UserMapper;
import com.taotaotech.domain.Medicine;
import com.taotaotech.domain.User;
import com.taotaotech.service.IMedicineService;
import com.taotaotech.service.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zk
 * @date 2015/9/4 10:06
 * @description
 */
@Service
public class MedicineServiceImpl implements IMedicineService {
    @Autowired
    private MedicineMapper medicineMapper;

    @Override
    public Page<Medicine> findMedicineList(Page<Medicine> page) {
        PageList<Medicine> list = (PageList) medicineMapper.findMedicineList(page.createPageBounds());
        page.setList(list);
        return page;
    }

    @Override
    public Medicine get(Integer id) {
        return medicineMapper.selectByPrimaryKey(id);
    }

    @Override
    public int delete(Integer[] ids) {
        List<Integer> list = new ArrayList<Integer>();
        for (Integer id : ids) {
            list.add(id);
        }
        return medicineMapper.delete(list);
    }

    @Override
    public int save(Medicine medicine) {
        int result = 0;
        if (medicine.getId() != null && medicine.getId() != 0) {
            result = medicineMapper.updateByPrimaryKey(medicine);
        } else {
            medicineMapper.insert(medicine);
        }
        return result;
    }
}
