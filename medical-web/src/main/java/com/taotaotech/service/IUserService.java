package com.taotaotech.service;

import com.taotaotech.core.dto.ResponseResult;
import com.taotaotech.domain.User;
import java.util.List;

/**
 * @author Cailin.Chen
 * @Date 15/8/23
 * @eMail cailin618@sina.com
 */

public interface IUserService {

    User login(String username,String password);

    ResponseResult isValidUser(String username,String password);

    public List<User> findUserList();

    public int save(User user);
}
