package com.taotaotech.controller;

import com.taotaotech.core.controller.BaseController;
import com.taotaotech.core.dto.DWZResponseResult;
import com.taotaotech.domain.Policy;
import com.taotaotech.service.IPolicyService;
import com.taotaotech.core.persistence.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("policy")
public class PolicyController extends BaseController {

    @Autowired
    private IPolicyService policyService;

    @RequestMapping(value = "upload", method = {RequestMethod.GET})
    public String upload() {

        return "policy/policy_upload";
    }

    @RequestMapping(value = "upload", method = {RequestMethod.POST})
    @ResponseBody
    public Object uploadSave(@RequestParam("file") MultipartFile file) {
        return policyService.parsePolicyTable(file);
    }

    @RequestMapping(value = {"list", ""}, method = {RequestMethod.GET, RequestMethod.POST})
    public String list(Policy policy, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
        Page<Policy> page = policyService.findPage(new Page<Policy>(request, response), policy);
        model.addAttribute("page", page);

        return "policy/policy_list";
    }

    @RequestMapping(value = "form", method = {RequestMethod.GET})
    public String edit(Integer id, Model model) {
        if (id != null) {
            Policy policy = policyService.get(id);
            model.addAttribute("policy", policy);
        }

        return "policy/policy_form";
    }

    @RequestMapping(value = "view", method = {RequestMethod.GET})
    public String view(Integer id, Model model) {
        Policy policy = policyService.get(id);
        model.addAttribute("policy", policy);

        return "policy/policy_view";
    }

    @RequestMapping(value = "save", method = {RequestMethod.POST})
    @ResponseBody
    public Object save(Policy policy, HttpServletRequest request) {
        String medicineCode = request.getParameter("medicine.code");
        String clientCode = request.getParameter("client.code");
        policy.setMedicineCode(medicineCode);
        policy.setClientCode(clientCode);

        policyService.save(policy);

        DWZResponseResult result = new DWZResponseResult();
        result.setMessage("保存成功");
        result.setCallbackType("closeCurrent");
        result.setForwardUrl("policy/list");
        result.setNavTabId("policy_list");

        return result;
    }

    @RequestMapping(value = "delete", method = {RequestMethod.POST})
    @ResponseBody
    public Object save(Integer[] ids) {
        policyService.delete(ids);

        DWZResponseResult result = new DWZResponseResult();
        result.setMessage("删除成功");
        result.setForwardUrl("policy/list");
        result.setNavTabId("policy_list");

        return result;
    }
}
