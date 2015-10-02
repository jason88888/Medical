package com.taotaotech.controller;

import com.taotaotech.core.controller.BaseController;
import com.taotaotech.domain.Bill;
import com.taotaotech.dto.Commission;
import com.taotaotech.service.ICommissionService;
import com.taotaotech.core.persistence.Page;
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
@RequestMapping("commission")
public class CommissionController extends BaseController {
    @Autowired
    private ICommissionService commissionService;
    @RequestMapping(value = "list", method = {RequestMethod.POST, RequestMethod.GET})
    public String list(String province,String keyword,HttpServletRequest request, HttpServletResponse response,ModelMap model) {
        Bill bill = new Bill();
        if (null !=province && null != keyword){
            if (province.equals("medicineCode")){
                bill.setMedicineCode(keyword);
            }else if (province.equals("userCode")){
                bill.setUserCode(keyword);
            }else if (province.equals("twoLevelCode")){
                bill.setTwoLevelCode(keyword);
            }else if (province.equals("threeLevelCode")){
                bill.setThreeLevelCode(keyword);
            }else if (province.equals("clientCode")){
                bill.setClientCode(keyword);
            }
        }
        if (1 != getUser().getRole()){
            bill.setUserCode(getUser().getCode());
        }

        Page<Commission> page = commissionService.findCommissionList(new Page<Commission>(request, response), bill);
        Commission countCommission = commissionService.statisticsCommission(bill);
        model.addAttribute("page", page);
        model.addAttribute("countCommission", countCommission);

        return "commission/commission_list";
    }
}
