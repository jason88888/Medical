package com.taotaotech.controller;

import com.taotaotech.core.controller.BaseController;
import com.taotaotech.core.dto.DWZResponseResult;
import com.taotaotech.domain.Medicine;
import com.taotaotech.service.IMedicineService;
import com.taotaotech.core.persistence.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author zk
 * @date 2015/9/4 10:36
 * @description 产品目录
 */
@Controller
@RequestMapping("medicine")
public class MedicineController extends BaseController {
    @Autowired
    private IMedicineService medicineService;

    @RequestMapping(value = "list", method = {RequestMethod.POST, RequestMethod.GET}, produces = "application/json;charset=UTF-8")
    public String list(Medicine medicine, HttpServletRequest request, HttpServletResponse response, Model model) {

        Page<Medicine> page = medicineService.findPage(new Page<Medicine>(request, response), medicine);
        model.addAttribute("page", page);
        return "medicine/medicine_list";
    }

    @RequestMapping(value = "insert", method = {RequestMethod.GET})
    public String add() {
        return "medicine/medicine_insert";
    }

    @RequestMapping(value = "edit", method = {RequestMethod.GET})
    public String edit(Integer id, Model model) {
        Medicine medicine = medicineService.get(id);
        model.addAttribute("medicine", medicine);
        return "medicine/medicine_edit";
    }

    @RequestMapping(value = "view", method = {RequestMethod.GET})
    public String view(Integer id, Model model) {
        Medicine medicine = medicineService.get(id);
        model.addAttribute("medicine", medicine);

        return "medicine/medicine_view";
    }

    @RequestMapping(value = "save", method = {RequestMethod.POST})
    @ResponseBody
    public Object save(Medicine medicine) {
        medicineService.save(medicine);
        DWZResponseResult result = new DWZResponseResult();
        result.setMessage("保存成功");
        result.setCallbackType("closeCurrent");
        result.setForwardUrl("medicine/list");
        result.setNavTabId("medicine_list");
        return result;
    }

    @RequestMapping(value = "delete", method = {RequestMethod.POST})
    @ResponseBody
    public Object save(Integer[] ids) {
        medicineService.delete(ids);
        DWZResponseResult result = new DWZResponseResult();
        result.setMessage("删除成功");
        result.setForwardUrl("medicine/list");
        result.setNavTabId("medicine_list");
        return result;
    }

    @RequestMapping(value = "lookup_suggest")
    @ResponseBody
    public List<Medicine> lookupSuggest(String name) {
        Page<Medicine> page = new Page<>(1, 10);
        Medicine medicine = new Medicine();
        medicine.setName(name);
        page = medicineService.findPage(page, medicine);

        return page.getList();
    }

    @RequestMapping(value = "lookup")
    public String lookup(Medicine medicine, HttpServletRequest request, HttpServletResponse response, Model model) {

        Page<Medicine> page = medicineService.findPage(new Page<Medicine>(request, response), medicine);
        model.addAttribute("page", page);

        return "medicine/medicine_lookup";
    }
}
