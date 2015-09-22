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
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Cailin.Chen
 * @Date 15/8/27
 * @eMail cailin618@sina.com
 */
@Controller
@RequestMapping("")
public class LoginController extends BaseController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "index", method = {RequestMethod.GET})
    public String index() {
        return "sys/index";
    }

    @RequestMapping(value = "coming", method = {RequestMethod.GET})
    public String coming() {
        return "coming";
    }

    @RequestMapping(value = "login", method = {RequestMethod.GET,RequestMethod.POST}, produces = "application/json;charset=UTF-8")
    public void login(@Param(value = "username") String username,
                      @Param(value = "password") String password, HttpServletRequest request, HttpServletResponse response,
                      Model model) {

        User user = userService.login(username, password);

        try {
            if (user != null) {
                request.getSession().setAttribute("user", user);
                response.sendRedirect("index");
            } else {
                response.sendRedirect("");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @RequestMapping(value = "logout", method = {RequestMethod.GET,RequestMethod.POST}, produces = "application/json;charset=UTF-8")
    public void login( HttpServletRequest request, HttpServletResponse response, Model model) {

        HttpSession session=request.getSession(false);
        try {
            if(session==null)
            {
                response.sendRedirect("");
                return ;
            }
            session.removeAttribute("user");
            response.sendRedirect("");
        }catch (IOException e) {
            e.printStackTrace();
        }


    }


}
