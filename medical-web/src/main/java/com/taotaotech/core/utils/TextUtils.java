package com.taotaotech.core.utils;

/**
 * @author zk
 * @date 2015/10/10 11:52
 * @description
 */
public class TextUtils {
    /**
     * 判断字符串是否为空
     * @param str
     * @return
     */
    public static boolean isEmpty(CharSequence str) {
        if (str == null || str.length() == 0)
            return true;
        else
            return false;
    }
}
