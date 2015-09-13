package com.taotaotech.core.utils;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Cailin.Chen
 * @Date 15/9/12
 * @eMail cailin618@sina.com
 */

public class MapUtil {

    // TODO: 对象转实体类待实现，我看之前没有实现，直接删掉了
    public static void map2Bean(Map map, Object bean) {
    }

    public static Map bean2Map(Object bean) {
        Map map = new HashMap();
        Class c;
        try {
            c = Class.forName(bean.getClass().getName());
            Method[] methods = c.getMethods();
            for (Method method : methods) {
                if (method.getName().startsWith("get")) {
                    String field = method.getName();
                    field = field.substring(field.indexOf("get") + 3);
                    field = field.toLowerCase().charAt(0) + field.substring(1);
                    Object value = method.invoke(bean, (Object[]) null);
                    map.put(field, value);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    public static void main(String[] args) {
        Person person = new Person();
        person.setAge(18);
        person.setName("小林zi");
        System.out.println(bean2Map(person));
    }
}

class Person {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
