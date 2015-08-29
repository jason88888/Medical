package com.taotaotech.controller;

import com.taotaotech.core.dto.ResponseResult;
import com.taotaotech.service.IBillService;
import com.taotaotech.service.IPolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

/**
 * @author Cailin.Chen
 * @Date 15/8/27
 * @eMail cailin618@sina.com
 */

@Controller
@RequestMapping("upload")
public class UploadController {

    @Autowired
    private IPolicyService policyService;

    @Autowired
    private IBillService billService;

    @RequestMapping(value="policy", method= RequestMethod.POST)
    @ResponseBody
    public ResponseResult importPolicy(@RequestParam("file") MultipartFile file){
        return policyService.parsePolicyTable(file);
    }

    @RequestMapping(value="bill", method= RequestMethod.POST)
    @ResponseBody
    public ResponseResult importBill(@RequestParam("file") MultipartFile file){
        return billService.parseBillTable(file);
    }


}
