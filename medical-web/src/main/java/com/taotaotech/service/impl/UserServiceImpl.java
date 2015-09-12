package com.taotaotech.service.impl;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.taotaotech.core.dto.ResponseResult;
import com.taotaotech.core.exception.BusinessException;
import com.taotaotech.core.utils.MapUtil;
import com.taotaotech.dao.UserMapper;
import com.taotaotech.domain.User;
import com.taotaotech.exception.user.UserErrorCode;
import com.taotaotech.service.IUserService;
import com.taotaotech.service.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        if (null == user) {
            throw new BusinessException(UserErrorCode.USERNAME_NOT_EXIST);
        }
        if (!user.getPassword().equals(password)) {
            throw new BusinessException(UserErrorCode.PASSWORD_ERROR);
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

    @Override
    public User get(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public User get(User user) {
        return userMapper.selectByPrimaryKey(user.getId());
    }

    @Override
    public List<User> findList() {
        return userMapper.findAllList();
    }

    @Override
    public Page<User> findPage(Page<User> page, User user) {
        Map map = MapUtil.bean2Map(user);
        PageList<User> users = (PageList)userMapper.findList(map, page.createPageBounds());

        page.setList(users);
        return page;
    }

    @Override
    public int save(User user) {
        int result = 0;
        if (user.getId() != null && user.getId() != 0) {
            result = userMapper.updateByPrimaryKey(user);
        } else {
            userMapper.insert(user);
        }
        return result;
    }

    @Override
    public int delete(Integer[] ids) {
        List<Integer> list = new ArrayList<Integer>();
        for (Integer id : ids) {
            list.add(id);
        }
        return userMapper.delete(list);
    }
}
