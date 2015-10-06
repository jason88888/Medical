package com.taotaotech.service;

import com.taotaotech.core.dto.DWZResponseResult;
import com.taotaotech.core.persistence.Page;
import com.taotaotech.core.service.IBaseService;
import com.taotaotech.domain.Policy;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author Cailin.Chen
 * @Date 15/8/28
 * @eMail cailin618@sina.com
 */

public interface IPolicyService extends IBaseService<Policy> {
    DWZResponseResult parsePolicyTable(MultipartFile file);
    boolean existByMonthAndClientAndMedicine(String clientCode,String medicineCode,String month);
}
