package com.gx.pagehelperdemo.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符过滤工具
 */
public class CharacterFilterUtil {

    public static final String DEFAULT_QUERY_REGEX = "[!$^&*+=|{}';'\",<>/?~！#￥%……&*——|{}【】‘；：”“'。，、？]";

    /**
     * 判断参数中是否有特殊字符，如果有特殊字符则返回true，否则返回false
     * @param value
     * @return
     * @see {@link #DEFAULT_QUERY_REGEX}
     */
    public static boolean specialSymbols(String value) {
        if ("".equals(value)) {
            return false;
        }
        Pattern pattern = Pattern.compile(DEFAULT_QUERY_REGEX);
        Matcher matcher = pattern.matcher(value);
        char[] specialSymbols = DEFAULT_QUERY_REGEX.toCharArray();
        boolean isWithSpecialSymbol = false; // 是否有特殊字符
        for (int i = 0; i < specialSymbols.length; i++) {
            char c = specialSymbols[i];
            if (value.indexOf(c) == 0) {
                isWithSpecialSymbol = true;
                break;
            }
        }
        return matcher.find() && isWithSpecialSymbol;
    }

}
