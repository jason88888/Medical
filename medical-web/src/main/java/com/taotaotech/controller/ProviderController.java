package com.taotaotech.controller;

import com.taotaotech.core.controller.BaseController;
import com.taotaotech.core.dto.DWZResponseResult;
import com.taotaotech.core.persistence.Page;
import com.taotaotech.domain.Provider;
import com.taotaotech.domain.Provider;
import com.taotaotech.service.IProviderService;
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
@RequestMapping("provider")
public class ProviderController extends BaseController {
    @Autowired
    private IProviderService providerService;
    @RequestMapping(value = "list", method = {RequestMethod.POST, RequestMethod.GET})
    public String list(ModelMap model,HttpServletRequest request, HttpServletResponse response) {
        Page<Provider> page = providerService.findPage(new Page<Provider>(request, response), new Provider());
        model.addAttribute("page", page);
        return "provider/provider_list";
    }

    @RequestMapping(value = "insert", method = {RequestMethod.GET})
    public String add() {
        return "provider/provider_insert";
    }

    @RequestMapping(value = "edit", method = {RequestMethod.GET})
    public String edit(Integer id, Model model) {
        Provider provider = providerService.get(id);
        model.addAttribute("provider", provider);
        return "provider/provider_edit";
    }

    @RequestMapping(value = "view", method = {RequestMethod.GET})
    public String view(Integer id, Model model) {
        Provider provider = providerService.get(id);
        model.addAttribute("provider", provider);
        return "provider/provider_view";
    }

    @RequestMapping(value = "save", method = {RequestMethod.POST})
    @ResponseBody
    public Object save(Provider provider) {
        providerService.save(provider);
        DWZResponseResult result = new DWZResponseResult();
        result.setMessage("保存成功");
        result.setCallbackType("closeCurrent");
        result.setForwardUrl("provider/list");
        result.setNavTabId("provider_list");
        return result;
    }

    @RequestMapping(value = "delete", method = {RequestMethod.POST})
    @ResponseBody
    public Object save(Integer[] ids) {
        providerService.delete(ids);
        DWZResponseResult result = new DWZResponseResult();
        result.setMessage("删除成功");
        result.setForwardUrl("provider/list");
        result.setNavTabId("provider_list");
        return result;
    }

    @RequestMapping(value = "lookup_suggest")
    @ResponseBody
    public List<Provider> lookupSuggest(String name) {
        Page<Provider> page = new Page<>(0, 10);
        Provider provider = new Provider();
        provider.setName(name);
        page = providerService.findPage(page, provider);
        return page.getList();
    }

    @RequestMapping(value = "lookup")
    public String lookup(Provider provider, HttpServletRequest request, HttpServletResponse response, Model model) {
        Page<Provider> page = providerService.findPage(new Page<Provider>(request, response), provider);
        model.addAttribute("page", page);
        return "provider/provider_lookup";
    }
}
