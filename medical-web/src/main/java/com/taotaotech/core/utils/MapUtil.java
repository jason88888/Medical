package com.taotaotech.core.utils;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author Cailin.Chen
 * @Date 15/9/12
 * @eMail cailin618@sina.com
 */

public class MapUtil {

    public static void setValue(Map map,Object thisObj)
    {
        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext())
        {
            Object obj = iterator.next();
            Object val = map.get(obj);
//            setMethod(obj, val, thisObj);
        }
    }

    public static Map getValue(Object thisObj)
    {
        Map map = new HashMap();
        Class c;
        try
        {
            c = Class.forName(thisObj.getClass().getName());
            Method[] m = c.getMethods();
            for (int i = 0; i < m.length; i++)
            {
                String method = m[i].getName();
                if (method.startsWith("get") && !method.equals("getClass") )
                {
                    try{
                        Object value = m[i].invoke(thisObj);
                        if (value != null && !value.equals(""))
                        {
                            String key=method.substring(3);
                            key=key.substring(0,1).toLowerCase()+key.substring(1);
                            map.put(key, value);
                        }
                    }catch (Exception e) {
                        // TODO: handle exception
                        System.out.println("error:"+method);
                    }
                }
            }
        }
        catch (Exception e)
        {
            // TODO: handle exception
            e.printStackTrace();
        }
        return map;
    }
}
