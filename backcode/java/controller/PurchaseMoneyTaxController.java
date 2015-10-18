package com.taotaotech.backcode.java.controller;

import com.taotaotech.backcode.java.service.IPurchaseMoneyTaxService;
import com.taotaotech.core.controller.BaseController;
import com.taotaotech.core.dto.DWZResponseResult;
import com.taotaotech.core.persistence.Page;
import com.taotaotech.backcode.java.domain.PurchaseMoneytax;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zk
 * @date 2015/9/4 10:36
 * @description 采购-钱税管理
 */
@Controller
@RequestMapping("purchase/moneytax")
public class PurchaseMoneyTaxController extends BaseController {
    @Autowired
    private IPurchaseMoneyTaxService purchaseMoneyTaxService;

    @RequestMapping(value = "list", method = {RequestMethod.POST, RequestMethod.GET}, produces = "application/json;charset=UTF-8")
    public String list(PurchaseMoneytax purchaseMoneytax, HttpServletRequest request, HttpServletResponse response, Model model) {
        Page<PurchaseMoneytax> page = purchaseMoneyTaxService.findPage(new Page<PurchaseMoneytax>(request, response), purchaseMoneytax);
        model.addAttribute("page", page);
        return "purchase/moneytax/moneytax_list";
    }

    @RequestMapping(value = "insert", method = {RequestMethod.GET})
    public String add() {
        return "purchase/moneytax/moneytax_insert";
    }

    @RequestMapping(value = "edit", method = {RequestMethod.GET})
    public String edit(Integer id, Model model) {
        PurchaseMoneytax purchaseMoneytax = purchaseMoneyTaxService.get(id);
        model.addAttribute("purchaseMoneytax", purchaseMoneytax);
        return "purchase/moneytax/moneytax_edit";
    }

    @RequestMapping(value = "view", method = {RequestMethod.GET})
    public String view(Integer id, Model model) {
        PurchaseMoneytax purchaseMoneytax = purchaseMoneyTaxService.get(id);
        model.addAttribute("purchaseMoneytax", purchaseMoneytax);
        return "purchase/moneytax/moneytax_view";
    }

    @RequestMapping(value = "save", method = {RequestMethod.POST})
    @ResponseBody
    public Object save(PurchaseMoneytax purchaseMoneytax) {
        purchaseMoneyTaxService.save(purchaseMoneytax);
        DWZResponseResult result = new DWZResponseResult();
        result.setMessage("保存成功");
        result.setCallbackType("closeCurrent");
        result.setForwardUrl("purchase/moneytax/list");
        result.setNavTabId("moneytax_list");
        return result;
    }

    @RequestMapping(value = "delete", method = {RequestMethod.POST})
    @ResponseBody
    public Object save(Integer[] ids) {
        purchaseMoneyTaxService.delete(ids);
        DWZResponseResult result = new DWZResponseResult();
        result.setMessage("删除成功");
        result.setForwardUrl("purchase/moneytax/list");
        result.setNavTabId("moneytax_list");
        return result;
    }

//    @RequestMapping(value = "lookup_suggest")
//    @ResponseBody
//    public List<Medicine> lookupSuggest(String name) {
//        Page<Medicine> page = new Page<>(1, 10);
//        Medicine medicine = new Medicine();
//        medicine.setName(name);
//        page = medicineService.findPage(page, medicine);
//
//        return page.getList();
//    }
//
//    @RequestMapping(value = "lookup")
//    public String lookup(Medicine medicine, HttpServletRequest request, HttpServletResponse response, Model model) {
//
//        Page<Medicine> page = medicineService.findPage(new Page<Medicine>(request, response), medicine);
//        model.addAttribute("page", page);
//
//        return "medicine/medicine_lookup";
//    }
}