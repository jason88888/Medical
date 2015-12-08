package com.taotaotech.controller.order;

import com.taotaotech.core.controller.BaseController;
import com.taotaotech.core.dto.DWZResponseResult;
import com.taotaotech.core.persistence.Page;
import com.taotaotech.domain.XsthOrder;
import com.taotaotech.service.IXsthOrderService;
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
@RequestMapping("xsthorder")
public class XsthOrderController extends BaseController {
    @Autowired
    private IXsthOrderService xsthOrderService;
    @RequestMapping(value = "list", method = {RequestMethod.POST, RequestMethod.GET})
    public String list(ModelMap model,HttpServletRequest request, HttpServletResponse response) {
        Page<XsthOrder> page = xsthOrderService.findPage(new Page<XsthOrder>(request, response), new XsthOrder());
        model.addAttribute("page", page);
        return "xsthorder/xsthorder_list";
    }

    @RequestMapping(value = "insert", method = {RequestMethod.GET})
    public String add() {
        return "xsthorder/xsthorder_insert";
    }

    @RequestMapping(value = "edit", method = {RequestMethod.GET})
    public String edit(Integer id, Model model) {
        XsthOrder xsthorder = xsthOrderService.get(id);
        model.addAttribute("xsthorder", xsthorder);
        return "xsthorder/xsthorder_edit";
    }

    @RequestMapping(value = "view", method = {RequestMethod.GET})
    public String view(Integer id, Model model) {
        XsthOrder xsthorder = xsthOrderService.get(id);
        model.addAttribute("xsthorder", xsthorder);
        return "xsthorder/xsthorder_view";
    }

    @RequestMapping(value = "save", method = {RequestMethod.POST})
    @ResponseBody
    public Object save(XsthOrder xsthorder, HttpServletRequest request) {
        int medicineId = Integer.parseInt(request.getParameter("medicine.id"));
        int userId = Integer.parseInt(request.getParameter("user.id"));
        xsthorder.setMedicineId(medicineId);
        xsthorder.setSysUserId(userId);
        xsthOrderService.save(xsthorder);
        DWZResponseResult result = new DWZResponseResult();
        result.setMessage("保存成功");
        result.setCallbackType("closeCurrent");
        result.setForwardUrl("xsthorder/list");
        result.setNavTabId("xsthorder_list");
        return result;
    }

    @RequestMapping(value = "delete", method = {RequestMethod.POST})
    @ResponseBody
    public Object save(Integer[] ids) {
        xsthOrderService.delete(ids);
        DWZResponseResult result = new DWZResponseResult();
        result.setMessage("删除成功");
        result.setForwardUrl("xsthorder/list");
        result.setNavTabId("xsthorder_list");
        return result;
    }
}
