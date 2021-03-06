package com.taotaotech.controller.order;

import com.taotaotech.core.controller.BaseController;
import com.taotaotech.core.dto.DWZResponseResult;
import com.taotaotech.core.persistence.Page;
import com.taotaotech.domain.CgrkOrder;
import com.taotaotech.domain.CgsqOrder;
import com.taotaotech.service.ICgsqOrderService;
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
@RequestMapping("cgsqorder")
public class CgsqOrderController  extends BaseController {
    @Autowired
    private ICgsqOrderService cgsqOrderService;
    @RequestMapping(value = "list", method = {RequestMethod.POST, RequestMethod.GET})
    public String list(ModelMap model,HttpServletRequest request, HttpServletResponse response) {
        Page<CgsqOrder> page = cgsqOrderService.findPage(new Page<CgsqOrder>(request, response), new CgsqOrder());
        model.addAttribute("page", page);
        return "cgsqorder/cgsqorder_list";
    }

    @RequestMapping(value = "insert", method = {RequestMethod.GET})
    public String add() {
        return "cgsqorder/cgsqorder_insert";
    }

    @RequestMapping(value = "edit", method = {RequestMethod.GET})
    public String edit(Integer id, Model model) {
        CgsqOrder cgsqorder = cgsqOrderService.get(id);
        model.addAttribute("cgsqorder", cgsqorder);
        return "cgsqorder/cgsqorder_edit";
    }

    @RequestMapping(value = "view", method = {RequestMethod.GET})
    public String view(Integer id, Model model) {
        CgsqOrder cgsqorder = cgsqOrderService.get(id);
        model.addAttribute("cgsqorder", cgsqorder);
        return "cgsqorder/cgsqorder_view";
    }

    @RequestMapping(value = "save", method = {RequestMethod.POST})
    @ResponseBody
    public Object save(CgsqOrder cgsqorder, HttpServletRequest request) {
        int medicineId = Integer.parseInt(request.getParameter("medicine.id"));
        int userId = Integer.parseInt(request.getParameter("user.id"));
        int providerId = Integer.parseInt(request.getParameter("provider.id"));
        cgsqorder.setMedicineId(medicineId);
        cgsqorder.setSysUserId(userId);
        cgsqorder.setProviderId(providerId);
        cgsqOrderService.save(cgsqorder);
        DWZResponseResult result = new DWZResponseResult();
        result.setMessage("保存成功");
        result.setCallbackType("closeCurrent");
        result.setForwardUrl("cgsqorder/list");
        result.setNavTabId("cgsqorder_list");
        return result;
    }

    @RequestMapping(value = "delete", method = {RequestMethod.POST})
    @ResponseBody
    public Object save(Integer[] ids) {
        cgsqOrderService.delete(ids);
        DWZResponseResult result = new DWZResponseResult();
        result.setMessage("删除成功");
        result.setForwardUrl("cgsqorder/list");
        result.setNavTabId("cgsqorder_list");
        return result;
    }
}
