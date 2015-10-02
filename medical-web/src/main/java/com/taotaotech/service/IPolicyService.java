package com.taotaotech.service;

import com.taotaotech.core.dto.DWZResponseResult;
import com.taotaotech.core.persistence.Page;
import com.taotaotech.domain.MedicinePolicy;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author Cailin.Chen
 * @Date 15/8/28
 * @eMail cailin618@sina.com
 */

public interface IPolicyService {
    DWZResponseResult parsePolicyTable(MultipartFile file);

    public List<MedicinePolicy> findMedicinePolicyList();

    public Page<MedicinePolicy> findPage(Page<MedicinePolicy> page, MedicinePolicy medicinePolicy);
}
