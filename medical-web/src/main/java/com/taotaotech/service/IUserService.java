package com.taotaotech.service;

import com.taotaotech.core.dto.ResponseResult;
import com.taotaotech.core.service.BaseService;
import com.taotaotech.core.service.IBaseService;
import com.taotaotech.domain.User;
import java.util.List;

/**
 * @author Cailin.Chen
 * @Date 15/8/23
 * @eMail cailin618@sina.com
 */

public interface IUserService extends IBaseService<User> {

    User login(String username,String password);

    ResponseResult isValidUser(String username,String password);

    public Boolean existBySalesmanCode(String coder);
}
