package com.taotaotech.controller;

import com.taotaotech.core.controller.BaseController;
import com.taotaotech.domain.Client;
import com.taotaotech.service.IClientService;
import com.taotaotech.service.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zk
 * @date 2015/9/4 10:36
 * @description
 */
@Controller
@RequestMapping("client")
public class ClientController extends BaseController {
    @Autowired
    private IClientService clientService;
    @RequestMapping(value = "list", method = {RequestMethod.POST, RequestMethod.GET})
    public String list(ModelMap model,HttpServletRequest request, HttpServletResponse response) {

        Page<Client> page = clientService.findClientList(new Page<Client>(request, response));
        model.addAttribute("page", page);
        return "client/client_list";
    }
}
