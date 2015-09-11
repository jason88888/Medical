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

    public User get(Integer id);

    public User get(User user);

    public List<User> findList();

    public Page<User> findPage(Page<User> page, User user);

    public int save(User user);

    public int delete(Integer[] ids);
}
