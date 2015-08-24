package com.taotaotech.core.utils;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * @author Cailin.Chen
 * @Date 15/8/23
 * @eMail cailin618@sina.com
 */

public class JsonUtil {

    public static String clazz2Json(Object object){
       return JSONObject.toJSONString(object, SerializerFeature.WriteMapNullValue);
    }
}
