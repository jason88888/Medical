package com.taotaotech.controller.order;

import com.taotaotech.core.controller.BaseController;
import com.taotaotech.core.dto.DWZResponseResult;
import com.taotaotech.core.persistence.Page;
import com.taotaotech.domain.XsckOrder;
import com.taotaotech.service.IXsckOrderService;
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
 * Created by delll on 2015/11/19.
 */
@Controller
@RequestMapping("xsckorder")
public class XsckOrderController extends BaseController {
    @Autowired
    private IXsckOrderService xsckOrderService;

    @RequestMapping(value = "list", method = {RequestMethod.POST, RequestMethod.GET})
    public String list(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
        Page<XsckOrder> page = xsckOrderService.findPage(new Page<XsckOrder>(request, response), new XsckOrder());
        model.addAttribute("page", page);
        return "xsckorder/xsckorder_list";
    }

    @RequestMapping(value = "insert", method = {RequestMethod.GET})
    public String add() {
        return "xsckorder/xsckorder_insert";
    }

    @RequestMapping(value = "edit", method = {RequestMethod.GET})
    public String edit(Integer id, Model model) {
        XsckOrder xsckorder = xsckOrderService.get(id);
        model.addAttribute("xsckorder", xsckorder);
        return "xsckorder/xsckorder_edit";
    }

    @RequestMapping(value = "view", method = {RequestMethod.GET})
    public String view(Integer id, Model model) {
        XsckOrder xsckorder = xsckOrderService.get(id);
        model.addAttribute("xsckorder", xsckorder);
        return "xsckorder/xsckorder_view";
    }

    @RequestMapping(value = "save", method = {RequestMethod.POST})
    @ResponseBody
    public Object save(XsckOrder xsckorder, HttpServletRequest request) {
        int warehouseId = Integer.parseInt(request.getParameter("warehouse.id"));
        int medicineId = Integer.parseInt(request.getParameter("medicine.id"));
        int userId = Integer.parseInt(request.getParameter("user.id"));
        int agentClientId = Integer.parseInt(request.getParameter("agent.id"));
        int commercialCompanyId = Integer.parseInt(request.getParameter("commercialcompany.id"));
        xsckorder.setWarehouseId(warehouseId);
        xsckorder.setMedicineId(medicineId);
        xsckorder.setSysUserId(userId);
        xsckorder.setAgentId(agentClientId);
        xsckorder.setCommercialCompanyId(commercialCompanyId);
        xsckOrderService.save(xsckorder);
        DWZResponseResult result = new DWZResponseResult();
        result.setMessage("保存成功");
        result.setCallbackType("closeCurrent");
        result.setForwardUrl("xsckorder/list");
        result.setNavTabId("xsckorder_list");
        return result;
    }

    @RequestMapping(value = "delete", method = {RequestMethod.POST})
    @ResponseBody
    public Object save(Integer[] ids) {
        xsckOrderService.delete(ids);
        DWZResponseResult result = new DWZResponseResult();
        result.setMessage("删除成功");
        result.setForwardUrl("xsckorder/list");
        result.setNavTabId("xsckorder_list");
        return result;
    }
}
