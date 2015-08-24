package com.taotaotech.core.controller;

import com.alibaba.fastjson.JSONObject;
import com.taotaotech.core.dto.ResponseResult;
import com.taotaotech.core.exception.BusinessException;
import com.taotaotech.core.exception.SystemErrorCode;
import com.taotaotech.core.utils.JsonUtil;
import com.taotaotech.core.utils.PropertiesUtil;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.util.JSONPObject;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Cailin.Chen
 * @Date 15/8/23
 * @eMail cailin618@sina.com
 */

public abstract class BaseController {

    private static final Logger log = Logger.getLogger(BaseController.class);
    @Autowired
    private PropertiesUtil propertiesUtil;

    /**
     * 业务性异常处理
     * @param ex  异常
     * @param request 请求
     * @param response  返回
     * @return
     */
    @ExceptionHandler(BusinessException.class)
    @ResponseBody
//    @ResponseStatus(HttpStatus.OK)
    public Object handlBusinessException(BusinessException ex,HttpServletRequest request,HttpServletResponse response){
        log.info(ex.getCode() + ":" + ex.getMessage());
        ResponseResult result = new ResponseResult();
        result.setMessage(ex.getMessage());
        result.setCode(ex.getCode());

//        return JsonUtil.clazz2Json(result);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("错误信息",ex.getMessage());
        response.setStatus(200);
        return "error,错误信息";
    }

/*
    @ExceptionHandler(UnauthorizedException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Object handleUnauthorizedException(UnauthorizedException ex,HttpServletRequest request,HttpServletResponse response){
        String callback = request.getParameter("callback");
        log.info(ex.getMessage(),ex);
        ResponseResult result = new ResponseResult();
        result.setMessage(SystemErrorCode.USER_NOTPRIVILEGE_ERROR.getMessage());
        result.setCode(SystemErrorCode.USER_NOTPRIVILEGE_ERROR.getCode());
        if (callback!=null){
            return new JSONPObject(callback,result);
        }
        return result;
    }
*/

    /**
     * 图片异常返回默认图片
     * @param ex
     * @param request
     * @param response
     * @return
     */

/*
    @ExceptionHandler(PictureException.class)
    @ResponseStatus(HttpStatus.OK)
    public void handlPictureException(PictureException ex,HttpServletRequest request,HttpServletResponse response){
        log.error(ex.getMessage(),ex);
        try {
            int group = (Integer)request.getAttribute("group");
            int width = (Integer)request.getAttribute("width");
            int height = (Integer)request.getAttribute("height");
            String defaultPictureRoot =propertiesUtil.readValue("PICTUREDEFROOT");
            String defaultName = null;
            switch (group){
                case 0:
                    defaultName = propertiesUtil.readValue("DEFUSERPICNAME");
                    break;
                case 1:
                    defaultName = propertiesUtil.readValue("DEFCOURSEPICNAME");
                    break;
                case 5:
                    defaultName = propertiesUtil.readValue("DEFIDCARDNAME");
                    break;
                case 6:
                    defaultName = propertiesUtil.readValue("DEFIDCARDNAME");
                default:

            }

            File file = new File(defaultPictureRoot);
            if (!file.exists()){
                file.mkdirs();
            }
            String pictureRoot = defaultPictureRoot+File.separator+defaultName;
            String type = defaultName.substring(defaultName.lastIndexOf(".")+1);
            BufferedImage image = null;
            if (type.equals("jpg")){
                type ="jpeg";
            }

            image = ImageIO.read(new File(pictureRoot));
            image = ImageCompressUtil.ImageCompressToDynamicAcquisition(image,1,width,height);
            OutputStream ops = response.getOutputStream();
            response.setContentType("image/"+type);
            ImageIO.write(image,type,ops);
            ops.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("默认图片不存在");
        }
    }
*/
    /**
     * 数据库异常处理
     * @param ex
     * @param request
     * @param response
     * @return
     */
    @ExceptionHandler(DataAccessException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Object handlDataAccessException(DataAccessException ex,HttpServletRequest request,HttpServletResponse response){
        String callback = request.getParameter("callback");
        log.error(ex.getMessage(),ex);
        Boolean isDebug = Boolean.parseBoolean(propertiesUtil.readValue("ISDEBUG"));
        String exceptionStr = "";
        if(isDebug){
            exceptionStr = ":"+ex.toString();
        }
        ResponseResult result = new ResponseResult();
        result.setCode(SystemErrorCode.DATABASE_ERROE.getCode());
        result.setMessage(SystemErrorCode.DATABASE_ERROE.getMessage()+exceptionStr);
        if (callback!=null){
            return new JSONPObject(callback,result);
        }
        return result;
    }

    /**
     * 缺少参数
     * @param ex
     * @param request
     * @param response
     * @return
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Object handlMissingServletRequestParameterException(MissingServletRequestParameterException ex,HttpServletRequest request,HttpServletResponse response){
        String callback = request.getParameter("callback");
        log.error(ex.getMessage(),ex);
        ResponseResult result = new ResponseResult();
        result.setCode(SystemErrorCode.PARAMETER_NOT_PRESENT.getCode());
        result.setMessage(ex.getParameterName()+":"+SystemErrorCode.PARAMETER_NOT_PRESENT.getMessage());
        if (callback != null){
            return new JSONPObject(callback,result);
        }
        return result;
    }

    @ExceptionHandler(TypeMismatchException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Object handlTypeMisMatchException(TypeMismatchException ex,HttpServletRequest request,HttpServletResponse response){
        String callback = request.getParameter("callback");
        log.error(ex.getMessage(),ex);
        Boolean isDebug = Boolean.parseBoolean(propertiesUtil.readValue("ISDEBUG"));
        String exceptionStr = "";
        if(isDebug){
            exceptionStr = ":"+ex.toString();
        }
        ResponseResult result = new ResponseResult();
        result.setCode(SystemErrorCode.PARAMETER_NOT_PRESENT.getCode());
        result.setMessage(SystemErrorCode.PARAMETER_NOT_PRESENT.getMessage()+exceptionStr);
        if (callback != null){
            return new JSONPObject(callback,result);
        }
        return result;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Object handlMethodArgumentNotValidException(MethodArgumentNotValidException ex,HttpServletRequest request,HttpServletResponse response){
        String callback = request.getParameter("callback");
        log.error(ex.getMessage(),ex);
        Boolean isDebug = Boolean.parseBoolean(propertiesUtil.readValue("ISDEBUG"));
        String exceptionStr = "";
        if(isDebug){
            exceptionStr = ":"+ex.toString();
        }
        ResponseResult result = new ResponseResult();
        result.setCode(SystemErrorCode.PARAMETER_NOT_PRESENT.getCode());
        result.setMessage(SystemErrorCode.PARAMETER_NOT_PRESENT.getMessage()+exceptionStr);
        if (callback != null){
            return new JSONPObject(callback,result);
        }
        return result;
    }
    /**
     * 空指针异常处理
     * @param ex
     * @param request
     * @param response
     * @return
     */
    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Object handlBusinessException(NullPointerException ex,HttpServletRequest request,HttpServletResponse response){
        String callback = request.getParameter("callback");
        log.error(ex.getMessage(),ex);
        Boolean isDebug = Boolean.parseBoolean(propertiesUtil.readValue("ISDEBUG"));
        String exceptionStr = "";
        if(isDebug){
            exceptionStr = ":"+ex.toString();
        }
        ResponseResult result = new ResponseResult();
        result.setCode(SystemErrorCode.NULLPOINTER_ERROR.getCode());
        result.setMessage(SystemErrorCode.NULLPOINTER_ERROR.getMessage()+exceptionStr);
        if (callback!=null){
            return new JSONPObject(callback,result);
        }
        return result;
    }

    /**
     * 数组越界异常
     * @param ex
     * @param request
     * @param response
     * @return
     */
    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Object handlBusinessException(ArrayIndexOutOfBoundsException ex,HttpServletRequest request,HttpServletResponse response){
        String callback = request.getParameter("callback");
        log.error(ex.getMessage(),ex);
        ResponseResult result = new ResponseResult();
        result.setCode(SystemErrorCode.ARRAY_INDEXOUTOF_ERROR.getCode());
        result.setMessage(SystemErrorCode.ARRAY_INDEXOUTOF_ERROR.getMessage());
        if (callback!=null){
            return new JSONPObject(callback,result);
        }
        return result;
    }

    /**
     * 系统运行时异常
     * @param ex
     * @param request
     * @param response
     * @return
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Object handlException(RuntimeException ex ,HttpServletRequest request,HttpServletResponse response){
        String callback = request.getParameter("callback");
        log.error(ex.getMessage(),ex);
        Boolean isDebug = Boolean.parseBoolean(propertiesUtil.readValue("ISDEBUG"));
        String exceptionStr = "";
        if(isDebug){
            exceptionStr = ":"+ex.toString();
        }
        ResponseResult result = new ResponseResult();
        result.setMessage(SystemErrorCode.RUNTIME_ERROR.getMessage()+exceptionStr);
        result.setCode(SystemErrorCode.RUNTIME_ERROR.getCode());
        if (callback !=null){
            return new JSONPObject(callback,result);
        }
        return result;
    }

    /**
     * 系统异常
     * @param ex
     * @param request
     * @param response
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Object handlException(Exception ex ,HttpServletRequest request,HttpServletResponse response){
        String callback = request.getParameter("callback");
        log.error(ex.getMessage(),ex);
        Boolean isDebug = Boolean.parseBoolean(propertiesUtil.readValue("ISDEBUG"));
        String exceptionStr = "";
        if(isDebug){
            exceptionStr = ":"+ex.toString();
        }
        ResponseResult result = new ResponseResult();
        result.setMessage(SystemErrorCode.SYSTME_ERROR.getMessage()+exceptionStr);
        result.setCode(SystemErrorCode.SYSTME_ERROR.getCode());
        if (callback!=null){
            return new JSONPObject(callback,result);
        }
        return result;
    }



}
