package com.taotaotech.core.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author Cailin.Chen
 * @Date 15/8/23
 * @eMail cailin618@sina.com
 */

public class PropertiesUtil {

    private Properties properties = null;

    public PropertiesUtil(String fileName){
        properties = new Properties();
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream(fileName)));
            properties.load(in);
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readValue(String key){
        return properties.getProperty(key);
    }

    public Map<String,String> readAllProperties(){
        Map<String,String> map= new HashMap<String, String>();
        Enumeration en = properties.propertyNames();
        while (en.hasMoreElements()){
            String key = (String) en.nextElement();
            String property = properties.getProperty(key);
            map.put(key,property);
        }
        return map;
    }

    public Boolean containsKey(String key){
        return properties.containsKey(key);
    }

}
