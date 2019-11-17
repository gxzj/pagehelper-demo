package com.gx.pagehelperdemo.common.util;

/**
 * 通用工具类
 */
public class CommonUtil {

    /**
     * 判断字符串非空判断
     * @param string
     * @return
     */
    public static boolean isNotNull(String string){
        if(string == null && "".equals(string)){
            return false;
        }
        return true;
    }



}
