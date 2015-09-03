package com.taotaotech.service;

import com.taotaotech.core.dto.DWZResponseResult;
import com.taotaotech.core.dto.ResponseResult;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Cailin.Chen
 * @Date 15/8/30
 * @eMail cailin618@sina.com
 */

public interface IBillService {
    ResponseResult parseBillTable(MultipartFile file);
    DWZResponseResult parseBillTable2(MultipartFile file);
}
