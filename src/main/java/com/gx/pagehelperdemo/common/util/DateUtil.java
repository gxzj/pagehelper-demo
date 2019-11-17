package com.gx.pagehelperdemo.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间处理工具类
 */
public class DateUtil {

    /**
     * 返回指定格式时间字符串
     * patten参数例子：yyyy-MM-dd HH:mm:ss:SSS
     * @param date
     * @return
     */
    public static String date2standard(Date date, String patten){
        if(date != null){
            if("".equals(patten)){
                patten = "yyyy-MM-dd HH:mm:ss"; //默认格式
            }
            SimpleDateFormat sdf = new SimpleDateFormat(patten);
            return sdf.format(date);
        }
        return "";
    }

    /**
     * 返回时间长字符串，如：20181121004234537
     * @param date
     * @return
     */
    public static String date2longstr(Date date){
        if(date != null){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
            return sdf.format(date);
        }
        return "";
    }

    /**
     * 字符串转指定格式时间
     * patten参数例子：yyyy-MM-dd HH:mm:ss:SSS
     * @param strdate
     * @param patten
     * @return
     */
    public static Date str2date(String strdate, String patten) {
        if("".equals(patten)){
            patten = "yyyy-MM-dd HH:mm:ss"; //默认格式
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(patten);
            return sdf.parse(strdate);
        } catch (ParseException e) {
            return  null;
        }
    }

    public static void main(String[] args) {
        System.out.println(date2standard(new Date(),"yyyy-MM-dd HH:mm:ss:SSS"));
    }

}
