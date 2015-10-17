package com.taotaotech.controller;

import com.taotaotech.core.controller.BaseController;
import com.taotaotech.core.dto.DWZResponseResult;
import com.taotaotech.core.persistence.Page;
import com.taotaotech.domain.Medicine;
import com.taotaotech.domain.Purchasement;
import com.taotaotech.service.IMedicineService;
import com.taotaotech.service.IPurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author zk
 * @date 2015/9/4 10:36
 * @description 产品目录
 */
@Controller
@RequestMapping("purchase")
public class PurchaseController extends BaseController {
    @Autowired
    private IPurchaseService purchaseService;
    @Autowired
    private IMedicineService medicineService;

    @RequestMapping(value = "list", method = {RequestMethod.POST, RequestMethod.GET}, produces = "application/json;charset=UTF-8")
    public String list(Purchasement purchasement, HttpServletRequest request, HttpServletResponse response, Model model) {
        Page<Purchasement> page = purchaseService.findPage(new Page<Purchasement>(request, response), purchasement);
        model.addAttribute("page", page);
        return "purchase/purchase_list";
    }

    @RequestMapping(value = "insert", method = {RequestMethod.GET})
    public String add(Model model) {
        List<Medicine> medicines = medicineService.findMedicineList();

        model.addAttribute("medicines", medicines);
//        model.addAttribute("clients", clients);
//        model.addAttribute("taxes", taxes);
        return "purchase/purchase_insert";
    }

    @RequestMapping(value = "edit", method = {RequestMethod.GET})
    public String edit(Integer id, Model model) {
        Purchasement Purchasement = purchaseService.get(id);
        model.addAttribute("purchasement", Purchasement);
        List<Medicine> medicines = medicineService.findMedicineList();
        model.addAttribute("medicines", medicines);
        return "purchase/purchase_edit";
    }

    @RequestMapping(value = "view", method = {RequestMethod.GET})
    public String view(Integer id, Model model) {
        Purchasement Purchasement = purchaseService.get(id);
        model.addAttribute("purchasement", Purchasement);
        List<Medicine> medicines = medicineService.findMedicineList();
        model.addAttribute("medicines", medicines);
        return "purchase/purchase_view";
    }

    @RequestMapping(value = "save", method = {RequestMethod.POST})
    @ResponseBody
    public Object save(Purchasement purchasement) {
        purchaseService.save(purchasement);
        DWZResponseResult result = new DWZResponseResult();
        result.setMessage("保存成功");
        result.setCallbackType("closeCurrent");
        result.setForwardUrl("purchase/list");
        result.setNavTabId("purchase_list");
        return result;
    }

    @RequestMapping(value = "delete", method = {RequestMethod.POST})
    @ResponseBody
    public Object save(Integer[] ids) {
        purchaseService.delete(ids);
        DWZResponseResult result = new DWZResponseResult();
        result.setMessage("删除成功");
        result.setForwardUrl("purchase/list");
        result.setNavTabId("purchase_list");
        return result;
    }

    @RequestMapping(value = "upload", method = {RequestMethod.GET})
    public String upload() {
        return "purchase/purchase_upload";
    }

    @RequestMapping(value = "upload", method = {RequestMethod.POST})
    @ResponseBody
    public Object uploadSave(@RequestParam("file") MultipartFile file) {
        return purchaseService.parsePurchaseTable(file);
    }
}
