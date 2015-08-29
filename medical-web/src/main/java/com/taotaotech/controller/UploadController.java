package com.taotaotech.controller;

import com.taotaotech.core.dto.ResponseResult;
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

    @RequestMapping(value="policy", method= RequestMethod.POST)
    @ResponseBody
    public ResponseResult handleFileUpload(@RequestParam("file") MultipartFile file){
        return policyService.parsePolicyTable(file);
    }


    @RequestMapping(value="/batch/upload", method= RequestMethod.POST)
    public @ResponseBody
    String handleFileUpload(HttpServletRequest request){
        List<MultipartFile> files = ((MultipartHttpServletRequest)request).getFiles("file");
        for (int i =0; i< files.size(); ++i) {
            MultipartFile file = files.get(i);
            String name = file.getName();
            if (!file.isEmpty()) {
                try {
                    byte[] bytes = file.getBytes();
                    BufferedOutputStream stream =
                            new BufferedOutputStream(new FileOutputStream(new File(name + i)));
                    stream.write(bytes);
                    stream.close();
                } catch (Exception e) {
                    return "You failed to upload " + name + " => " + e.getMessage();
                }
            } else {
                return "You failed to upload " + name + " because the file was empty.";
            }
        }
        return "upload successful";
    }

}
