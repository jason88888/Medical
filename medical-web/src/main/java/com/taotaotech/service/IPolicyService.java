package com.taotaotech.service;

import com.taotaotech.core.dto.DWZResponseResult;
import com.taotaotech.core.dto.ResponseResult;
import com.taotaotech.domain.Client;
import com.taotaotech.domain.MedicinePolicy;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author Cailin.Chen
 * @Date 15/8/28
 * @eMail cailin618@sina.com
 */

public interface IPolicyService {
    ResponseResult parsePolicyTable(MultipartFile file);
    DWZResponseResult parsePolicyTable2(MultipartFile file);
    public List<MedicinePolicy> findMedicinePolicyList();
}
