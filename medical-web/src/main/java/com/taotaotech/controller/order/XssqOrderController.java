package com.taotaotech.controller.order;

import com.taotaotech.core.controller.BaseController;
import com.taotaotech.core.dto.DWZResponseResult;
import com.taotaotech.core.persistence.Page;
import com.taotaotech.domain.XssqOrder;
import com.taotaotech.service.IXssqOrderService;
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
@RequestMapping("xssqorder")
public class XssqOrderController extends BaseController {
    @Autowired
    private IXssqOrderService xssqOrderService;
    @RequestMapping(value = "list", method = {RequestMethod.POST, RequestMethod.GET})
    public String list(ModelMap model,HttpServletRequest request, HttpServletResponse response) {
        Page<XssqOrder> page = xssqOrderService.findPage(new Page<XssqOrder>(request, response), new XssqOrder());
        model.addAttribute("page", page);
        return "xssqorder/xssqorder_list";
    }

    @RequestMapping(value = "insert", method = {RequestMethod.GET})
    public String add() {
        return "xssqorder/xssqorder_insert";
    }

    @RequestMapping(value = "edit", method = {RequestMethod.GET})
    public String edit(Integer id, Model model) {
        XssqOrder xssqorder = xssqOrderService.get(id);
        model.addAttribute("xssqorder", xssqorder);
        return "xssqorder/xssqorder_edit";
    }

    @RequestMapping(value = "view", method = {RequestMethod.GET})
    public String view(Integer id, Model model) {
        XssqOrder xssqorder = xssqOrderService.get(id);
        model.addAttribute("xssqorder", xssqorder);
        return "xssqorder/xssqorder_view";
    }

    @RequestMapping(value = "save", method = {RequestMethod.POST})
    @ResponseBody
    public Object save(XssqOrder xssqorder, HttpServletRequest request) {
        int medicineId = Integer.parseInt(request.getParameter("medicine.id"));
        int userId = Integer.parseInt(request.getParameter("user.id"));
        xssqorder.setMedicineId(medicineId);
        xssqorder.setSysUserId(userId);
        xssqOrderService.save(xssqorder);
        DWZResponseResult result = new DWZResponseResult();
        result.setMessage("保存成功");
        result.setCallbackType("closeCurrent");
        result.setForwardUrl("xssqorder/list");
        result.setNavTabId("xssqorder_list");
        return result;
    }

    @RequestMapping(value = "delete", method = {RequestMethod.POST})
    @ResponseBody
    public Object save(Integer[] ids) {
        xssqOrderService.delete(ids);
        DWZResponseResult result = new DWZResponseResult();
        result.setMessage("删除成功");
        result.setForwardUrl("xssqorder/list");
        result.setNavTabId("xssqorder_list");
        return result;
    }
}
