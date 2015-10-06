package com.taotaotech.controller;

import com.taotaotech.core.controller.BaseController;
import com.taotaotech.domain.User;
import com.taotaotech.service.IUserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping(value = "coming", method = {RequestMethod.GET})
    public String coming() {
        return "coming";
    }

    @RequestMapping(value = "login", method = {RequestMethod.GET, RequestMethod.POST})
    public String login(@Param(value = "username") String username,
                        @Param(value = "password") String password, HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = null;
        if (username != null || password != null) {
            user = userService.login(username, password);
        }
        if (user != null) {
            request.getSession().setAttribute("user", user);
            return "redirect:/";
        }
        if (request.getMethod().equals("POST")) {
            request.setAttribute("message", new Message(Message.ERROR, "用户名或密码错误！"));
        }

        return "sys/login";
    }

    @RequestMapping(value = "logout", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json;charset=UTF-8")
    public String login(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {

        HttpSession session = request.getSession(false);
        if (session != null) {
            session.removeAttribute("user");
        }
        return "redirect:/login";
    }
}
