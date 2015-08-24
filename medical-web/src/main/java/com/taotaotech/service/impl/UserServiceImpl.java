package com.taotaotech.service.impl;

import com.taotaotech.core.exception.BusinessException;
import com.taotaotech.dao.user.UserMapper;
import com.taotaotech.domain.user.User;
import com.taotaotech.exception.user.UserErrorCode;
import com.taotaotech.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Cailin.Chen
 * @Date 15/8/23
 * @eMail cailin618@sina.com
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    public User login(String username, String password) {
        User user = userMapper.selectByUsername(username);
        if (null==user){
            throw new BusinessException(UserErrorCode.USERNAME_NOT_EXIST);
        }
        if (!user.getPassword().equals(password) ){
            throw new BusinessException(UserErrorCode.PASSWORD_ERROR);
        }
        return user;
    }
}
