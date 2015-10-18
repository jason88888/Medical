package com.taotaotech.controller;

import com.taotaotech.core.controller.BaseController;
import com.taotaotech.core.dto.DWZResponseResult;
import com.taotaotech.core.dto.ResponseResult;
import com.taotaotech.domain.User;
import com.taotaotech.domain.User;
import com.taotaotech.service.IUserService;
import com.taotaotech.core.persistence.Page;
import org.apache.ibatis.annotations.Param;
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
 * @author Cailin.Chen
 * @Date 15/8/23
 * @eMail cailin618@sina.com
 */
@Controller
@RequestMapping("user")
public class UserController extends BaseController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "login", method = {RequestMethod.POST, RequestMethod.GET}, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Object login(@Param(value = "username") String username,
                        @Param(value = "password") String password) {

        User user = userService.login(username, password);

        ResponseResult result = new ResponseResult();
        result.setData(user);
        return result;
    }


    @RequestMapping(value = "list", method = {RequestMethod.POST, RequestMethod.GET}, produces = "application/json;charset=UTF-8")
    public String list(User user, HttpServletRequest request, HttpServletResponse response, Model model) {
        Page<User> page = userService.findPage(new Page<User>(request, response), user);
        model.addAttribute("page", page);
        return "user/user_list";
    }

    @RequestMapping(value = "form", method = {RequestMethod.GET})
    public String edit(Integer id, Model model) {
        if (id != null) {
            User user = userService.get(id);
            model.addAttribute("mser", user);
        }

        return "user/user_form";
    }

    @RequestMapping(value = "view", method = {RequestMethod.GET})
    public String view(Integer id, Model model) {
        User user = userService.get(id);
        model.addAttribute("user", user);

        return "user/user_view";
    }

    @RequestMapping(value = "save", method = {RequestMethod.POST})
    @ResponseBody
    public Object save(User user) {
        userService.save(user);

        DWZResponseResult result = new DWZResponseResult();
        result.setMessage("保存成功");
        result.setCallbackType("closeCurrent");
        result.setForwardUrl("user/list");
        result.setNavTabId("user_list");

        return result;
    }

    @RequestMapping(value = "delete", method = {RequestMethod.POST})
    @ResponseBody
    public Object save(Integer[] ids) {
        userService.delete(ids);

        DWZResponseResult result = new DWZResponseResult();
        result.setMessage("删除成功");
        result.setForwardUrl("user/list");
        result.setNavTabId("user_list");

        return result;
    }

    @RequestMapping(value = "lookup_suggest")
    @ResponseBody
    public List<User> lookupSuggest(String name) {
        Page<User> page = new Page<>(0, 10);
        User user = new User();
        user.setUsername(name);
        page = userService.findPage(page, user);
        return page.getList();
    }

    @RequestMapping(value = "lookup")
    public String lookup(User user, HttpServletRequest request, HttpServletResponse response, Model model) {
        Page<User> page = userService.findPage(new Page<User>(request, response), user);
        model.addAttribute("page", page);
        return "user/user_lookup";
    }
}
