package com.taotaotech.controller;

import com.taotaotech.core.controller.BaseController;
import com.taotaotech.domain.Agent;
import com.taotaotech.dto.BillRich;
import com.taotaotech.dto.Commission;
import com.taotaotech.service.IAgentService;
import com.taotaotech.service.ICommissionService;
import com.taotaotech.service.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    public String list(String province,String keyword,HttpServletRequest request, HttpServletResponse response,ModelMap model) {
        BillRich billRich = new BillRich();
        if (null !=province && null != keyword){
            if (province.equals("medicineCode")){
                billRich.setMedicineCode(keyword);
            }else if (province.equals("userCode")){
                billRich.setUserCode(keyword);
            }else if (province.equals("twoLevelCode")){
                billRich.setTwoLevelCode(keyword);
            }else if (province.equals("threeLevelCode")){
                billRich.setThreeLevelCode(keyword);
            }else if (province.equals("clientCode")){
                billRich.setClientCode(keyword);
            }
        }

        Page<Commission> page = commissionService.findCommissionList(new Page<Commission>(request, response),billRich);
        Commission countCommission = commissionService.statisticsCommission(billRich);
        model.addAttribute("page", page);
        model.addAttribute("countCommission", countCommission);

        return "commission/commission_list";
    }
}
