package com.taotaotech.service;

import com.taotaotech.core.dto.DWZResponseResult;
import com.taotaotech.core.dto.ResponseResult;
import com.taotaotech.domain.Client;
import com.taotaotech.dto.BillRich;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author Cailin.Chen
 * @Date 15/8/30
 * @eMail cailin618@sina.com
 */

public interface IBillService {
    DWZResponseResult parseBillTable(MultipartFile file);
    public List<BillRich> findBillList();
}
