package com.taotaotech.controller;

import com.taotaotech.core.controller.BaseController;
import com.taotaotech.core.dto.DWZResponseResult;
import com.taotaotech.core.persistence.Page;
import com.taotaotech.domain.AgentClient;
import com.taotaotech.domain.Client;
import com.taotaotech.service.IAgentClientService;
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
@RequestMapping("agentclient")
public class AgentClientController extends BaseController {
    @Autowired
    private IAgentClientService agentclientService;
    @RequestMapping(value = "list", method = {RequestMethod.POST, RequestMethod.GET})
    public String list(ModelMap model,HttpServletRequest request, HttpServletResponse response) {
        Page<AgentClient> page = agentclientService.findPage(new Page<AgentClient>(request, response), new AgentClient());
        model.addAttribute("page", page);
        return "agentclient/agentclient_list";
    }

    @RequestMapping(value = "insert", method = {RequestMethod.GET})
    public String add() {
        return "agentclient/agentclient_insert";
    }

    @RequestMapping(value = "edit", method = {RequestMethod.GET})
    public String edit(Integer id, Model model) {
        AgentClient agentclient = agentclientService.get(id);
        model.addAttribute("agentclient", agentclient);
        return "agentclient/agentclient_edit";
    }

    @RequestMapping(value = "view", method = {RequestMethod.GET})
    public String view(Integer id, Model model) {
        AgentClient agentclient = agentclientService.get(id);
        model.addAttribute("agentclient", agentclient);
        return "agentclient/agentclient_view";
    }

    @RequestMapping(value = "save", method = {RequestMethod.POST})
    @ResponseBody
    public Object save(AgentClient agentclient) {
        agentclientService.save(agentclient);
        DWZResponseResult result = new DWZResponseResult();
        result.setMessage("保存成功");
        result.setCallbackType("closeCurrent");
        result.setForwardUrl("agentclient/list");
        result.setNavTabId("agentclient_list");
        return result;
    }

    @RequestMapping(value = "delete", method = {RequestMethod.POST})
    @ResponseBody
    public Object save(Integer[] ids) {
        agentclientService.delete(ids);
        DWZResponseResult result = new DWZResponseResult();
        result.setMessage("删除成功");
        result.setForwardUrl("agentclient/list");
        result.setNavTabId("agentclient_list");
        return result;
    }

    @RequestMapping(value = "lookup_suggest")
    @ResponseBody
    public List<AgentClient> lookupSuggest(String name) {
        Page<AgentClient> page = new Page<>(0, 10);
        AgentClient agentclient = new AgentClient();
        agentclient.setName(name);
        page = agentclientService.findPage(page, agentclient);
        return page.getList();
    }

    @RequestMapping(value = "lookup")
    public String lookup(AgentClient agentclient, HttpServletRequest request, HttpServletResponse response, Model model) {
        Page<AgentClient> page = agentclientService.findPage(new Page<AgentClient>(request, response), agentclient);
        model.addAttribute("page", page);
        return "agentclient/agentclient_lookup";
    }
}
