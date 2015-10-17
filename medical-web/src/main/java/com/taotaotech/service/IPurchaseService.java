package com.taotaotech.service;

import com.taotaotech.core.dto.DWZResponseResult;
import com.taotaotech.core.service.IBaseService;
import com.taotaotech.domain.Purchasement;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author zk
 * @date 2015/10/2 14:31
 * @description
 */
public interface IPurchaseService extends IBaseService<Purchasement> {
    DWZResponseResult parsePurchaseTable(MultipartFile file);

}
