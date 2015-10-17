package com.taotaotech.service.impl;

import com.taotaotech.core.service.CrudService;
import com.taotaotech.dao.RkOrderMapper;
import com.taotaotech.domain.RkOrder;
import com.taotaotech.service.IRkOrderService;
import org.springframework.stereotype.Service;

/**
 * @author Cailin.Chen
 * @Date 15/10/16
 * @eMail cailin618@sina.com
 */
@Service
public class RkOrderServiceImpl extends CrudService<RkOrderMapper,RkOrder> implements IRkOrderService {
}
