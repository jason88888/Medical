package com.taotaotech.controller;

import com.taotaotech.core.controller.BaseController;
import com.taotaotech.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("")
public class AdminController extends BaseController {

    @RequestMapping({"", "/"})
    public String index(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }

        return "sys/index";
    }
}
