package com.taotaotech.controller;

import com.taotaotech.core.controller.BaseController;
import com.taotaotech.core.dto.DWZResponseResult;
import com.taotaotech.core.persistence.Page;
import com.taotaotech.domain.CommercialCompany;
import com.taotaotech.service.ICommercialCompanyService;
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
@RequestMapping("commercialcompany")
public class CommercialCompanyController extends BaseController {
    @Autowired
    private ICommercialCompanyService commercialcompanyService;
    @RequestMapping(value = "list", method = {RequestMethod.POST, RequestMethod.GET})
    public String list(ModelMap model,HttpServletRequest request, HttpServletResponse response) {
        Page<CommercialCompany> page = commercialcompanyService.findPage(new Page<CommercialCompany>(request, response), new CommercialCompany());
        model.addAttribute("page", page);
        return "commercialcompany/commercialcompany_list";
    }

    @RequestMapping(value = "insert", method = {RequestMethod.GET})
    public String add() {
        return "commercialcompany/commercialcompany_insert";
    }

    @RequestMapping(value = "edit", method = {RequestMethod.GET})
    public String edit(Integer id, Model model) {
        CommercialCompany commercialcompany = commercialcompanyService.get(id);
        model.addAttribute("commercialcompany", commercialcompany);
        return "commercialcompany/commercialcompany_edit";
    }

    @RequestMapping(value = "view", method = {RequestMethod.GET})
    public String view(Integer id, Model model) {
        CommercialCompany commercialcompany = commercialcompanyService.get(id);
        model.addAttribute("commercialcompany", commercialcompany);
        return "commercialcompany/commercialcompany_view";
    }

    @RequestMapping(value = "save", method = {RequestMethod.POST})
    @ResponseBody
    public Object save(CommercialCompany commercialcompany) {
        commercialcompanyService.save(commercialcompany);
        DWZResponseResult result = new DWZResponseResult();
        result.setMessage("保存成功");
        result.setCallbackType("closeCurrent");
        result.setForwardUrl("commercialcompany/list");
        result.setNavTabId("commercialcompany_list");
        return result;
    }

    @RequestMapping(value = "delete", method = {RequestMethod.POST})
    @ResponseBody
    public Object save(Integer[] ids) {
        commercialcompanyService.delete(ids);
        DWZResponseResult result = new DWZResponseResult();
        result.setMessage("删除成功");
        result.setForwardUrl("commercialcompany/list");
        result.setNavTabId("commercialcompany_list");
        return result;
    }

    @RequestMapping(value = "lookup_suggest")
    @ResponseBody
    public List<CommercialCompany> lookupSuggest(String name) {
        Page<CommercialCompany> page = new Page<>(0, 10);
        CommercialCompany commercialcompany = new CommercialCompany();
        commercialcompany.setName(name);
        page = commercialcompanyService.findPage(page, commercialcompany);
        return page.getList();
    }

    @RequestMapping(value = "lookup")
    public String lookup(CommercialCompany commercialcompany, HttpServletRequest request, HttpServletResponse response, Model model) {
        Page<CommercialCompany> page = commercialcompanyService.findPage(new Page<CommercialCompany>(request, response), commercialcompany);
        model.addAttribute("page", page);
        return "commercialcompany/commercialcompany_lookup";
    }
}
