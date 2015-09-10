package com.taotaotech.controller;

import com.taotaotech.core.controller.BaseController;
import com.taotaotech.dto.BillRich;
import com.taotaotech.service.IBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("bill")
public class BillController extends BaseController {

    @Autowired
    public IBillService billService;

    @RequestMapping(value = "list", method = {RequestMethod.POST, RequestMethod.GET})
    public String list(ModelMap model) {
        List<BillRich> bills =  billService.findBillList();
        model.addAttribute("bills", bills);
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
