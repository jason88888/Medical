package com.taotaotech.service;

import com.taotaotech.core.dto.DWZResponseResult;
import com.taotaotech.core.persistence.Page;
import com.taotaotech.domain.Bill;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * @author Cailin.Chen
 * @Date 15/8/30
 * @eMail cailin618@sina.com
 */

public interface IBillService {
    DWZResponseResult parseBillTable(MultipartFile file);

    public Page<Bill> findBillList(Page<Bill> page, Map map);

    public Page<Bill> findPage(Page<Bill> page, Bill bill);
}
