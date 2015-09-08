package com.taotaotech.controller;

import com.taotaotech.core.controller.BaseController;
import com.taotaotech.domain.Agent;
import com.taotaotech.dto.Commission;
import com.taotaotech.service.IAgentService;
import com.taotaotech.service.ICommissionService;
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
@RequestMapping("commission")
public class CommissionController extends BaseController {
    @Autowired
    private ICommissionService commissionService;
    @RequestMapping(value = "list", method = {RequestMethod.POST, RequestMethod.GET})
    public String list(ModelMap model) {
        List<Commission> commissions = commissionService.findCommissionList();
        model.addAttribute("commissions", commissions);
        return "commission/commission_list";
    }
}
