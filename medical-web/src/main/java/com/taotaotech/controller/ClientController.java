package com.taotaotech.controller;

import com.taotaotech.core.controller.BaseController;
import com.taotaotech.core.dto.DWZResponseResult;
import com.taotaotech.domain.Client;
import com.taotaotech.service.IClientService;
import com.taotaotech.core.persistence.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    public String list(ModelMap model,HttpServletRequest request, HttpServletResponse response) {

        Page<Client> page = clientService.findPage(new Page<Client>(request, response), new Client());
        model.addAttribute("page", page);
        return "client/client_list";
    }

    @RequestMapping(value = "insert", method = {RequestMethod.GET})
    public String add() {
        return "client/client_insert";
    }

    @RequestMapping(value = "edit", method = {RequestMethod.GET})
    public String edit(Integer id, Model model) {
        Client client = clientService.get(id);
        model.addAttribute("client", client);
        return "client/client_edit";
    }

    @RequestMapping(value = "view", method = {RequestMethod.GET})
    public String view(Integer id, Model model) {
        Client client = clientService.get(id);
        model.addAttribute("client", client);
        return "client/client_view";
    }

    @RequestMapping(value = "save", method = {RequestMethod.POST})
    @ResponseBody
    public Object save(Client client) {
        clientService.save(client);
        DWZResponseResult result = new DWZResponseResult();
        result.setMessage("保存成功");
        result.setCallbackType("closeCurrent");
        result.setForwardUrl("client/list");
        result.setNavTabId("client_list");
        return result;
    }

    @RequestMapping(value = "delete", method = {RequestMethod.POST})
    @ResponseBody
    public Object save(Integer[] ids) {
        clientService.delete(ids);
        DWZResponseResult result = new DWZResponseResult();
        result.setMessage("删除成功");
        result.setForwardUrl("client/list");
        result.setNavTabId("client_list");
        return result;
    }

    @RequestMapping(value = "lookup_suggest")
    @ResponseBody
    public List<Client> lookupSuggest(String name) {
        Page<Client> page = new Page<>(0, 10);
        Client client = new Client();
        client.setName(name);
        page = clientService.findPage(page, client);

        return page.getList();
    }

    @RequestMapping(value = "lookup")
    public String lookup(Client client, HttpServletRequest request, HttpServletResponse response, Model model) {

        Page<Client> page = clientService.findPage(new Page<Client>(request, response), client);
        model.addAttribute("page", page);

        return "client/client_lookup";
    }
}
