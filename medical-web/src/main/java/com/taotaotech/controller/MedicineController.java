package com.taotaotech.controller;

import com.taotaotech.core.controller.BaseController;
import com.taotaotech.domain.Medicine;
import com.taotaotech.service.IMedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author zk
 * @date 2015/9/4 10:36
 * @description
 */
@Controller
@RequestMapping("medicine")
public class MedicineController extends BaseController {
    @Autowired
    private IMedicineService medicineService;
    @RequestMapping(value = "list", method = {RequestMethod.POST, RequestMethod.GET})
    public String list(ModelMap model) {

        List<Medicine> medicines = medicineService.findMedicineList();
        model.addAttribute("medicines", medicines);
        return "medicine/medicine_list";
    }
}
