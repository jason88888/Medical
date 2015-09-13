package com.taotaotech.controller;

import com.taotaotech.core.controller.BaseController;
import com.taotaotech.domain.MedicinePolicy;
import com.taotaotech.service.IPolicyService;
import com.taotaotech.service.Page;
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
import java.util.List;

@Controller
@RequestMapping("policy")
public class PolicyController extends BaseController {

    @Autowired
    private IPolicyService policyService;

    @RequestMapping(value = {"list", ""}, method = {RequestMethod.GET, RequestMethod.POST})
    public String list(MedicinePolicy medicinePolicy, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
        Page<MedicinePolicy> page = policyService.findPage(new Page<MedicinePolicy>(request, response), medicinePolicy);
        model.addAttribute("page", page);

        return "policy/policy_list";
    }

    @RequestMapping(value = "upload", method = {RequestMethod.GET})
    public String upload() {

        return "policy/policy_upload";
    }

    @RequestMapping(value = "upload", method = {RequestMethod.POST})
    @ResponseBody
    public Object uploadSave(@RequestParam("file") MultipartFile file) {
        return policyService.parsePolicyTable(file);
    }
}
