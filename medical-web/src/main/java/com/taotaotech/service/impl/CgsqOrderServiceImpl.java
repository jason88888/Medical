package com.taotaotech.service.impl;

import com.taotaotech.core.service.CrudService;
import com.taotaotech.dao.CgsqOrderMapper;
import com.taotaotech.domain.CgsqOrder;
import com.taotaotech.service.ICgsqOrderService;
import org.springframework.stereotype.Service;

/**
 * Created by delll on 2015/11/19.
 */
@Service
public class CgsqOrderServiceImpl extends CrudService<CgsqOrderMapper,CgsqOrder> implements ICgsqOrderService {
}
