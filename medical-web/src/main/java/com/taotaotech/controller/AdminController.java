package com.taotaotech.controller;

import com.taotaotech.core.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class AdminController extends BaseController {

    @RequestMapping("")
    public String index() {
        return "sys/index";
    }
}
