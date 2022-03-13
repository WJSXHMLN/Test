package com.xxxx.util;
/*
* 字符串工具类
*       判断字符串是否为空
*           空返回true
*          非空返回false
* */
public class StringUtil {
    public static boolean isEmpty(String str){
        if(str == null || "".equals(str.trim())){
            return true;
        }
        return false;
    }
}
