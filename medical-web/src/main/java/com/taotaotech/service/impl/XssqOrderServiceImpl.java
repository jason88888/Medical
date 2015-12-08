package com.taotaotech.service.impl;

import com.taotaotech.core.service.CrudService;
import com.taotaotech.dao.XsckOrderMapper;
import com.taotaotech.dao.XssqOrderMapper;
import com.taotaotech.domain.XsckOrder;
import com.taotaotech.domain.XssqOrder;
import com.taotaotech.service.IXsckOrderService;
import com.taotaotech.service.IXssqOrderService;
import org.springframework.stereotype.Service;

/**
 * @author Cailin.Chen
 * @Date 15/10/16
 * @eMail cailin618@sina.com
 */
@Service
public class XssqOrderServiceImpl extends CrudService<XssqOrderMapper, XssqOrder> implements IXssqOrderService {
}
