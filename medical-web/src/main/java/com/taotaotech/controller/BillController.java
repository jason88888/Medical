package com.taotaotech.controller;

import com.taotaotech.core.controller.BaseController;
import com.taotaotech.domain.Bill;
import com.taotaotech.service.IBillService;
import com.taotaotech.core.persistence.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("bill")
public class BillController extends BaseController {

    @Autowired
    public IBillService billService;

    @RequestMapping(value = "list", method = {RequestMethod.POST, RequestMethod.GET})
    public String list(HttpServletRequest request, HttpServletResponse response, ModelMap model) {

        Map map = new HashMap();
        if(getUser().getRole() != 1){
            map.put("userCode", getUser().getCode());
        }
        Page<Bill> page =  billService.findBillList(new Page<Bill>(request, response),map);
        model.addAttribute("page", page);
        return "bill/bill_list";
    }

    @RequestMapping(value = "upload", method = {RequestMethod.GET})
    public String upload() {
        return "bill/bill_upload";
    }

    @RequestMapping(value = "upload", method = {RequestMethod.POST})
    @ResponseBody
    public Object uploadSave(@RequestParam("file") MultipartFile file) {
        return billService.parseBillTable(file);
    }
}
