package com.taotaotech.controller;

import com.taotaotech.core.controller.BaseController;
import com.taotaotech.core.dto.ResponseResult;
import com.taotaotech.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Cailin.Chen
 * @Date 15/8/27
 * @eMail cailin618@sina.com
 */
@Controller
@RequestMapping("login")
public class LoginController extends BaseController {

    @Autowired
    private IUserService userService;

    @RequestMapping("")
    public String index(){
        return "sys/login";
    }

    @RequestMapping("login")
    @ResponseBody
    public ResponseResult login(ModelMap model, HttpServletRequest request,String username,String password){
        return userService.isValidUser(username, password);
    }


}
