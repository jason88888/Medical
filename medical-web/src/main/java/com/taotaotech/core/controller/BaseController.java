package com.taotaotech.core.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taotaotech.core.dto.ResponseResult;
import com.taotaotech.core.exception.BusinessException;
import com.taotaotech.core.exception.SystemErrorCode;
import com.taotaotech.core.utils.JsonUtil;
import com.taotaotech.core.utils.PropertiesUtil;
import com.taotaotech.domain.user.User;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.util.JSONPObject;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

/**
 * @author Cailin.Chen
 * @Date 15/8/23
 * @eMail cailin618@sina.com
 */

public abstract class BaseController {


    public static final String JSONRESULT = "jsonResult";

    @Autowired
    private HttpServletRequest request;


    protected String webPath;

    protected String imgPath;

    protected User user;




    public User getUser() {
        return (User)request.getSession().getAttribute("admin");
    }

    public void setUser(User user) {
        this.user = user;
    }

    /**
     * 所有的子类方法执行之前都要先执行此方法，子类方法不需要在model此方法中的参数
     * @param model
     * @desc platformUserName 微信/易信账号
     * @desc platformType 微信/易信类型 1:易信，2：微信
     */
    @ModelAttribute
    public void init(ModelMap model){
        model.addAttribute("webPath",getWebPath());
        model.addAttribute("basePath",getBasePath());
    }

    private String getWebPath() {
        return request.getContextPath() + File.separator;
    }


    public String getBasePath() {
        return request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
    }



    public String setResultArrayJson(String result, Object object)  {
        JSONArray jsonArray = new JSONArray();
        jsonArray.add(object);
        return jsonArray.toString();
    }


}
