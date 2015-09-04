package com.taotaotech.controller;

import com.taotaotech.core.controller.BaseController;
import com.taotaotech.domain.Client;
import com.taotaotech.domain.Medicine;
import com.taotaotech.service.IClientService;
import com.taotaotech.service.IMedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

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
    public String list(ModelMap model) {

        List<Client> clients = clientService.findClientList();
        model.addAttribute("clients", clients);
        return "client/client_list";
    }
}
