package com.taotaotech.service.impl;

import com.taotaotech.core.service.CrudService;
import com.taotaotech.dao.XssqOrderMapper;
import com.taotaotech.dao.XsthOrderMapper;
import com.taotaotech.domain.XssqOrder;
import com.taotaotech.domain.XsthOrder;
import com.taotaotech.service.IXssqOrderService;
import com.taotaotech.service.IXsthOrderService;
import org.springframework.stereotype.Service;

/**
 * @author Cailin.Chen
 * @Date 15/10/16
 * @eMail cailin618@sina.com
 */
@Service
public class XsthOrderServiceImpl extends CrudService<XsthOrderMapper, XsthOrder> implements IXsthOrderService {
}
