package com.taotaotech.controller;

import com.taotaotech.core.controller.BaseController;
import com.taotaotech.core.dto.ResponseResult;
import com.taotaotech.core.exception.BusinessException;
import com.taotaotech.core.utils.JsonUtil;
import com.taotaotech.domain.user.User;
import com.taotaotech.exception.user.UserErrorCode;
import com.taotaotech.service.IUserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Cailin.Chen
 * @Date 15/8/23
 * @eMail cailin618@sina.com
 */
@Controller
@RequestMapping("user")
public class UserController extends BaseController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "login",method = {RequestMethod.POST,RequestMethod.GET} ,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Object login(@Param(value = "username") String username,
                        @Param(value = "password") String password){

        User user = userService.login(username,password);

        ResponseResult result = new ResponseResult();
        result.setData(user);
        return result;
    }
}
