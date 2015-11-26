package com.taotaotech.controller.order;

import com.taotaotech.core.controller.BaseController;
import com.taotaotech.core.dto.DWZResponseResult;
import com.taotaotech.core.persistence.Page;
import com.taotaotech.domain.CgthOrder;
import com.taotaotech.service.ICgthOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zk
 * @date 2015/9/4 10:36
 * @description
 */
@Controller
@RequestMapping("cgthorder")
public class CgthOrderController extends BaseController {
    @Autowired
    private ICgthOrderService cgthOrderService;

    @RequestMapping(value = "list", method = {RequestMethod.POST, RequestMethod.GET})
    public String list(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
        Page<CgthOrder> page = cgthOrderService.findPage(new Page<CgthOrder>(request, response), new CgthOrder());
        model.addAttribute("page", page);
        return "cgthorder/cgthorder_list";
    }

    @RequestMapping(value = "insert", method = {RequestMethod.GET})
    public String add() {
        return "cgthorder/cgthorder_insert";
    }

    @RequestMapping(value = "edit", method = {RequestMethod.GET})
    public String edit(Integer id, Model model) {
        CgthOrder cgthorder = cgthOrderService.get(id);
        model.addAttribute("cgthorder", cgthorder);
        return "cgthorder/cgthorder_edit";
    }

    @RequestMapping(value = "view", method = {RequestMethod.GET})
    public String view(Integer id, Model model) {
        CgthOrder cgthorder = cgthOrderService.get(id);
        model.addAttribute("cgthorder", cgthorder);
        return "cgthorder/cgthorder_view";
    }

    @RequestMapping(value = "save", method = {RequestMethod.POST})
    @ResponseBody
    public Object save(CgthOrder cgthorder, HttpServletRequest request) {
        int warehouseId = Integer.parseInt(request.getParameter("warehouse.id"));
        int medicineId = Integer.parseInt(request.getParameter("medicine.id"));
        int userId = Integer.parseInt(request.getParameter("user.id"));
        int agentClientId = Integer.parseInt(request.getParameter("agent.id"));
        int providerId = Integer.parseInt(request.getParameter("provider.id"));
        int commercialCompanyId = Integer.parseInt(request.getParameter("commercialcompany.id"));
        cgthorder.setWarehouseId(warehouseId);
        cgthorder.setMedicineId(medicineId);
        cgthorder.setSysUserId(userId);
        cgthorder.setAgentId(agentClientId);
        cgthorder.setProviderId(providerId);
        cgthorder.setCommercialCompanyId(commercialCompanyId);
        cgthOrderService.save(cgthorder);
        DWZResponseResult result = new DWZResponseResult();
        result.setMessage("保存成功");
        result.setCallbackType("closeCurrent");
        result.setForwardUrl("cgthorder/list");
        result.setNavTabId("cgthorder_list");
        return result;
    }



    @RequestMapping(value = "delete", method = {RequestMethod.POST})
    @ResponseBody
    public Object save(Integer[] ids) {
        cgthOrderService.delete(ids);
        DWZResponseResult result = new DWZResponseResult();
        result.setMessage("删除成功");
        result.setForwardUrl("cgthorder/list");
        result.setNavTabId("cgthorder_list");
        return result;
    }

}
