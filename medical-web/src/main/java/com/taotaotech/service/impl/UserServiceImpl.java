package com.taotaotech.service.impl;

import com.taotaotech.core.dto.ResponseResult;
import com.taotaotech.core.service.CrudService;
import com.taotaotech.dao.UserMapper;
import com.taotaotech.domain.User;
import com.taotaotech.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Cailin.Chen
 * @Date 15/8/23
 * @eMail cailin618@sina.com
 */
@Service
public class UserServiceImpl extends CrudService<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    public User login(String username, String password) {
        User user = userMapper.selectByUsername(username);
        if (null != user && !user.getPassword().equals(password)) {
            user = null;
        }
        return user;
    }

    public ResponseResult isValidUser(String username, String password) {
        ResponseResult result = new ResponseResult();

        User user = userMapper.selectByUsername(username);
        if (null == user) {
            result.setSuccess(false);
            result.setMsg("用户不存在");
        }
        if (!user.getPassword().equals(password)) {
            result.setSuccess(false);
            result.setMsg("密码不正确");
        }
        return result;
    }

    public Boolean existBySalesmanCode(String coder){
       return userMapper.existBySalesmanCode(coder);
    }

}
