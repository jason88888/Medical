package com.taotaotech.controller.order;

import com.taotaotech.core.controller.BaseController;
import com.taotaotech.core.dto.DWZResponseResult;
import com.taotaotech.core.persistence.Page;
import com.taotaotech.domain.CgrkOrder;
import com.taotaotech.service.ICgrkOrderService;
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
@RequestMapping("cgrkorder")
public class CgrkOrderController extends BaseController {
    @Autowired
    private ICgrkOrderService cgrkOrderService;

    @RequestMapping(value = "list", method = {RequestMethod.POST, RequestMethod.GET})
    public String list(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
        Page<CgrkOrder> page = cgrkOrderService.findPage(new Page<CgrkOrder>(request, response), new CgrkOrder());
        model.addAttribute("page", page);
        return "cgrkorder/cgrkorder_list";
    }

    @RequestMapping(value = "insert", method = {RequestMethod.GET})
    public String add() {
        return "cgrkorder/cgrkorder_insert";
    }

    @RequestMapping(value = "edit", method = {RequestMethod.GET})
    public String edit(Integer id, Model model) {
        CgrkOrder cgrkorder = cgrkOrderService.get(id);
        model.addAttribute("cgrkorder", cgrkorder);
        return "cgrkorder/cgrkorder_edit";
    }

    @RequestMapping(value = "view", method = {RequestMethod.GET})
    public String view(Integer id, Model model) {
        CgrkOrder cgrkorder = cgrkOrderService.get(id);
        model.addAttribute("cgrkorder", cgrkorder);
        return "cgrkorder/cgrkorder_view";
    }

    @RequestMapping(value = "save", method = {RequestMethod.POST})
    @ResponseBody
    public Object save(CgrkOrder cgrkorder, HttpServletRequest request) {
        int warehouseId = Integer.parseInt(request.getParameter("warehouse.id"));
        int medicineId = Integer.parseInt(request.getParameter("medicine.id"));
        int userId = Integer.parseInt(request.getParameter("user.id"));
        int agentClientId = Integer.parseInt(request.getParameter("agent.id"));
        int providerId = Integer.parseInt(request.getParameter("provider.id"));
        int commercialCompanyId = Integer.parseInt(request.getParameter("commercialcompany.id"));
        cgrkorder.setWarehouseId(warehouseId);
        cgrkorder.setMedicineId(medicineId);
        cgrkorder.setSysUserId(userId);
        cgrkorder.setAgentId(agentClientId);
        cgrkorder.setProviderId(providerId);
        cgrkorder.setCommercialCompanyId(commercialCompanyId);
        cgrkOrderService.save(cgrkorder);
        DWZResponseResult result = new DWZResponseResult();
        result.setMessage("保存成功");
        result.setCallbackType("closeCurrent");
        result.setForwardUrl("cgrkorder/list");
        result.setNavTabId("cgrkorder_list");
        return result;
    }

    @RequestMapping(value = "delete", method = {RequestMethod.POST})
    @ResponseBody
    public Object save(Integer[] ids) {
        cgrkOrderService.delete(ids);
        DWZResponseResult result = new DWZResponseResult();
        result.setMessage("删除成功");
        result.setForwardUrl("cgrkorder/list");
        result.setNavTabId("cgrkorder_list");
        return result;
    }

}
