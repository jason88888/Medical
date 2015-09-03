package com.taotaotech.controller;

import com.taotaotech.core.controller.BaseController;
import com.taotaotech.core.dto.ResponseResult;
import com.taotaotech.domain.User;
import com.taotaotech.service.IUserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Cailin.Chen
 * @Date 15/8/27
 * @eMail cailin618@sina.com
 */
@Controller
@RequestMapping("/")
public class LoginController extends BaseController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "login", method = {RequestMethod.GET})
    public String index() {
        return "sys/login";
    }

    @RequestMapping(value = "login", method = {RequestMethod.POST}, produces = "application/json;charset=UTF-8")
    public String login(@Param(value = "username") String username,
                      @Param(value = "password") String password, HttpServletRequest request, HttpServletResponse response, Model model) {

        User user = userService.login(username, password);

        if (user != null) {

        } else {

        }

        return "sys/login";
    }


}
