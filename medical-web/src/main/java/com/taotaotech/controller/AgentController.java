package com.taotaotech.controller;

import com.taotaotech.core.controller.BaseController;
import com.taotaotech.core.dto.DWZResponseResult;
import com.taotaotech.domain.Agent;
import com.taotaotech.domain.Medicine;
import com.taotaotech.domain.Agent;
import com.taotaotech.service.IAgentService;
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
@RequestMapping("agent")
public class AgentController extends BaseController {
    @Autowired
    private IAgentService agentService;
    @RequestMapping(value = "list", method = {RequestMethod.POST, RequestMethod.GET})
    public String list(ModelMap model,HttpServletRequest request, HttpServletResponse response) {
        Page<Agent> page = agentService.findPage(new Page<Agent>(request, response), new Agent());
        model.addAttribute("page", page);
        return "agent/agent_list";
    }

    @RequestMapping(value = "insert", method = {RequestMethod.GET})
    public String add() {
        return "agent/agent_insert";
    }

    @RequestMapping(value = "edit", method = {RequestMethod.GET})
    public String edit(Integer id, Model model) {
        Agent agent = agentService.get(id);
        model.addAttribute("agent", agent);
        return "agent/agent_edit";
    }

    @RequestMapping(value = "view", method = {RequestMethod.GET})
    public String view(Integer id, Model model) {
        Agent agent = agentService.get(id);
        model.addAttribute("agent", agent);
        return "agent/agent_view";
    }

    @RequestMapping(value = "save", method = {RequestMethod.POST})
    @ResponseBody
    public Object save(Agent agent) {
        agentService.save(agent);
        DWZResponseResult result = new DWZResponseResult();
        result.setMessage("保存成功");
        result.setCallbackType("closeCurrent");
        result.setForwardUrl("agent/list");
        result.setNavTabId("agent_list");
        return result;
    }

    @RequestMapping(value = "delete", method = {RequestMethod.POST})
    @ResponseBody
    public Object save(Integer[] ids) {
        agentService.delete(ids);
        DWZResponseResult result = new DWZResponseResult();
        result.setMessage("删除成功");
        result.setForwardUrl("agent/list");
        result.setNavTabId("agent_list");
        return result;
    }

    @RequestMapping(value = "lookup_suggest")
    @ResponseBody
    public List<Agent> lookupSuggest(String name) {
        Page<Agent> page = new Page<>(0, 10);
        Agent agent = new Agent();
        agent.setName(name);
        page = agentService.findPage(page, agent);
        return page.getList();
    }

    @RequestMapping(value = "lookup")
    public String lookup(Agent agent, HttpServletRequest request, HttpServletResponse response, Model model) {
        Page<Agent> page = agentService.findPage(new Page<Agent>(request, response), agent);
        model.addAttribute("page", page);
        return "agent/agent_lookup";
    }
}
