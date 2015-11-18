package com.taotaotech.service.impl;

import com.taotaotech.core.service.CrudService;
import com.taotaotech.dao.CgrkOrderMapper;
import com.taotaotech.domain.CgrkOrder;
import com.taotaotech.service.ICgrkOrderService;
import org.springframework.stereotype.Service;

/**
 * @author Cailin.Chen
 * @Date 15/10/16
 * @eMail cailin618@sina.com
 */
@Service
public class CgrkOrderServiceImpl extends CrudService<CgrkOrderMapper,CgrkOrder> implements ICgrkOrderService {
}
