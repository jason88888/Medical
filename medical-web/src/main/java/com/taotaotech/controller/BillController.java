package com.taotaotech.controller;

import com.taotaotech.core.controller.BaseController;
import com.taotaotech.core.dto.DWZResponseResult;
import com.taotaotech.core.utils.DateUtil;
import com.taotaotech.domain.Bill;
import com.taotaotech.domain.Client;
import com.taotaotech.domain.Medicine;
import com.taotaotech.domain.User;
import com.taotaotech.service.IBillService;
import com.taotaotech.core.persistence.Page;
import com.taotaotech.service.IClientService;
import com.taotaotech.service.IMedicineService;
import com.taotaotech.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("bill")
public class BillController extends BaseController {

    @Autowired
    public IBillService billService;
    @Autowired
    public IClientService clientService;
    @Autowired
    public IMedicineService medicineService;
    @Autowired
    public IUserService userService;

    @RequestMapping(value = "list", method = {RequestMethod.POST, RequestMethod.GET})
    public String list(HttpServletRequest request, HttpServletResponse response, ModelMap model) {

        Map map = new HashMap();
        if(getUser().getRole() != 1){
            map.put("userCode", getUser().getCode());
        }
        Page<Bill> page =  billService.findBillList(new Page<Bill>(request, response),map);
        model.addAttribute("page", page);
        return "bill/bill_list";
    }

    @RequestMapping(value = "upload", method = {RequestMethod.GET})
    public String upload() {
        return "bill/bill_upload";
    }

    @RequestMapping(value = "upload", method = {RequestMethod.POST})
    @ResponseBody
    public Object uploadSave(@RequestParam("file") MultipartFile file) {
        return billService.parseBillTable(file);
    }


    @RequestMapping(value = "insert", method = {RequestMethod.GET})
    public String add(Model model) {

        List<Client> clients = clientService.findClientList();
        List<Medicine> medicines = medicineService.findMedicineList();
        List<User> salesmen = userService.findList(new User());

        model.addAttribute("clients", clients);
        model.addAttribute("medicines", medicines);
        model.addAttribute("salesmen", salesmen);
        return "bill/bill_insert";
    }


    @RequestMapping(value = "edit", method = {RequestMethod.GET})
    public String edit(Integer id, Model model) {
        Bill bill = billService.get(id);
        if (!DateUtil.isCurrentMonth(bill.getDate(), "yyyy-MM-dd")){
            model.addAttribute("msg","非当月数据不能修改");
            return "error/error";
        }

        List<Client> clients = clientService.findClientList();
        List<Medicine> medicines = medicineService.findMedicineList();
        List<User> salesmen = userService.findList(new User());
        model.addAttribute("bill", bill);
        model.addAttribute("clients", clients);
        model.addAttribute("medicines", medicines);
        model.addAttribute("salesmen", salesmen);

        return "bill/bill_edit";
    }


    @RequestMapping(value = "save", method = {RequestMethod.POST})
    @ResponseBody
    public Object save(Bill bill) {
        DWZResponseResult result = new DWZResponseResult();
        if (!DateUtil.isCurrentMonth(bill.getDate(),"yyyy-MM-dd")){
            result.setStatusCode("300");
            result.setMessage("非当月数据不能保存");
        }else {

            billService.save(bill);
            result.setMessage("保存成功");
        }

        result.setCallbackType("closeCurrent");
        result.setForwardUrl("bill/list");
        result.setNavTabId("bill_list");

        return result;
    }

    @RequestMapping(value = "delete", method = {RequestMethod.POST})
    @ResponseBody
    public Object delete(Integer[] ids, Model model) {

        DWZResponseResult result = new DWZResponseResult();
        if (billService.hasNotCurrentMonthData(ids)){
            result.setStatusCode("300");
            result.setMessage("包含非当月数据，不能删除");
        }else {
            billService.delete(ids);
            result.setMessage("删除成功");
        }
        result.setForwardUrl("bill/list");
        result.setNavTabId("bill_list");

        return result;
    }
}
