package com.taotaotech.service.impl;

import com.taotaotech.core.service.CrudService;
import com.taotaotech.dao.CgthOrderMapper;
import com.taotaotech.domain.CgthOrder;
import com.taotaotech.service.ICgthOrderService;
import org.springframework.stereotype.Service;

/**
 * @author Cailin.Chen
 * @Date 15/10/16
 * @eMail cailin618@sina.com
 */
@Service
public class CgthOrderServiceImpl extends CrudService<CgthOrderMapper,CgthOrder> implements ICgthOrderService {
}
