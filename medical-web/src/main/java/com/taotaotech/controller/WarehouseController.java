package com.taotaotech.controller;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.taotaotech.core.controller.BaseController;
import com.taotaotech.core.dto.DWZResponseResult;
import com.taotaotech.core.persistence.Page;
import com.taotaotech.core.utils.MapUtil;
import com.taotaotech.domain.Agent;
import com.taotaotech.domain.Warehouse;
import com.taotaotech.domain.Warehouse;
import com.taotaotech.service.IWarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @author zk
 * @date 2015/9/4 10:36
 * @description
 */
@Controller
@RequestMapping("warehouse")
public class WarehouseController extends BaseController {
    @Autowired
    private IWarehouseService warehouseService;

    @RequestMapping(value = "list", method = {RequestMethod.POST, RequestMethod.GET})
    public String list(Warehouse warehouse, ModelMap model, HttpServletRequest request, HttpServletResponse response) {
        Page<Warehouse> page = warehouseService.findPage(new Page<Warehouse>(request, response), warehouse);
        String warehouseLevel = warehouse.getWarehouseLevel();
        if (StringUtils.isEmpty(warehouseLevel)){
            warehouseLevel = null;
        }
        model.addAttribute("page", page);
        model.addAttribute("warehouseLevel", warehouseLevel);
        return "warehouse/warehouse_list";
    }

    @RequestMapping(value = "firstList", method = {RequestMethod.POST, RequestMethod.GET})
    public String firstList(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
        Page<Warehouse> page = new Page<Warehouse>(request, response);
        Warehouse warehouse = new Warehouse();
        warehouse.setPage(page);
        Map map = MapUtil.bean2Map(warehouse);
        page.setList(warehouseService.findFirstWarehouseList(map, page.createPageBounds()));
        model.addAttribute("page", page);
        return "warehouse/warehouse_list";
    }

    @RequestMapping(value = "secondList", method = {RequestMethod.POST, RequestMethod.GET})
    public String secondList(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
        Page<Warehouse> page = new Page<Warehouse>(request, response);
        Warehouse warehouse = new Warehouse();
        warehouse.setPage(page);
        Map map = MapUtil.bean2Map(warehouse);
        page.setList(warehouseService.findSecondWarehouseList(map, page.createPageBounds()));
        model.addAttribute("page", page);
        return "warehouse/warehouse_list";
    }

    @RequestMapping(value = "insert", method = {RequestMethod.GET})
    public String add(String warehouseLevel,ModelMap modelMap) {
        modelMap.put("warehouseLevel",warehouseLevel);
        return "warehouse/warehouse_insert";
    }

    @RequestMapping(value = "edit", method = {RequestMethod.GET})
    public String edit(Integer id, Model model) {
        Warehouse warehouse = warehouseService.get(id);
        model.addAttribute("warehouse", warehouse);
        return "warehouse/warehouse_edit";
    }

    @RequestMapping(value = "view", method = {RequestMethod.GET})
    public String view(Integer id, Model model) {
        Warehouse warehouse = warehouseService.get(id);
        model.addAttribute("warehouse", warehouse);
        return "warehouse/warehouse_view";
    }

    @RequestMapping(value = "save", method = {RequestMethod.POST})
    @ResponseBody
    public Object save(Warehouse warehouse) {
        warehouseService.save(warehouse);
        DWZResponseResult result = new DWZResponseResult();
        result.setMessage("保存成功");
        result.setCallbackType("closeCurrent");
        result.setForwardUrl("warehouse/list?warehouseLevel=" + warehouse.getWarehouseLevel());
        result.setNavTabId("warehouse_list");
        return result;
    }

    @RequestMapping(value = "delete", method = {RequestMethod.POST})
    @ResponseBody
    public Object save(Integer[] ids,String warehouseLevel) {
        warehouseService.delete(ids);
        DWZResponseResult result = new DWZResponseResult();
        result.setMessage("删除成功");
        result.setForwardUrl("warehouse/list?warehouseLevel="+warehouseLevel);
        result.setNavTabId("warehouse_list");
        return result;
    }

    @RequestMapping(value = "lookup_suggest")
    @ResponseBody
    public List<Warehouse> lookupSuggest(String name) {
        Page<Warehouse> page = new Page<>(0, 10);
        Warehouse warehouse = new Warehouse();
        warehouse.setName(name);
        page = warehouseService.findPage(page, warehouse);
        return page.getList();
    }

    @RequestMapping(value = "lookup")
    public String lookup(Warehouse warehouse, HttpServletRequest request, HttpServletResponse response, Model model) {
        Page<Warehouse> page = warehouseService.findPage(new Page<Warehouse>(request, response), warehouse);
        model.addAttribute("page", page);
        return "warehouse/warehouse_lookup";
    }
}
